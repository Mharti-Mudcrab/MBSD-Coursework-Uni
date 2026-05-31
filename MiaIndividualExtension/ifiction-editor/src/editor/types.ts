import type { Operator, Transition, ChoiceOption, Condition, StateChange } from '../types';

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
    isSelected: boolean;
    onSelect: () => void;
};

/**
 * Union of all possible node data types that can appear on the canvas.
 */
export type CanvasNodeData =
    | Record<string, unknown>  // Story nodes (generic for all story node types)
    | OptionBlockData
    | TransitionBlockData
    | ConditionBlockData;

/**
 * Discriminated union for entries in the block registry (blockToConditionRef).
 * Each variant describes what a canvas block ID maps to in story/editor state.
 */
export type ConditionNodeEntry = {
    kind: 'conditionNode';
    parentTransitionId: string;
    condition: Condition;
    orphanId?: string;
    optionOrphanId?: string;
    transitionIndex?: number;
    transition?: Transition;
};

export type OrphanedTransitionEntry = {
    kind: 'orphanedTransition';
    orphanId: string;
    transition: Transition;
};

export type OrphanedVariableEntry = {
    kind: 'orphanedVariable';
    orphanId: string;
    change: StateChange;
};

export type OrphanedOptionEntry = {
    kind: 'orphanedOption';
    orphanId: string;
    option: ChoiceOption;
};

export type OrphanedOptionTransitionEntry = {
    kind: 'orphanedOptionTransition';
    optionOrphanId: string;
    transitionIndex: number;
    transition: Transition;
};

export type BlockRegistryEntry =
    | ConditionNodeEntry
    | OrphanedTransitionEntry
    | OrphanedVariableEntry
    | OrphanedOptionEntry
    | OrphanedOptionTransitionEntry;
