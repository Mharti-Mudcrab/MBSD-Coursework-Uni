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


export type stateChangeOperator = '=' | '+=' | '-=';

export interface StateChange {
    variable: string;
    operator: stateChangeOperator;
    value: number;
}

export interface StateChangeNodeData extends baseNodeData {
    stateChanges: StateChange[];
}

export interface SystemState {
    variables: Record<string, number>;
    currentNodeId: string;
}

