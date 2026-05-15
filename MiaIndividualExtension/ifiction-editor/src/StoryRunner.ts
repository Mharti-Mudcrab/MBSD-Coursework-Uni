import { StoryEngine } from "./model/StoryEngine";
import type { StoryData, SystemState, StoryNode } from "./types";


export class StoryRunner {

    private engine: StoryEngine;
    private state: SystemState;
    public logs: string[] = [];


    constructor(story: StoryData) {
        this.engine = new StoryEngine(story);
        this.state = {
            currentNodeId: story.startNodeId,
            variables: {}
        };

        this.processCurrentNode();

    }

    private TransitionsExist(node: StoryNode): boolean {
            if (!node.data.transitions || node.data.transitions?.length == 0) {
                this.logs.push("Error: No valid nodes to transition to.");
                return false;
            }
            return true;
    }

    private processCurrentNode() {
        let steps = 0;
        const MAX_STEPS = 50;
        let node = this.getCurrentNode();

        if (node && steps === 0) {
            this.logs.push(`${node.data.displayText}`);
            console.log(this.TransitionsExist)
            if (!this.TransitionsExist) return;
        }

        
        

        while ( node && node.type !== 'choice' && node.type !== 'end') {
            this.state = this.engine.step(this.state);
            node = this.getCurrentNode();
            if (node) {
                this.logs.push(node.data.displayText);
            }

            if (!this.TransitionsExist) return;

            steps++;
            if (steps > MAX_STEPS) {
                this.logs.push("Error: Infinite Loop Detected");
                return;
            }
            
        }

    }

    public getAvailableChoices(): string[] {
        const node = this.getCurrentNode();
        if (node.type !== 'choice') return [];

        return (node.data.choices || [])
            .filter(opt => {
                const validTransition = opt.transitions.find(t => (this.engine as any).checkCondition(t.condition, this.state.variables));

                return !!validTransition;

            })
            .map(opt => opt.displayText);
        }

        public handleChoice(choiceText: string) {
            this.state = this.engine.step(this.state, choiceText);
            this.processCurrentNode();
        }

        public getCurrentNode(): StoryNode {
            return this.engine['story'].nodes[this.state.currentNodeId];
        }

        public getVariables() {
            return this.state.variables;
        }

}
