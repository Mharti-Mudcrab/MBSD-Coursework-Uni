import { StoryEngine } from "./model/StoryEngine";
import { StoryData, SystemState, StoryNode } from "./types";


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

    private processCurrentNode() {
        let node = this.getCurrentNode();

        if (node) {
            this.logs.push(`${node.data.displayText}`);
        }

        if (node.type !== 'choice' && node.type !== 'end') {
            this.state = this.engine.step(this.state);

            this.processCurrentNode();
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
