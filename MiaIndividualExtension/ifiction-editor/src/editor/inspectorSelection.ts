import type { StoryData, Condition, Transition, ChoiceOption, StateChange, StoryNode } from '../types';
import type { BlockRegistryEntry } from './types';
import React from 'react';

type StateChangeNode = Extract<StoryNode, { type: 'stateChange' }>;
type ChoiceNode = Extract<StoryNode, { type: 'choice' }>;

export type InspectorSelection =
    | { kind: 'none' }
    | { kind: 'node'; node: StoryNode }
    | { kind: 'variable'; parentNode: StateChangeNode; index: number; change: StateChange }
    | { kind: 'transition'; parentNode: StoryNode; parentId: string; index: number; transition: Transition; isOption: boolean }
    | { kind: 'condition'; parentNode: StoryNode; parentId: string; index: number; transition: Transition; isOption: boolean; condition: Condition }
    | { kind: 'comparisonBlock'; parentNode: StoryNode; parentId: string; transitionIndex: number; isOption: boolean; blockId: string; condition: Condition }
    | { kind: 'orphanedCondition'; orphanId: string; condition: Condition }
    | { kind: 'orphanedComparison'; orphanId: string; blockId: string; condition: Condition }
    | { kind: 'orphanedTransition'; orphanId: string; blockId: string; transition: Transition }
    | { kind: 'orphanedVariable'; orphanId: string; blockId: string; change: StateChange }
    | { kind: 'option'; parentNode: ChoiceNode; optionIndex: number; option: ChoiceOption }
    | { kind: 'orphanedOption'; orphanId: string; blockId: string; option: ChoiceOption }
    | { kind: 'orphanedOptionTransition'; optionOrphanId: string; transitionIndex: number; transition: Transition }
    | { kind: 'orphanedOptionCondition'; optionOrphanId: string; transitionIndex: number; transition: Transition; condition: Condition }
    | { kind: 'orphanedOptionComparison'; optionOrphanId: string; transitionIndex: number; transition: Transition; condition: Condition };

type TransitionParent =
    | { storyNode: StoryNode; isOption: false; transitionIndex: number }
    | { storyNode: StoryNode; isOption: true; optionIndex: number; transitionIndex: number };

function findTransitionParent(story: StoryData, parentTransitionId: string): TransitionParent | null {
    for (const storyNode of Object.values(story.nodes)) {
        const optionPrefix = `${storyNode.id}-option-`;
        if (storyNode.type === 'choice' && parentTransitionId.startsWith(optionPrefix)) {
            const parts = parentTransitionId.slice(optionPrefix.length).split('-');
            if (parts.length === 2 && /^\d+$/.test(parts[0]) && /^\d+$/.test(parts[1])) {
                const optionIndex = parseInt(parts[0], 10);
                const transitionIndex = parseInt(parts[1], 10);
                if (storyNode.data.choices[optionIndex]?.transitions[transitionIndex])
                    return { storyNode, isOption: true, optionIndex, transitionIndex };
            }
        }
        const regularPrefix = `${storyNode.id}-`;
        if (parentTransitionId.startsWith(regularPrefix) && !parentTransitionId.includes('-option-')) {
            const remainder = parentTransitionId.slice(regularPrefix.length);
            if (/^\d+$/.test(remainder)) {
                const transitionIndex = parseInt(remainder, 10);
                if (storyNode.data.transitions?.[transitionIndex])
                    return { storyNode, isOption: false, transitionIndex };
            }
        }
    }
    return null;
}

export function resolveInspectorSelection(
    story: StoryData,
    selectedNode: string | null,
    blockToConditionRef?: React.MutableRefObject<Map<string, BlockRegistryEntry>>
): InspectorSelection {
    if (!selectedNode) return { kind: 'none' };

    if (blockToConditionRef?.current.has(selectedNode)) {
        const entry = blockToConditionRef.current.get(selectedNode);

        if (entry?.kind === 'orphanedTransition')
            return { kind: 'orphanedTransition', orphanId: entry.orphanId, blockId: selectedNode, transition: entry.transition };
        if (entry?.kind === 'orphanedVariable')
            return { kind: 'orphanedVariable', orphanId: entry.orphanId, blockId: selectedNode, change: entry.change };
        if (entry?.kind === 'orphanedOption')
            return { kind: 'orphanedOption', orphanId: entry.orphanId, blockId: selectedNode, option: entry.option };
        if (entry?.kind === 'orphanedOptionTransition')
            return { kind: 'orphanedOptionTransition', optionOrphanId: entry.optionOrphanId, transitionIndex: entry.transitionIndex, transition: entry.transition };

        if (entry?.kind === 'conditionNode') {
            const { parentTransitionId, condition: condition_obj, orphanId } = entry;

            if (parentTransitionId.startsWith('orphan-option-')) {
                const { optionOrphanId, transitionIndex: tIdx, transition: trans } = entry;
                if (optionOrphanId !== undefined && tIdx !== undefined && trans !== undefined) {
                    if (condition_obj?.type === 'comparison')
                        return { kind: 'orphanedOptionComparison', optionOrphanId, transitionIndex: tIdx, transition: trans, condition: condition_obj };
                    return { kind: 'orphanedOptionCondition', optionOrphanId, transitionIndex: tIdx, transition: trans, condition: condition_obj };
                }
            }

            if (condition_obj?.type === 'comparison') {
                if (parentTransitionId.startsWith('orphan-'))
                    return { kind: 'orphanedComparison', orphanId: orphanId ?? parentTransitionId, blockId: selectedNode, condition: condition_obj };
                const parent = findTransitionParent(story, parentTransitionId);
                if (parent) {
                    if (parent.isOption)
                        return { kind: 'comparisonBlock', parentNode: parent.storyNode, parentId: parentTransitionId, transitionIndex: parent.transitionIndex, isOption: true, blockId: selectedNode, condition: condition_obj };
                    return { kind: 'comparisonBlock', parentNode: parent.storyNode, parentId: parent.storyNode.id, transitionIndex: parent.transitionIndex, isOption: false, blockId: selectedNode, condition: condition_obj };
                }
            }

            if (parentTransitionId.startsWith('orphan-'))
                return { kind: 'orphanedCondition', orphanId: orphanId ?? parentTransitionId.slice('orphan-'.length), condition: condition_obj };

            const parent = findTransitionParent(story, parentTransitionId);
            if (parent) {
                if (parent.isOption) {
                    const transition = parent.storyNode.type === 'choice'
                    ? parent.storyNode.data.choices[parent.optionIndex]?.transitions[parent.transitionIndex]
                    : undefined;
                if (!transition) return { kind: 'none' };
                    return { kind: 'condition', parentNode: parent.storyNode, parentId: `${parent.storyNode.id}-option-${parent.optionIndex}`, index: parent.transitionIndex, transition, isOption: true, condition: condition_obj };
                }
                return { kind: 'condition', parentNode: parent.storyNode, parentId: parent.storyNode.id, index: parent.transitionIndex, transition: parent.storyNode.data.transitions![parent.transitionIndex], isOption: false, condition: condition_obj };
            }
        }
    }

    if (selectedNode in story.nodes)
        return { kind: 'node', node: story.nodes[selectedNode] };

    for (const storyNode of Object.values(story.nodes)) {
        if (storyNode.type === 'stateChange') {
            for (let index = 0; index < storyNode.data.stateChanges.length; index++) {
                if (`${storyNode.id}-var-${index}` === selectedNode)
                    return { kind: 'variable', parentNode: storyNode, index, change: storyNode.data.stateChanges[index] };
            }
        }

        const transitions = storyNode.data.transitions;
        if (Array.isArray(transitions)) {
            for (let index = 0; index < transitions.length; index++) {
                if (`${storyNode.id}-${index}` === selectedNode)
                    return { kind: 'transition', parentNode: storyNode, parentId: storyNode.id, index, transition: transitions[index], isOption: false };
            }
        }

        if (storyNode.type === 'choice') {
            const choices = storyNode.data.choices;
            for (let optionIndex = 0; optionIndex < choices.length; optionIndex++) {
                const option = choices[optionIndex];
                if (`${storyNode.id}-option-${optionIndex}` === selectedNode)
                    return { kind: 'option', parentNode: storyNode, optionIndex, option };
                if (!Array.isArray(option?.transitions)) continue;
                for (let transitionIndex = 0; transitionIndex < option.transitions.length; transitionIndex++) {
                    if (`${storyNode.id}-option-${optionIndex}-${transitionIndex}` === selectedNode)
                        return { kind: 'transition', parentNode: storyNode, parentId: `${storyNode.id}-option-${optionIndex}`, index: transitionIndex, transition: option.transitions[transitionIndex], isOption: true };
                }
            }
        }
    }

    return { kind: 'none' };
}
