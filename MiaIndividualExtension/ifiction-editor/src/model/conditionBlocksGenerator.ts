import type { Node } from '@xyflow/react';
import type { Condition, Comparison, LogicalGroup, ParenthesizedCondition, NodePosition } from '../types';
import type { ConditionBlockData } from '../editor/types';

interface ConditionBlocksResult {
    nodes: Node<ConditionBlockData>[];
    edges: any[];
    rootBlockId: string | null;
    blockToCondition: Map<string, Condition>;
}

/**
 * Convert a condition AST into visual block nodes and edges for rendering on canvas.
 * Positions are read from canvasPositions rather than stored on the condition objects.
 */
export function conditionASTToBlocks(
    condition: Condition | undefined,
    parentTransitionId: string,
    selectedNodeId: string | null = null,
    canvasPositions: Record<string, NodePosition> = {}
): ConditionBlocksResult {
    if (!condition) {
        return { nodes: [], edges: [], rootBlockId: null, blockToCondition: new Map() };
    }

    const nodes: Node<ConditionBlockData>[] = [];
    const edges: any[] = [];
    const blockToCondition: Map<string, Condition> = new Map();

    const rootId = buildConditionBlocks(condition, nodes, edges, parentTransitionId, blockToCondition, 'root', selectedNodeId, canvasPositions);

    if (rootId) {
        edges.push({
            id: `${parentTransitionId}-condition-edge`,
            source: rootId,
            target: parentTransitionId,
            sourceHandle: 'output',
            targetHandle: 'condition',
        });
    }

    return { nodes, edges, rootBlockId: rootId, blockToCondition };
}

function buildConditionBlocks(
    condition: any,
    nodes: Node<ConditionBlockData>[],
    edges: any[],
    parentTransitionId: string,
    blockToCondition: Map<string, Condition>,
    path: string = 'root',
    selectedNodeId: string | null = null,
    canvasPositions: Record<string, NodePosition> = {}
): string | null {
    if (!condition || typeof condition !== 'object' || !('type' in condition)) {
        return null;
    }

    const blockId = `condition-${parentTransitionId}-${path}`;
    const position = canvasPositions[blockId] ?? { x: 0, y: 0 };

    blockToCondition.set(blockId, condition);

    if (condition.type === 'comparison') {
        const comp = condition as Comparison;
        nodes.push({
            id: blockId,
            type: 'comparisonBlock',
            position,
            data: {
                type: 'comparison',
                operator: comp.operator,
                variable: comp.variable,
                value: comp.value,
                isSelected: blockId === selectedNodeId,
            },
        });
        return blockId;
    }

    if (condition.type === 'and' || condition.type === 'or') {
        const group = condition as LogicalGroup;
        const leftId = buildConditionBlocks(group.left, nodes, edges, parentTransitionId, blockToCondition, `${path}-left`, selectedNodeId, canvasPositions);
        const rightId = buildConditionBlocks(group.right, nodes, edges, parentTransitionId, blockToCondition, `${path}-right`, selectedNodeId, canvasPositions);

        nodes.push({
            id: blockId,
            type: condition.type === 'and' ? 'andNode' : 'orNode',
            position,
            data: { type: condition.type, isSelected: blockId === selectedNodeId },
        });

        if (leftId) edges.push({ id: `${leftId}-to-${blockId}-conditionA`, source: leftId, target: blockId, sourceHandle: 'output', targetHandle: 'conditionA' });
        if (rightId) edges.push({ id: `${rightId}-to-${blockId}-conditionB`, source: rightId, target: blockId, sourceHandle: 'output', targetHandle: 'conditionB' });

        return blockId;
    }

    if (condition.type === 'parentheses') {
        const paren = condition as ParenthesizedCondition;
        return buildConditionBlocks(paren.condition, nodes, edges, parentTransitionId, blockToCondition, `${path}-paren`, selectedNodeId, canvasPositions);
    }

    return null;
}
