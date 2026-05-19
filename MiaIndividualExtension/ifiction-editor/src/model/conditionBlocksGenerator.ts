import type { Node } from '@xyflow/react';
import type { Condition, Comparison, LogicalGroup, ParenthesizedCondition } from '../types';
import type { ConditionBlockData } from '../editor/types';

interface ConditionBlocksResult {
    nodes: Node<ConditionBlockData>[];
    edges: any[];
    rootBlockId: string | null;
    blockToCondition: Map<string, Condition>;
}


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

    const nodes: Node<ConditionBlockData>[] = [];
    const edges: any[] = [];
    const blockToCondition: Map<string, Condition> = new Map();

    // Build reachable nodes from root
    let rootId: string | null = null;
    if (condition) {
        rootId = buildConditionBlocks(condition, nodes, edges, parentTransitionId, blockToCondition);
        
        // Create edge from root condition block output to transition's condition input handle
        if (rootId) {
            edges.push({
                id: `${parentTransitionId}-condition-edge`,
                source: rootId,
                target: parentTransitionId,
                sourceHandle: 'output',
                targetHandle: 'condition',
            });
        }
    }

    return { nodes, edges, rootBlockId: rootId, blockToCondition };
}

function buildConditionBlocks(
    condition: any,
    nodes: Node<ConditionBlockData>[],
    edges: any[],
    parentTransitionId: string,
    blockToCondition: Map<string, Condition>,
    path: string = 'root'
): string | null {
    if (!condition || typeof condition !== 'object' || !('type' in condition)) {
        return null;
    }

    const blockId = `condition-${parentTransitionId}-${path}`;
    
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
        const leftId = buildConditionBlocks(group.left, nodes, edges, parentTransitionId, blockToCondition, `${path}-left`);
        const rightId = buildConditionBlocks(group.right, nodes, edges, parentTransitionId, blockToCondition, `${path}-right`);

        nodes.push({
            id: blockId,
            type: 'andNode',
            position,
            data: { type: 'and', isSelected: false },
        });

        if (leftId) {
            edges.push({
                id: `${leftId}-to-${blockId}-conditionA`,
                source: leftId,
                target: blockId,
                sourceHandle: 'output',
                targetHandle: 'conditionA',
            });
        }

        if (rightId) {
            edges.push({
                id: `${rightId}-to-${blockId}-conditionB`,
                source: rightId,
                target: blockId,
                sourceHandle: 'output',
                targetHandle: 'conditionB',
            });
        }

        return blockId;
    }

    if (condition.type === 'or') {
        const group = condition as LogicalGroup;
        const leftId = buildConditionBlocks(group.left, nodes, edges, parentTransitionId, blockToCondition, `${path}-left`);
        const rightId = buildConditionBlocks(group.right, nodes, edges, parentTransitionId, blockToCondition, `${path}-right`);

        nodes.push({
            id: blockId,
            type: 'orNode',
            position,
            data: { type: 'or', isSelected: false },
        });

        if (leftId) {
            edges.push({
                id: `${leftId}-to-${blockId}-conditionA`,
                source: leftId,
                target: blockId,
                sourceHandle: 'output',
                targetHandle: 'conditionA',
            });
        }

        if (rightId) {
            edges.push({
                id: `${rightId}-to-${blockId}-conditionB`,
                source: rightId,
                target: blockId,
                sourceHandle: 'output',
                targetHandle: 'conditionB',
            });
        }

        return blockId;
    }

    if (condition.type === 'parentheses') {
        const paren = condition as ParenthesizedCondition;
        return buildConditionBlocks(paren.condition, nodes, edges, parentTransitionId, blockToCondition, `${path}-paren`);
    }

    return null;
}
