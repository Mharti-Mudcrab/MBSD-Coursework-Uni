import { StoryNode, Transition, NodeType, Condition, StateChange, StoryData, ChoiceOption } from "../types";
import { ConditionParser } from "./conditionParser";

export class StoryBuilder {

    private nodes: Record<string, StoryNode> = {};
    private name: string = "";
    private startNodeId: string = "";

    private lastAddedNodeId: string | null = null;
    private lastAddedOption: ChoiceOption | null = null;

    public Story(name: string): this {
        this.name = name;
        return this;
    }

    private addNode(id: string, type: NodeType, displayText: string, extra = {}, x = 0, y = 0): this {
        this.nodes[id] = {
            id, type, position: { x, y }, data: { label: id, displayText, ...extra }
        }
        this.lastAddedNodeId = id;
        this.lastAddedOption = null;

        if (type === 'start')
            this.startNodeId = id;

        return this;
    }


    public Start(id: string, displayText: string, x = 0, y = 0): this {
        return this.addNode(id, 'start', displayText, {}, x, y);
    }
    public Dialogue(id: string, displayText: string, x = 0, y = 0): this {
        return this.addNode(id, 'dialogue', displayText, {}, x, y);
    }
    public Choice(id: string, displayText: string, x = 0, y = 0): this {
        return this.addNode(id, 'choice', displayText, { choices: [] }, x, y);
    }
    public End(id: string, displayText: string, x = 0, y = 0): this {
        return this.addNode(id, 'end', displayText, {}, x, y);
    }

    public ChoiceOption(displayText: string): this {
        const node = this.nodes[this.lastAddedNodeId || ""];
        if (node?.type !== 'choice')
            throw new Error("Cannot add choice option to non-choice node");
        else {
            const newOption: ChoiceOption = { displayText, transitions: [] };
            node.data.choices!.push(newOption);
            this.lastAddedOption = newOption;
            
        }
        return this;
    }

    public Transition(targetNodeId: string, priority: number = 0, conditionStr?: string): this {

        const condition = conditionStr ? ConditionParser.parse(conditionStr) : undefined;
        const t: Transition = { targetNodeId, condition, priority};

        if (this.lastAddedOption) {
            this.lastAddedOption.transitions.push(t);
        } else if (this.lastAddedNodeId) {
            const node = this.nodes[this.lastAddedNodeId];
            
            if (node.type === 'choice') {
                throw new Error(`Node ${node.id} is a choice node. Transitions should be added to its options, not the node itself.`);
            }

            if (!node.data.transitions) node.data.transitions = [];
            node.data.transitions.push(t);


        }
        return this;
    }


    public StateChange(id: string, displayText: string, changeStr: string, x = 0, y = 0): this {
        const stateChanges = changeStr.split(',').map(change => {
            const str = change.trim();
            const match = str.match(/^(\w+)\s*(=|\+=|-=)\s*(-?\d+)$/); // thanks ai
                if (!match)
                    throw new Error(`Invalid state change format: "${str}". Expected format: variable operator value (e.g. "health -= 10")`);
        

                return {
                    variable: match[1],
                    operator: match[2] as any,
                    value: parseInt(match[3], 10)
                }

        });

        return this.addNode(id, 'stateChange', displayText, { stateChanges }, x, y);

    }


    public build() {
        if (!this.startNodeId) {
            throw new Error("Story must have a start node");
        }
        
        return {
            name: this.name,
            nodes: this.nodes,
            startNodeId: this.startNodeId
         };
    }





}