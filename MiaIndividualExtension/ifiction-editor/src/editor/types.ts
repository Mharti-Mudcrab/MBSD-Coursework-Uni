import type { Operator, Transition, ChoiceOption } from '../types';

/**
 * Type definitions for condition block components rendered on the canvas.
 */

export type ComparisonBlockData = {
    type: 'comparison';
    operator: Operator;
    variable: string;
    value: number;
    isSelected: boolean;
};

export type AndBlockData = {
    type: 'and';
    isSelected: boolean;
};

export type OrBlockData = {
    type: 'or';
    isSelected: boolean;
};

export type ConditionBlockData = ComparisonBlockData | AndBlockData | OrBlockData;

/**
 * Type definitions for block components that render transitions and options.
 */

export type TransitionBlockData = {
    transitionId: string;
    transition: Transition;
    parentNodeId: string | null;
    isOption?: boolean;
    isSelected: boolean;
    onSelect: () => void;
};

export type OptionBlockData = {
    optionId: string;
    option: ChoiceOption;
    parentNodeId: string | null;
    optionIndex: number;
    optionText: string;
    transitionCount: number;
};

/**
 * Union of all possible node data types that can appear on the canvas.
 */
export type CanvasNodeData = 
    | Record<string, unknown>  // Story nodes (generic for all story node types)
    | OptionBlockData
    | TransitionBlockData
    | ConditionBlockData;
