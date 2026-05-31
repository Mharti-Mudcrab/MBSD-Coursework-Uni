import { StoryEngine } from "./model/StoryEngine";
import type { StoryData, SystemState, StoryNode } from "./types";


export class StoryRunner {

    private engine: StoryEngine;
    private state: SystemState;
    public logs: string[] = [];
    public takenTransitionIds: string[] = [];


    constructor(story: StoryData) {
        this.engine = new StoryEngine(story);
        this.state = {
            currentNodeId: story.startNodeId,
            variables: {}
        };

        this.processCurrentNode();

    }

    private processCurrentNode() {
        let steps = 0;
        const MAX_STEPS = 50;
        let node = this.getCurrentNode();

        if (!node) {
            this.logs.push("Error: Start Node does not exist. Execution stopped.");
            return;
        }

        this.logs.push(`${node.data.displayText}`);

        while (node && node.type !== 'choice' && node.type !== 'end') {
            const prevNodeId = this.state.currentNodeId;
            const prevTransitions = node.data.transitions || [];

            this.state = this.engine.step(this.state);

            if (this.state.currentNodeId === prevNodeId) {
                this.logs.push("(No transitions available — the story pauses here.)");
                return;
            }

            // Record the exact transition the engine took (highest-priority valid one).
            const takenIndex = prevTransitions
                .map((t, i) => ({ t, i }))
                .filter(({ t }) => this.engine.checkCondition(t.condition, this.state.variables))
                .sort((a, b) => (b.t.priority || 0) - (a.t.priority || 0))[0]?.i;
            if (takenIndex !== undefined) {
                this.takenTransitionIds.push(`${prevNodeId}-${takenIndex}`);
            }

            node = this.getCurrentNode();
            if (node) {
                this.logs.push(node.data.displayText);
            } else {
                this.logs.push("Error: Node being transitioned to does not exist. Execution stopped.");
                return;
            }

            steps++;
            if (steps > MAX_STEPS) {
                this.logs.push("Error: Infinite Loop Detected");
                return;
            }
        }

    }

    public getAvailableChoices(): string[] {
        const node = this.getCurrentNode();
        if (!node) {
            this.logs.push("Error: Current node does not exist. Execution stopped.");
            return [];
        }

        if (node.type !== 'choice') return [];

        return node.data.choices
            .filter(opt => {
                const validTransition = opt.transitions.find(t => this.engine.checkCondition(t.condition, this.state.variables));
                return !!validTransition;
            })
            .map(opt => opt.displayText);
    }

    public handleChoice(choiceText: string) {
        const node = this.getCurrentNode();
        if (!node || node.type !== 'choice') {
            this.logs.push("Error: Current node no longer exists.");
            return;
        }

        const choices = node.data.choices;
        const optionIndex = choices.findIndex(opt => opt.displayText === choiceText);
        if (optionIndex >= 0) {
            const transitions = choices[optionIndex].transitions;
            const takenIndex = transitions
                .map((t, i) => ({ t, i }))
                .filter(({ t }) => this.engine.checkCondition(t.condition, this.state.variables))
                .sort((a, b) => (b.t.priority || 0) - (a.t.priority || 0))[0]?.i;
            if (takenIndex !== undefined) {
                this.takenTransitionIds.push(`${node.id}-option-${optionIndex}-${takenIndex}`);
            }
        }

        this.state = this.engine.step(this.state, choiceText);
        this.processCurrentNode();
    }

    public getCurrentNode(): StoryNode | undefined {
        return this.engine.getNode(this.state.currentNodeId);
    }

    public getVariables() {
        return this.state.variables;
    }

}
