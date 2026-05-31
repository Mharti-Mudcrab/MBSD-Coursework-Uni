import type { Node } from '@xyflow/react';
import type { StoryData, EditorState, NodePosition, Condition } from '../types';
import type { ConditionBlockData, CanvasNodeData, BlockRegistryEntry, ConditionNodeEntry } from './types';
import { conditionASTToBlocks } from '../model/conditionBlocksGenerator';

export type BuildNodesResult = {
    nodes: Node<CanvasNodeData>[];
    conditionEdges: any[];
    registry: Map<string, BlockRegistryEntry>;
};

type ConditionExtras = Omit<ConditionNodeEntry, 'kind' | 'parentTransitionId' | 'condition'>;

function pushConditionBlocks(
    condition: Condition,
    parentTransitionId: string,
    selectedNodeId: string | null,
    canvasPositions: Record<string, NodePosition>,
    conditionNodes: Node<ConditionBlockData>[],
    conditionEdgesList: any[],
    registry: Map<string, BlockRegistryEntry>,
    extras: ConditionExtras = {}
): void {
    const blocks = conditionASTToBlocks(condition, parentTransitionId, selectedNodeId, canvasPositions);
    conditionNodes.push(...blocks.nodes);
    conditionEdgesList.push(...blocks.edges);
    blocks.blockToCondition.forEach((cond, blockId) => {
        registry.set(blockId, { kind: 'conditionNode', parentTransitionId, condition: cond, ...extras } as BlockRegistryEntry);
    });
}

export function buildCanvasNodes(
    story: StoryData,
    editorState: EditorState,
    selectedNodeId: string | null,
    onSelectNode: (id: string | null) => void
): BuildNodesResult {
    const { canvasPositions } = editorState;
    const registry = new Map<string, BlockRegistryEntry>();
    const optionBlocks: Node<any>[] = [];
    const transitionBlocks: Node<any>[] = [];
    const variableBlocks: Node<any>[] = [];
    const conditionNodes: Node<ConditionBlockData>[] = [];
    const conditionEdgesList: any[] = [];

    const regularNodes = Object.values(story.nodes).map(node => ({
        id: node.id,
        type: node.type,
        position: canvasPositions[node.id] ?? { x: 200, y: 200 },
        data: { ...(node.data as unknown as Record<string, unknown>), isSelected: node.id === selectedNodeId },
    }));

    Object.values(story.nodes).forEach(node => {
        node.data.transitions?.forEach((transition, index) => {
            const blockId = `${node.id}-${index}`;
            transitionBlocks.push({
                id: blockId,
                type: 'transitionBlock',
                position: canvasPositions[blockId] ?? { x: 0, y: 0 },
                data: {
                    transitionId: blockId,
                    transition,
                    parentNodeId: node.id,
                    isSelected: blockId === selectedNodeId,
                    onSelect: () => onSelectNode(blockId),
                },
            });
            if (transition.condition)
                pushConditionBlocks(transition.condition, blockId, selectedNodeId, canvasPositions, conditionNodes, conditionEdgesList, registry);
        });

        if (node.type === 'choice') {
            node.data.choices.forEach((option, optionIndex) => {
                const optBlockId = `${node.id}-option-${optionIndex}`;
                optionBlocks.push({
                    id: optBlockId,
                    type: 'optionBlock',
                    position: canvasPositions[optBlockId] ?? { x: 0, y: 0 },
                    data: {
                        optionId: optBlockId,
                        option,
                        parentNodeId: node.id,
                        optionIndex,
                        optionText: option.displayText || 'Option',
                        transitionCount: option.transitions?.length || 0,
                        isSelected: optBlockId === selectedNodeId,
                        onSelect: () => onSelectNode(optBlockId),
                    },
                });
                (option.transitions || []).forEach((transition: any, tIndex: number) => {
                    const tBlockId = `${optBlockId}-${tIndex}`;
                    transitionBlocks.push({
                        id: tBlockId,
                        type: 'transitionBlock',
                        position: canvasPositions[tBlockId] ?? { x: 0, y: 0 },
                        data: {
                            transitionId: tBlockId,
                            transition,
                            parentNodeId: optBlockId,
                            isOption: true,
                            isSelected: tBlockId === selectedNodeId,
                            onSelect: () => onSelectNode(tBlockId),
                        },
                    });
                    if (transition.condition)
                        pushConditionBlocks(transition.condition, tBlockId, selectedNodeId, canvasPositions, conditionNodes, conditionEdgesList, registry);
                });
            });
        }

        if (node.type === 'stateChange') {
            node.data.stateChanges.forEach((change, idx) => {
                const blockId = `${node.id}-var-${idx}`;
                variableBlocks.push({
                    id: blockId,
                    type: 'variableBlock',
                    position: canvasPositions[blockId] ?? { x: 0, y: 0 },
                    data: {
                        changeId: blockId,
                        change,
                        parentNodeId: node.id,
                        index: idx,
                        isSelected: blockId === selectedNodeId,
                        onSelect: () => onSelectNode(blockId),
                    },
                });
            });
        }
    });

    Object.entries(editorState.orphanedConditions).forEach(([orphanId, condition]) => {
        pushConditionBlocks(condition, `orphan-${orphanId}`, selectedNodeId, canvasPositions, conditionNodes, conditionEdgesList, registry, { orphanId });
    });

    Object.entries(editorState.orphanedTransitions).forEach(([orphanId, transition]) => {
        const blockId = `orphan-transition-${orphanId}`;
        transitionBlocks.push({
            id: blockId,
            type: 'transitionBlock',
            position: canvasPositions[blockId] ?? { x: 0, y: 0 },
            data: {
                transitionId: blockId,
                transition,
                parentNodeId: null,
                isSelected: blockId === selectedNodeId,
                onSelect: () => onSelectNode(blockId),
            },
        });
        registry.set(blockId, { kind: 'orphanedTransition', orphanId, transition });
        if (transition.condition)
            pushConditionBlocks(transition.condition, blockId, selectedNodeId, canvasPositions, conditionNodes, conditionEdgesList, registry);
    });

    Object.entries(editorState.orphanedVariables).forEach(([orphanId, change]) => {
        const blockId = `orphan-variable-${orphanId}`;
        variableBlocks.push({
            id: blockId,
            type: 'variableBlock',
            position: canvasPositions[blockId] ?? { x: 0, y: 0 },
            data: {
                changeId: blockId,
                change,
                parentNodeId: null,
                index: -1,
                isSelected: blockId === selectedNodeId,
                onSelect: () => onSelectNode(blockId),
            },
        });
        registry.set(blockId, { kind: 'orphanedVariable', orphanId, change });
    });

    Object.entries(editorState.orphanedOptions).forEach(([orphanId, option]) => {
        const blockId = `orphan-option-${orphanId}`;
        optionBlocks.push({
            id: blockId,
            type: 'optionBlock',
            position: canvasPositions[blockId] ?? { x: 0, y: 0 },
            data: {
                optionId: blockId,
                option,
                parentNodeId: null,
                optionIndex: -1,
                optionText: option.displayText || 'Option',
                transitionCount: option.transitions?.length || 0,
                isSelected: blockId === selectedNodeId,
                onSelect: () => onSelectNode(blockId),
            },
        });
        registry.set(blockId, { kind: 'orphanedOption', orphanId, option });
        (option.transitions || []).forEach((transition, tIndex) => {
            const tBlockId = `${blockId}-${tIndex}`;
            transitionBlocks.push({
                id: tBlockId,
                type: 'transitionBlock',
                position: canvasPositions[tBlockId] ?? { x: 0, y: 0 },
                data: {
                    transitionId: tBlockId,
                    transition,
                    parentNodeId: blockId,
                    isOption: true,
                    isSelected: tBlockId === selectedNodeId,
                    onSelect: () => onSelectNode(tBlockId),
                },
            });
            registry.set(tBlockId, { kind: 'orphanedOptionTransition', optionOrphanId: orphanId, transitionIndex: tIndex, transition });
            if (transition.condition)
                pushConditionBlocks(transition.condition, tBlockId, selectedNodeId, canvasPositions, conditionNodes, conditionEdgesList, registry, { optionOrphanId: orphanId, transitionIndex: tIndex, transition });
        });
    });

    return {
        nodes: [...regularNodes, ...optionBlocks, ...transitionBlocks, ...variableBlocks, ...conditionNodes],
        conditionEdges: conditionEdgesList,
        registry
    };
}

export function buildCanvasEdges(story: StoryData, editorState: EditorState, conditionEdges: any[]): any[] {
    const edges: any[] = [];

    Object.values(story.nodes).forEach(node => {
        node.data.transitions?.forEach((transition, index) => {
            const blockId = `${node.id}-${index}`;
            edges.push({ id: `${node.id}-to-${blockId}`, source: node.id, target: blockId, sourceHandle: 'output', targetHandle: 'input' });
            edges.push({ id: `${blockId}-to-${transition.targetNodeId}`, source: blockId, target: transition.targetNodeId, sourceHandle: 'output', targetHandle: 'input' });
        });

        if (node.type === 'stateChange') {
            node.data.stateChanges.forEach((_, idx) => {
                const varBlockId = `${node.id}-var-${idx}`;
                edges.push({ id: `${varBlockId}-to-${node.id}`, source: varBlockId, target: node.id, sourceHandle: 'output', targetHandle: 'var' });
            });
        }

        if (node.type === 'choice') {
            node.data.choices.forEach((option, optionIndex) => {
                const optBlockId = `${node.id}-option-${optionIndex}`;
                edges.push({ id: `${node.id}-to-${optBlockId}`, source: node.id, target: optBlockId, sourceHandle: 'output', targetHandle: 'input' });
                (option.transitions || []).forEach((transition, tIndex) => {
                    const tBlockId = `${optBlockId}-${tIndex}`;
                    edges.push({ id: `${optBlockId}-to-${tBlockId}`, source: optBlockId, target: tBlockId, sourceHandle: 'output', targetHandle: 'input' });
                    edges.push({ id: `${tBlockId}-to-${transition.targetNodeId}`, source: tBlockId, target: transition.targetNodeId, sourceHandle: 'output', targetHandle: 'input' });
                });
            });
        }
    });

    Object.entries(editorState.orphanedTransitions).forEach(([orphanId, orphaned]) => {
        const blockId = `orphan-transition-${orphanId}`;
        if (orphaned.targetNodeId)
            edges.push({ id: `${blockId}-to-${orphaned.targetNodeId}`, source: blockId, target: orphaned.targetNodeId, sourceHandle: 'output', targetHandle: 'input' });
    });

    Object.entries(editorState.orphanedOptions).forEach(([orphanId, option]) => {
        const optBlockId = `orphan-option-${orphanId}`;
        (option.transitions || []).forEach((transition, tIndex) => {
            const tBlockId = `${optBlockId}-${tIndex}`;
            edges.push({ id: `${optBlockId}-to-${tBlockId}`, source: optBlockId, target: tBlockId, sourceHandle: 'output', targetHandle: 'input' });
            if (transition.targetNodeId)
                edges.push({ id: `${tBlockId}-to-${transition.targetNodeId}`, source: tBlockId, target: transition.targetNodeId, sourceHandle: 'output', targetHandle: 'input' });
        });
    });

    edges.push(...conditionEdges);
    return edges;
}
