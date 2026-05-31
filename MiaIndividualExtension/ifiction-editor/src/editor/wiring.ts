import type { Connection } from '@xyflow/react';
import type { StoryData, StoryNode, Condition, EditorState, NodePosition } from '../types';
import type { BlockRegistryEntry } from './types';
import { updateConditionInTree } from '../model/conditionUtils';
import { remapBlockPositions, remapConditionSubtree } from '../model/positionUtils';

export type WiringResult = {
    nextStory?: StoryData;
    nextEditorState?: EditorState;
};

function parseOptionBlockId(blockId: string): { parentNodeId: string; optionIndex: number; transitionIndex: number } {
    const splitIdx = blockId.indexOf('-option-');
    const parentNodeId = blockId.substring(0, splitIdx);
    const rest = blockId.substring(splitIdx + '-option-'.length).split('-');
    return { parentNodeId, optionIndex: parseInt(rest[0], 10), transitionIndex: parseInt(rest[1], 10) };
}

function omitKey<T>(obj: Record<string, T>, key: string): Record<string, T> {
    return Object.fromEntries(Object.entries(obj).filter(([k]) => k !== key));
}

function parseOrphanOptionId(blockId: string): { optionOrphanId: string; transitionIndex: number } {
    const without = blockId.slice('orphan-option-'.length);
    const lastDash = without.lastIndexOf('-');
    return { optionOrphanId: without.substring(0, lastDash), transitionIndex: parseInt(without.substring(lastDash + 1), 10) };
}

function setTransitionTargetNode(story: StoryData, blockId: string, newTargetId: string): StoryData | null {
    if (blockId.startsWith('orphan-transition-')) return null;
    if (blockId.includes('-option-')) {
        const { parentNodeId, optionIndex, transitionIndex } = parseOptionBlockId(blockId);
        const parentNode = story.nodes[parentNodeId];
        if (!parentNode || parentNode.type !== 'choice') return null;
        const choices = [...parentNode.data.choices];
        const transitions = [...choices[optionIndex].transitions];
        transitions[transitionIndex] = { ...transitions[transitionIndex], targetNodeId: newTargetId };
        choices[optionIndex] = { ...choices[optionIndex], transitions };
        return { ...story, nodes: { ...story.nodes, [parentNodeId]: { ...parentNode, data: { ...parentNode.data, choices } } as StoryNode } };
    }
    const lastDash = blockId.lastIndexOf('-');
    const parentNodeId = blockId.substring(0, lastDash);
    const transitionIndex = parseInt(blockId.substring(lastDash + 1), 10);
    const parentNode = story.nodes[parentNodeId];
    if (!parentNode?.data.transitions) return null;
    const transitions = [...parentNode.data.transitions];
    transitions[transitionIndex] = { ...transitions[transitionIndex], targetNodeId: newTargetId };
    return { ...story, nodes: { ...story.nodes, [parentNodeId]: { ...parentNode, data: { ...parentNode.data, transitions } } as StoryNode } };
}

function setTransitionCondition(story: StoryData, editorState: EditorState, blockId: string, condition: Condition): WiringResult {
    if (blockId.startsWith('orphan-transition-')) {
        const orphanId = blockId.slice('orphan-transition-'.length);
        const updated = { ...editorState.orphanedTransitions[orphanId], condition };
        return { nextEditorState: { ...editorState, orphanedTransitions: { ...editorState.orphanedTransitions, [orphanId]: updated } } };
    }
    if (blockId.includes('-option-')) {
        const { parentNodeId, optionIndex, transitionIndex } = parseOptionBlockId(blockId);
        const parentNode = story.nodes[parentNodeId];
        if (!parentNode || parentNode.type !== 'choice') return {};
        const choices = [...parentNode.data.choices];
        const transitions = [...choices[optionIndex].transitions];
        transitions[transitionIndex] = { ...transitions[transitionIndex], condition };
        choices[optionIndex] = { ...choices[optionIndex], transitions };
        return { nextStory: { ...story, nodes: { ...story.nodes, [parentNodeId]: { ...parentNode, data: { ...parentNode.data, choices } } as StoryNode } } };
    }
    const lastDash = blockId.lastIndexOf('-');
    const parentNodeId = blockId.substring(0, lastDash);
    const transitionIndex = parseInt(blockId.substring(lastDash + 1), 10);
    const parentNode = story.nodes[parentNodeId];
    if (!parentNode?.data.transitions) return {};
    const transitions = [...parentNode.data.transitions];
    transitions[transitionIndex] = { ...transitions[transitionIndex], condition };
    return { nextStory: { ...story, nodes: { ...story.nodes, [parentNodeId]: { ...parentNode, data: { ...parentNode.data, transitions } } as StoryNode } } };
}

function getTransitionCondition(story: StoryData, editorState: EditorState, blockId: string): Condition | undefined {
    if (blockId.startsWith('orphan-transition-'))
        return editorState.orphanedTransitions[blockId.slice('orphan-transition-'.length)]?.condition;
    if (blockId.startsWith('orphan-option-')) {
        const { optionOrphanId, transitionIndex } = parseOrphanOptionId(blockId);
        return editorState.orphanedOptions[optionOrphanId]?.transitions?.[transitionIndex]?.condition;
    }
    if (blockId.includes('-option-')) {
        const { parentNodeId, optionIndex, transitionIndex } = parseOptionBlockId(blockId);
        const node = story.nodes[parentNodeId];
        if (node?.type !== 'choice') return undefined;
        return node.data.choices[optionIndex]?.transitions?.[transitionIndex]?.condition;
    }
    const lastDash = blockId.lastIndexOf('-');
    return story.nodes[blockId.substring(0, lastDash)]?.data?.transitions?.[parseInt(blockId.substring(lastDash + 1))]?.condition;
}

function applyConditionToParent(
    story: StoryData,
    editorState: EditorState,
    parentId: string,
    condition: Condition,
    remainingConditions: Record<string, Condition>,
    updatedPositions: Record<string, NodePosition>
): WiringResult | null {
    if (parentId.startsWith('orphan-transition-')) {
        const transOrphanId = parentId.slice('orphan-transition-'.length);
        const orphanedTrans = editorState.orphanedTransitions[transOrphanId];
        if (!orphanedTrans) return null;
        return { nextEditorState: { ...editorState, orphanedTransitions: { ...editorState.orphanedTransitions, [transOrphanId]: { ...orphanedTrans, condition } }, orphanedConditions: remainingConditions, canvasPositions: updatedPositions } };
    }
    if (parentId.startsWith('orphan-option-')) {
        const { optionOrphanId, transitionIndex } = parseOrphanOptionId(parentId);
        const orphanOption = editorState.orphanedOptions[optionOrphanId];
        if (!orphanOption) return null;
        const transitions = [...(orphanOption.transitions || [])];
        transitions[transitionIndex] = { ...transitions[transitionIndex], condition };
        return { nextEditorState: { ...editorState, orphanedOptions: { ...editorState.orphanedOptions, [optionOrphanId]: { ...orphanOption, transitions } }, orphanedConditions: remainingConditions, canvasPositions: updatedPositions } };
    }
    const condResult = setTransitionCondition(story, editorState, parentId, condition);
    return {
        nextStory: condResult.nextStory,
        nextEditorState: { ...(condResult.nextEditorState ?? editorState), orphanedConditions: remainingConditions, canvasPositions: updatedPositions }
    };
}

export function applyWiring(
    connection: Connection,
    story: StoryData,
    editorState: EditorState,
    blockRegistry: Map<string, BlockRegistryEntry>
): WiringResult | null {
    const { source, target, targetHandle } = connection;
    if (!source || !target) return null;

    // ── Case 1: TransitionBlock.output → StoryNode.input ─────────────────────
    if (targetHandle === 'input' && story.nodes[target] && !source.startsWith('condition-')) {
        if (source.startsWith('orphan-transition-')) {
            const orphanId = source.slice('orphan-transition-'.length);
            const orphan = editorState.orphanedTransitions[orphanId];
            if (!orphan) return null;
            return { nextEditorState: { ...editorState, orphanedTransitions: { ...editorState.orphanedTransitions, [orphanId]: { ...orphan, targetNodeId: target } } } };
        }
        const nextStory = setTransitionTargetNode(story, source, target);
        return nextStory ? { nextStory } : null;
    }

    // ── Case 2: Node/OptionBlock.output → orphaned TransitionBlock.input ─────
    if (targetHandle === 'input' && target.startsWith('orphan-transition-')) {
        const orphanId = target.slice('orphan-transition-'.length);
        const orphaned = editorState.orphanedTransitions[orphanId];
        if (!orphaned) return null;

        const orphanBlockId = `orphan-transition-${orphanId}`;
        const remainingOrphans = omitKey(editorState.orphanedTransitions, orphanId);
        let newBlockId: string | null = null;
        let updatedOrphanedOptions = editorState.orphanedOptions;
        let nextStory: StoryData | undefined;

        if (source.includes('-option-') && !source.startsWith('orphan-')) {
            const splitIdx = source.indexOf('-option-');
            const parentNodeId = source.substring(0, splitIdx);
            const optionIndex = parseInt(source.substring(splitIdx + '-option-'.length), 10);
            const parentNode = story.nodes[parentNodeId];
            if (!parentNode || parentNode.type !== 'choice') return null;
            const choices = [...parentNode.data.choices];
            newBlockId = `${source}-${(choices[optionIndex].transitions || []).length}`;
            choices[optionIndex] = { ...choices[optionIndex], transitions: [...(choices[optionIndex].transitions || []), orphaned] };
            nextStory = { ...story, nodes: { ...story.nodes, [parentNodeId]: { ...parentNode, data: { ...parentNode.data, choices } } as StoryNode } as StoryData['nodes'] };
        } else if (story.nodes[source]) {
            const parentNode = story.nodes[source];
            newBlockId = `${source}-${(parentNode.data.transitions || []).length}`;
            const transitions = [...(parentNode.data.transitions || []), orphaned];
            nextStory = { ...story, nodes: { ...story.nodes, [source]: { ...parentNode, data: { ...parentNode.data, transitions } } as StoryNode } as StoryData['nodes'] };
        } else if (source.startsWith('orphan-option-')) {
            const sourceOrphanId = source.slice('orphan-option-'.length);
            const orphanOption = editorState.orphanedOptions[sourceOrphanId];
            if (!orphanOption) return null;
            newBlockId = `${source}-${(orphanOption.transitions || []).length}`;
            updatedOrphanedOptions = { ...editorState.orphanedOptions, [sourceOrphanId]: { ...orphanOption, transitions: [...(orphanOption.transitions || []), orphaned] } };
        }

        if (!newBlockId) return null;
        return {
            nextStory,
            nextEditorState: { ...editorState, orphanedTransitions: remainingOrphans, orphanedOptions: updatedOrphanedOptions, canvasPositions: remapBlockPositions(editorState.canvasPositions, orphanBlockId, newBlockId) }
        };
    }

    // ── Case 2b: ChoiceNode.output → orphaned OptionBlock.input ──────────────
    if (targetHandle === 'input' && target.startsWith('orphan-option-')) {
        const orphanId = target.slice('orphan-option-'.length);
        const orphaned = editorState.orphanedOptions[orphanId];
        const parentNode = story.nodes[source];
        if (!orphaned || !parentNode || parentNode.type !== 'choice') return null;
        const currentChoices = parentNode.data.choices;
        const newBlockId = `${source}-option-${currentChoices.length}`;
        const orphanBlockId = `orphan-option-${orphanId}`;
        return {
            nextStory: { ...story, nodes: { ...story.nodes, [source]: { ...parentNode, data: { ...parentNode.data, choices: [...currentChoices, orphaned] } } as StoryNode } as StoryData['nodes'] },
            nextEditorState: { ...editorState, orphanedOptions: omitKey(editorState.orphanedOptions, orphanId), canvasPositions: remapBlockPositions(editorState.canvasPositions, orphanBlockId, newBlockId) }
        };
    }

    // ── Case 3: orphaned ConditionBlock.output → TransitionBlock.condition ───
    if (targetHandle === 'condition' && source.startsWith('condition-')) {
        const condRef = blockRegistry.get(source);
        if (condRef?.kind !== 'conditionNode' || !condRef.parentTransitionId.startsWith('orphan-')) return null;
        const orphanId = condRef.orphanId ?? condRef.parentTransitionId.slice('orphan-'.length);
        const orphanRoot = editorState.orphanedConditions[orphanId];
        if (!orphanRoot) return null;

        const updatedPositions = remapConditionSubtree(editorState.canvasPositions, `condition-orphan-${orphanId}`, `condition-${target}`);
        const remainingConditions = omitKey(editorState.orphanedConditions, orphanId);
        return applyConditionToParent(story, editorState, target, orphanRoot, remainingConditions, updatedPositions);
    }

    // ── Case 4: orphaned ConditionBlock.output → AND/OR.conditionA/conditionB
    if ((targetHandle === 'conditionA' || targetHandle === 'conditionB') && source.startsWith('condition-')) {
        const sourceCondRef = blockRegistry.get(source);
        if (sourceCondRef?.kind !== 'conditionNode' || !sourceCondRef.parentTransitionId.startsWith('orphan-')) return null;
        const orphanId = sourceCondRef.orphanId ?? sourceCondRef.parentTransitionId.slice('orphan-'.length);
        const orphanRoot = editorState.orphanedConditions[orphanId];
        if (!orphanRoot) return null;

        const targetCondRef = blockRegistry.get(target);
        if (targetCondRef?.kind !== 'conditionNode') return null;
        const slot = targetHandle === 'conditionA' ? 'left' : 'right';
        const andOrNode = targetCondRef.condition;
        const parentTransitionId = targetCondRef.parentTransitionId;

        const existingRoot = getTransitionCondition(story, editorState, parentTransitionId);
        const newRoot = existingRoot ? updateConditionInTree(existingRoot, andOrNode, { [slot]: orphanRoot }) as Condition : { ...andOrNode, [slot]: orphanRoot };
        const updatedPositions = remapConditionSubtree(editorState.canvasPositions, `condition-orphan-${orphanId}-root`, `${target}-${slot}`);
        const remainingConditions = omitKey(editorState.orphanedConditions, orphanId);
        return applyConditionToParent(story, editorState, parentTransitionId, newRoot, remainingConditions, updatedPositions);
    }

    // ── Case 5: orphaned VariableBlock.output → StateChangeNode.var ──────────
    if (targetHandle === 'var' && source.startsWith('orphan-variable-')) {
        const orphanId = source.slice('orphan-variable-'.length);
        const orphaned = editorState.orphanedVariables[orphanId];
        const targetNode = story.nodes[target];
        if (!orphaned || !targetNode || targetNode.type !== 'stateChange') return null;
        const currentChanges = targetNode.data.stateChanges;
        const orphanBlockId = `orphan-variable-${orphanId}`;
        const newBlockId = `${target}-var-${currentChanges.length}`;
        return {
            nextStory: { ...story, nodes: { ...story.nodes, [target]: { ...targetNode, data: { ...targetNode.data, stateChanges: [...currentChanges, orphaned] } } as StoryNode } as StoryData['nodes'] },
            nextEditorState: { ...editorState, orphanedVariables: omitKey(editorState.orphanedVariables, orphanId), canvasPositions: remapBlockPositions(editorState.canvasPositions, orphanBlockId, newBlockId) }
        };
    }

    return null;
}
