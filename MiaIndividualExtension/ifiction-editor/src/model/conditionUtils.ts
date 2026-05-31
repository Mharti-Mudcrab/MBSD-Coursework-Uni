import type { Condition } from '../types';

export const formatCondition = (condition: Condition): string => {
    if (condition.type === 'comparison') return `${condition.variable} ${condition.operator} ${condition.value}`;
    if (condition.type === 'and' || condition.type === 'or') {
        const left = formatCondition(condition.left);
        const right = formatCondition(condition.right);
        const joiner = condition.type.toUpperCase();
        if (!left || !right) return `(${left || 'MISSING'} ${joiner} ${right || 'MISSING'})`;
        return `(${left} ${joiner} ${right})`;
    }
    if (condition.type === 'parentheses') return `(${formatCondition(condition.condition)})`;
    return 'Unknown condition';
};

export const updateConditionInTree = (root: Condition | undefined, targetNode: Condition, updates: Record<string, unknown>): Condition | undefined => {
    if (!root) return root;
    if (root === targetNode) return { ...root, ...updates } as Condition;
    if (root.type === 'parentheses') return { ...root, condition: updateConditionInTree(root.condition, targetNode, updates) as Condition };
    if (root.type === 'and' || root.type === 'or') {
        return { ...root, left: updateConditionInTree(root.left, targetNode, updates), right: updateConditionInTree(root.right, targetNode, updates) } as Condition;
    }
    return root;
};

export const removeConditionNode = (root: Condition | undefined, target: Condition): { nextCondition: Condition | undefined; orphaned: Condition[] } => {
    const orphaned: Condition[] = [];
    if (!root) return { nextCondition: undefined, orphaned };
    if (root === target) {
        if (root.type === 'and' || root.type === 'or') orphaned.push(root.left, root.right);
        return { nextCondition: undefined, orphaned };
    }
    if (root.type === 'parentheses') {
        const inner = root.condition;
        if (inner === target) {
            if (inner.type === 'and' || inner.type === 'or') orphaned.push(inner.left, inner.right);
            return { nextCondition: undefined, orphaned };
        }
        const result = removeConditionNode(inner, target);
        return {
            nextCondition: result.nextCondition ? { ...root, condition: result.nextCondition } : undefined,
            orphaned: result.orphaned
        };
    }
    if (root.type === 'and' || root.type === 'or') {
        const leftResult = removeConditionNode(root.left, target);
        const rightResult = removeConditionNode(root.right, target);
        return {
            nextCondition: { ...root, left: leftResult.nextCondition, right: rightResult.nextCondition } as Condition,
            orphaned: [...leftResult.orphaned, ...rightResult.orphaned]
        };
    }
    return { nextCondition: root, orphaned };
};

export const duplicateConditionAsOrphan = (condition: Condition): { id: string; condition: Condition } => {
    return { id: crypto.randomUUID(), condition: JSON.parse(JSON.stringify(condition)) };
};
