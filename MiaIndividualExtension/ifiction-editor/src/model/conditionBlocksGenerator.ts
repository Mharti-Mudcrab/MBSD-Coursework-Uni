import type { Node } from '@xyflow/react';
import type { Condition, Comparison, LogicalGroup, ParenthesizedCondition } from '../types';
import type { ConditionBlockData } from '../editor/types';

interface ConditionBlocksResult {
    nodes: Node<ConditionBlockData>[];
    edges: any[];
    rootBlockId: string | null;
    blockToCondition: Map<string, Condition>;
}

let conditionBlockCounter = 0;

/**
 * Convert a condition AST into visual block nodes and edges for rendering on canvas.
 * Returns nodes to render, edges to connect them, and the ID of the root output block.
 * Condition blocks wire from the transition's condition handle to the root condition block output.
 */
export function conditionASTToBlocks(
    condition: Condition | undefined,
    parentTransitionId: string
): ConditionBlocksResult {
    if (!condition) {
        return { nodes: [], edges: [], rootBlockId: null, blockToCondition: new Map() };
    }

    conditionBlockCounter = 0;
    const nodes: Node<ConditionBlockData>[] = [];
    const edges: any[] = [];
    const blockToCondition: Map<string, Condition> = new Map();

    const rootId = buildConditionBlocks(condition, nodes, edges, parentTransitionId, blockToCondition);
    
    // Create edge from root condition block output to transition's condition input handle
    // Determine the correct source handle based on root condition type
    if (rootId) {
        // All condition blocks output via 'output' handle
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
    condition: Condition,
    nodes: Node<ConditionBlockData>[],
    edges: any[],
    parentTransitionId: string,
    blockToCondition: Map<string, Condition>
): string {
    const blockId = `condition-${parentTransitionId}-${conditionBlockCounter++}`;
    
    // Use stored position if available, otherwise default to 0,0
    const position = condition.position || { x: 0, y: 0 };
    
    // Track this block's condition for later updates
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
                isSelected: false,
            },
        });
        return blockId;
    }

    if (condition.type === 'and') {
        const group = condition as LogicalGroup;
        const leftId = buildConditionBlocks(group.left, nodes, edges, parentTransitionId, blockToCondition);
        const rightId = buildConditionBlocks(group.right, nodes, edges, parentTransitionId, blockToCondition);

        nodes.push({
            id: blockId,
            type: 'andNode',
            position,
            data: { type: 'and', isSelected: false },
        });

        edges.push(
            {
                id: `${leftId}-to-${blockId}-conditionA`,
                source: leftId,
                target: blockId,
                sourceHandle: 'output',
                targetHandle: 'conditionA',
            },
            {
                id: `${rightId}-to-${blockId}-conditionB`,
                source: rightId,
                target: blockId,
                sourceHandle: 'output',
                targetHandle: 'conditionB',
            }
        );

        return blockId;
    }

    if (condition.type === 'or') {
        const group = condition as LogicalGroup;
        const leftId = buildConditionBlocks(group.left, nodes, edges, parentTransitionId, blockToCondition);
        const rightId = buildConditionBlocks(group.right, nodes, edges, parentTransitionId, blockToCondition);

        nodes.push({
            id: blockId,
            type: 'orNode',
            position,
            data: { type: 'or', isSelected: false },
        });

        edges.push(
            {
                id: `${leftId}-to-${blockId}-conditionA`,
                source: leftId,
                target: blockId,
                sourceHandle: 'output',
                targetHandle: 'conditionA',
            },
            {
                id: `${rightId}-to-${blockId}-conditionB`,
                source: rightId,
                target: blockId,
                sourceHandle: 'output',
                targetHandle: 'conditionB',
            }
        );

        return blockId;
    }

    if (condition.type === 'parentheses') {
        const paren = condition as ParenthesizedCondition;
        return buildConditionBlocks(paren.condition, nodes, edges, parentTransitionId, blockToCondition);
    }

    return blockId;
}
