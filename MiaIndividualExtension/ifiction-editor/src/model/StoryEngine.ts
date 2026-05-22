import type { StoryData, SystemState, StoryNode, Condition, Transition, StateChange } from "../types";

export class StoryEngine {
    private story: StoryData;

    constructor(story: StoryData) {
        this.story = story;
    }

    public step(currentState: SystemState, inputOptionText?: string): SystemState {
        const node = this.story.nodes[currentState.currentNodeId];

        if (!node || node.type === 'end') {
            return currentState; // No more steps possible
        }

        const updatedVariables = this.applyNodeLogic(node, currentState.variables);

        const nextNodeId = this.determineNextNode(node, updatedVariables, inputOptionText);

        return {
            variables: updatedVariables,
            currentNodeId: nextNodeId ?? currentState.currentNodeId
        };
    }
    

    private applyNodeLogic(node: StoryNode, variables: Record<string, number>): Record<string, number> {
        const newVars = { ...variables };

        if (node.type === 'stateChange' && node.data.stateChanges) {
            node.data.stateChanges.forEach((change: StateChange) => {
                const currentVal = newVars[change.variable] || 0;
                if (change.operator === '=') newVars[change.variable] = change.value;
                if (change.operator === '+=') newVars[change.variable] = currentVal + change.value;
                if (change.operator === '-=') newVars[change.variable] = currentVal - change.value;
            });

        }
        return newVars;
    }

    private determineNextNode(node: StoryNode, variables: Record<string, number>, input?: string): string | null {
        if (node.type === 'choice'){
            if (!input) return null;
            const option = node.data.choices?.find(opt => opt.displayText === input);
            return option ? this.evaluateTransitions(option.transitions, variables) : null;
        }

        return this.evaluateTransitions(node.data.transitions || [], variables);
    }

    private evaluateTransitions(transitions: Transition[], variables: Record<string, number>): string | null {
        const validTransitions = transitions
            .filter(t => this.checkCondition(t.condition as any, variables))
            // Type-unsafe. Keep an eye on this.
            .sort((a,b) => (b.priority || 0) - (a.priority || 0)); // Higher priority first

            return validTransitions.length > 0 ? validTransitions[0].targetNodeId : null;
    }

    public checkCondition(condition: Condition | undefined, variables: Record<string, number>): boolean {
        if (!condition) return true;

        if (typeof condition !== 'object' || !(condition as any).type) {
            return false;
        }

        if (condition.type === 'comparison') {
            if (
                typeof condition.variable !== 'string' ||
                condition.variable.trim() === '' ||
                typeof condition.value !== 'number' ||
                !Number.isFinite(condition.value)
            ) {
                return false;
            }
            const val = variables[condition.variable] || 0;
            switch (condition.operator) {
                case '==': return val === condition.value;
                case '!=': return val !== condition.value;
                case '<': return val < condition.value;
                case '>': return val > condition.value;
                case '<=': return val <= condition.value;
                case '>=': return val >= condition.value;
                default: return false;
            }
        }

        // Type-unsafe codesmell. Keep an eye on this.
            else if (condition.type === 'and') {
                if (!(condition as any).left || !(condition as any).right) return false;
                return this.checkCondition((condition as any).left, variables) && this.checkCondition((condition as any).right, variables);
            }
            else if (condition.type === 'or') {
                if (!(condition as any).left || !(condition as any).right) return false;
                return this.checkCondition((condition as any).left, variables) || this.checkCondition((condition as any).right, variables);
            }
            else if (condition.type === 'parentheses')
                return !!(condition as any).condition && this.checkCondition((condition as any).condition, variables);

            else return false;

    }





}