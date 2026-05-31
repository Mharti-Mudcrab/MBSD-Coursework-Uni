export type NodeType = 'start' | 'dialogue' | 'choice' | 'stateChange' | 'end';

interface BaseNodeData {
    label: string;
    displayText: string;
}

export interface NodePosition {
    x: number;
    y: number;
}

export interface StoryData {
    name: string;
    nodes: Record<string, StoryNode>;
    startNodeId: string;
}

export interface Transition {
    targetNodeId: string;
    condition?: Condition;
    priority?: number;
}

export interface ChoiceOption {
    displayText: string;
    transitions: Transition[];
}

export type StoryNode =
    | { id: string; type: 'start';       data: BaseNodeData & { transitions?: Transition[] } }
    | { id: string; type: 'dialogue';    data: BaseNodeData & { transitions?: Transition[] } }
    | { id: string; type: 'choice';      data: BaseNodeData & { transitions?: Transition[]; choices: ChoiceOption[] } }
    | { id: string; type: 'stateChange'; data: BaseNodeData & { transitions?: Transition[]; stateChanges: StateChange[] } }
    | { id: string; type: 'end';         data: BaseNodeData & { transitions?: Transition[] } };

export type Operator = '==' | '!=' | '<' | '>' | '<=' | '>=';

export interface Comparison {
    type: 'comparison';
    operator: Operator;
    variable: string;
    value: number;
}

export interface LogicalGroup {
    type: 'and' | 'or';
    left: Condition;
    right: Condition;
}

export type ParenthesizedCondition = {
    type: 'parentheses';
    condition: Condition;
}

export type Condition =
    | Comparison
    | LogicalGroup
    | ParenthesizedCondition;

export type StateChangeOperator = '=' | '+=' | '-=';

export interface StateChange {
    variable: string;
    operator: StateChangeOperator;
    value: number;
}

export interface SystemState {
    variables: Record<string, number>;
    currentNodeId: string;
}

// Editor-only state: canvas layout and blocks that have been disconnected from their parent nodes.
// Nothing in this type is visible to StoryEngine or StoryRunner.
export interface EditorState {
    canvasPositions: Record<string, NodePosition>;
    orphanedConditions: Record<string, Condition>;
    orphanedTransitions: Record<string, Transition>;
    orphanedVariables: Record<string, StateChange>;
    orphanedOptions: Record<string, ChoiceOption>;
}

export const emptyEditorState = (): EditorState => ({
    canvasPositions: {},
    orphanedConditions: {},
    orphanedTransitions: {},
    orphanedVariables: {},
    orphanedOptions: {},
});
