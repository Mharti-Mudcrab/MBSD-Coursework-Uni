export type NodeType = 'start' | 'dialogue' | 'choice' | 'stateChange' | 'end';


interface baseNodeData {
    label: string;
    displayText: string;

}

export interface NodePosition{
    x: number;
    y: number;
}

export interface StoryData {
    name: string;
    nodes: Record<string, StoryNode>;
    startNodeId: string;
    orphanedConditions?: Condition[];
    orphanedTransitions?: Transition[];
    orphanedVariables?: StateChange[];
    orphanedOptions?: ChoiceOption[];
}


export interface Transition {
    targetNodeId: string;
    condition?: Condition;
    priority?: number;
    position?: NodePosition;
}

export interface ChoiceOption {
    displayText: string;
    transitions: Transition[];
    // Optional visual position for the option block on the canvas
    position?: NodePosition;
}

export interface StoryNode {
    id: string;
    type: NodeType;
    position: NodePosition;
    data: baseNodeData & {
        choices?: ChoiceOption[];
        stateChanges?: StateChange[];
        transitions?: Transition[];
    };
}



export interface ChoiceNodeData extends baseNodeData {
    options: ChoiceOption[];
}


export type Operator = '==' | '!=' | '<' | '>' | '<=' | '>=';

export interface Comparison {
    type: 'comparison';
    operator: Operator;
    variable: string;
    value: number;
    position?: NodePosition;
}

export interface LogicalGroup {
    type: 'and' | 'or';
    left: Condition;
    right: Condition;
    position?: NodePosition;
}

export type ParenthesizedCondition = {
    type: 'parentheses';
    condition: Condition;
    position?: NodePosition;
}

export type Condition = 
    | Comparison 
    | LogicalGroup 
    | ParenthesizedCondition;


export type stateChangeOperator = '=' | '+=' | '-=';

export interface StateChange {
    variable: string;
    operator: stateChangeOperator;
    value: number;
    // Optional visual position for the variable-change block on the canvas
    position?: NodePosition;
}

export interface StateChangeNodeData extends baseNodeData {
    stateChanges: StateChange[];
}

export interface SystemState {
    variables: Record<string, number>;
    currentNodeId: string;
}

