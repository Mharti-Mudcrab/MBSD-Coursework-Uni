import React from 'react';
import type { Condition, ChoiceOption, StateChange, StoryData, StoryNode, Transition, EditorState } from '../types';

interface Props {
    story: StoryData;
    editorState: EditorState;
    selectedNode: string | null;
    onUpdateNode: (node: StoryNode) => void;
    onDeleteNode: (nodeId: string) => void;
    onUpdateStory: (story: StoryData) => void;
    onUpdateEditorState: (editorState: EditorState) => void;
    blockToConditionRef?: React.MutableRefObject<Map<string, any>>;
}

const updateNodeTransition = (parentNode: StoryNode, index: number, updatedTransition: any): StoryNode | null => {
    if (!parentNode.data.transitions) return null;
    const updated = [...parentNode.data.transitions];
    updated[index] = updatedTransition;
    return { ...parentNode, data: { ...parentNode.data, transitions: updated } };
};

const deleteNodeTransition = (parentNode: StoryNode, index: number): StoryNode | null => {
    if (!parentNode.data.transitions) return null;
    const updated = [...parentNode.data.transitions];
    updated.splice(index, 1);
    return { ...parentNode, data: { ...parentNode.data, transitions: updated } };
};

const updateOptionTransition = (parentNode: StoryNode, parentId: string, index: number, updatedTransition: any): StoryNode | null => {
    if (parentNode.type !== 'choice' || !Array.isArray((parentNode.data as any).choices)) return null;
    const parts = parentId.split('-option-');
    const optionIndex = parseInt(parts[1], 10);
    const choices = [...(parentNode.data as any).choices];
    const option = choices[optionIndex];
    if (!option || !option.transitions) return null;
    const transitions = [...option.transitions];
    transitions[index] = updatedTransition;
    choices[optionIndex] = { ...option, transitions };
    return { ...parentNode, data: { ...parentNode.data, choices } };
};

const deleteOptionTransition = (parentNode: StoryNode, parentId: string, index: number): StoryNode | null => {
    if (parentNode.type !== 'choice' || !Array.isArray((parentNode.data as any).choices)) return null;
    const parts = parentId.split('-option-');
    const optionIndex = parseInt(parts[1], 10);
    const choices = [...(parentNode.data as any).choices];
    const option = choices[optionIndex];
    if (!option || !option.transitions) return null;
    const transitions = [...option.transitions];
    transitions.splice(index, 1);
    choices[optionIndex] = { ...option, transitions };
    return { ...parentNode, data: { ...parentNode.data, choices } };
};

const removeConditionNode = (root: Condition | undefined, target: Condition): { nextCondition: Condition | undefined; orphaned: Condition[] } => {
    const orphaned: Condition[] = [];
    if (!root) return { nextCondition: undefined, orphaned };
    if (root === target) {
        if ((root as any).left) orphaned.push((root as any).left);
        if ((root as any).right) orphaned.push((root as any).right);
        return { nextCondition: undefined, orphaned };
    }
    if (root.type === 'parentheses') {
        const inner = root.condition;
        if (inner === target) {
            if ((inner as any).left) orphaned.push((inner as any).left);
            if ((inner as any).right) orphaned.push((inner as any).right);
            return { nextCondition: undefined, orphaned };
        }
        const result = removeConditionNode(inner, target);
        return {
            nextCondition: result.nextCondition ? { ...root, condition: result.nextCondition } : undefined,
            orphaned: result.orphaned
        };
    }
    if (root.type === 'and' || root.type === 'or') {
        const left = (root as any).left;
        const right = (root as any).right;
        let leftResult: { nextCondition: Condition | undefined; orphaned: Condition[] } = { nextCondition: left, orphaned: [] };
        let rightResult: { nextCondition: Condition | undefined; orphaned: Condition[] } = { nextCondition: right, orphaned: [] };
        if (left) leftResult = removeConditionNode(left, target);
        if (right) rightResult = removeConditionNode(right, target);
        return {
            nextCondition: { ...root, left: leftResult.nextCondition, right: rightResult.nextCondition } as any,
            orphaned: [...leftResult.orphaned, ...rightResult.orphaned]
        };
    }
    return { nextCondition: root, orphaned };
};

const updateConditionInTree = (root: Condition | undefined, targetNode: any, updates: any): Condition | undefined => {
    if (!root) return root;
    if (root === targetNode) return { ...root, ...updates };
    if (root.type === 'parentheses') return { ...root, condition: updateConditionInTree(root.condition, targetNode, updates) as Condition };
    if (root.type === 'and' || root.type === 'or') {
        return {
            ...root,
            left: updateConditionInTree((root as any).left, targetNode, updates),
            right: updateConditionInTree((root as any).right, targetNode, updates)
        } as any;
    }
    return root;
};

const duplicateConditionAsOrphan = (condition: any): { id: string; condition: Condition } => {
    const copy = JSON.parse(JSON.stringify(condition));
    return { id: crypto.randomUUID(), condition: copy };
};

const formatCondition = (condition: any): string => {
    if (!condition) return '';
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

type InspectorSelection =
    | { kind: 'none' }
    | { kind: 'node'; node: StoryNode }
    | { kind: 'variable'; parentNode: StoryNode; index: number; change: any }
    | { kind: 'transition'; parentNode: StoryNode; parentId: string; index: number; transition: any; isOption: boolean }
    | { kind: 'condition'; parentNode: StoryNode; parentId: string; index: number; transition: any; isOption: boolean; condition: any }
    | { kind: 'comparisonBlock'; parentNode: StoryNode; parentId: string; transitionIndex: number; isOption: boolean; blockId: string; condition: any }
    | { kind: 'orphanedCondition'; orphanId: string; condition: any }
    | { kind: 'orphanedComparison'; orphanId: string; blockId: string; condition: any }
    | { kind: 'orphanedTransition'; orphanId: string; blockId: string; transition: Transition }
    | { kind: 'orphanedVariable'; orphanId: string; blockId: string; change: StateChange }
    | { kind: 'option'; parentNode: StoryNode; optionIndex: number; option: ChoiceOption }
    | { kind: 'orphanedOption'; orphanId: string; blockId: string; option: ChoiceOption }
    | { kind: 'orphanedOptionTransition'; optionOrphanId: string; transitionIndex: number; transition: Transition }
    | { kind: 'orphanedOptionCondition'; optionOrphanId: string; transitionIndex: number; transition: Transition; condition: any }
    | { kind: 'orphanedOptionComparison'; optionOrphanId: string; transitionIndex: number; transition: Transition; condition: any };

const resolveInspectorSelection = (story: StoryData, selectedNode: string | null, blockToConditionRef?: React.MutableRefObject<Map<string, any>>): InspectorSelection => {
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

        if (entry && 'parentTransitionId' in entry && 'condition' in entry) {
            const { parentTransitionId, condition: condition_obj, orphanId } = entry;

            if (parentTransitionId?.startsWith('orphan-option-')) {
                const { optionOrphanId, transitionIndex: tIdx, transition: trans } = entry;
                if (optionOrphanId !== undefined && tIdx !== undefined) {
                    if (condition_obj?.type === 'comparison')
                        return { kind: 'orphanedOptionComparison', optionOrphanId, transitionIndex: tIdx, transition: trans, condition: condition_obj };
                    return { kind: 'orphanedOptionCondition', optionOrphanId, transitionIndex: tIdx, transition: trans, condition: condition_obj };
                }
            }

            if (condition_obj?.type === 'comparison') {
                if (parentTransitionId.startsWith('orphan-')) {
                    return { kind: 'orphanedComparison', orphanId: orphanId ?? parentTransitionId, blockId: selectedNode, condition: condition_obj };
                }
                for (const storyNode of Object.values(story.nodes)) {
                    const optionPrefix = `${storyNode.id}-option-`;
                    if (parentTransitionId.startsWith(optionPrefix)) {
                        const remainder = parentTransitionId.slice(optionPrefix.length);
                        const parts = remainder.split('-');
                        if (parts.length === 2 && /^\d+$/.test(parts[0]) && /^\d+$/.test(parts[1])) {
                            const optionIndex = parseInt(parts[0], 10);
                            const transitionIndex = parseInt(parts[1], 10);
                            const option = (storyNode.data as any).choices?.[optionIndex];
                            if (option?.transitions?.[transitionIndex])
                                return { kind: 'comparisonBlock', parentNode: storyNode, parentId: parentTransitionId, transitionIndex, isOption: true, blockId: selectedNode, condition: condition_obj };
                        }
                    }
                    const regularPrefix = `${storyNode.id}-`;
                    if (parentTransitionId.startsWith(regularPrefix) && !parentTransitionId.includes('-option-')) {
                        const remainder = parentTransitionId.slice(regularPrefix.length);
                        if (/^\d+$/.test(remainder)) {
                            const index = parseInt(remainder, 10);
                            if (storyNode.data.transitions?.[index])
                                return { kind: 'comparisonBlock', parentNode: storyNode, parentId: storyNode.id, transitionIndex: index, isOption: false, blockId: selectedNode, condition: condition_obj };
                        }
                    }
                }
            }

            if (parentTransitionId.startsWith('orphan-'))
                return { kind: 'orphanedCondition', orphanId: orphanId ?? parentTransitionId.slice('orphan-'.length), condition: condition_obj };

            for (const storyNode of Object.values(story.nodes)) {
                const optionPrefix = `${storyNode.id}-option-`;
                if (parentTransitionId.startsWith(optionPrefix)) {
                    const remainder = parentTransitionId.slice(optionPrefix.length);
                    const parts = remainder.split('-');
                    if (parts.length === 2 && /^\d+$/.test(parts[0]) && /^\d+$/.test(parts[1])) {
                        const optionIndex = parseInt(parts[0], 10);
                        const transitionIndex = parseInt(parts[1], 10);
                        const choices = (storyNode.data as any).choices;
                        if (Array.isArray(choices) && choices[optionIndex]?.transitions?.[transitionIndex])
                            return { kind: 'condition', parentNode: storyNode, parentId: `${storyNode.id}-option-${optionIndex}`, index: transitionIndex, transition: choices[optionIndex].transitions[transitionIndex], isOption: true, condition: condition_obj };
                    }
                }
                const regularPrefix = `${storyNode.id}-`;
                if (parentTransitionId.startsWith(regularPrefix) && !parentTransitionId.includes('-option-')) {
                    const remainder = parentTransitionId.slice(regularPrefix.length);
                    if (/^\d+$/.test(remainder)) {
                        const index = parseInt(remainder, 10);
                        if (storyNode.data.transitions?.[index])
                            return { kind: 'condition', parentNode: storyNode, parentId: storyNode.id, index, transition: storyNode.data.transitions[index], isOption: false, condition: condition_obj };
                    }
                }
            }
        }
    }

    if (selectedNode in story.nodes)
        return { kind: 'node', node: story.nodes[selectedNode] };

    for (const storyNode of Object.values(story.nodes)) {
        const stateChanges = (storyNode.data as any).stateChanges;
        if (storyNode.type === 'stateChange' && Array.isArray(stateChanges)) {
            for (let index = 0; index < stateChanges.length; index++) {
                if (`${storyNode.id}-var-${index}` === selectedNode)
                    return { kind: 'variable', parentNode: storyNode, index, change: stateChanges[index] };
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
            const choices = (storyNode.data as any).choices;
            if (Array.isArray(choices)) {
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
    }

    return { kind: 'none' };
};

export const StoryInspector: React.FC<Props> = ({
    story,
    editorState,
    selectedNode,
    onUpdateNode,
    onDeleteNode,
    onUpdateStory,
    onUpdateEditorState,
    blockToConditionRef
}) => {
    const selection = resolveInspectorSelection(story, selectedNode, blockToConditionRef);

    if (selection.kind === 'none') {
        return <div style={{ padding: '20px', color: '#888' }}>Select a node to view details</div>;
    }

    if (selection.kind === 'variable') {
        const { parentNode, index, change } = selection;
        return (
            <aside style={{ padding: 16, color: '#ddd', height: '100%', boxSizing: 'border-box', overflowY: 'auto', fontFamily: 'system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", Arial' }}>
                <h2 style={{ marginTop: 0 }}>Edit Variable Change</h2>
                <p style={{ fontSize: 12, color: '#aaa' }}>In node: {parentNode.id}</p>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Variable</label>
                    <input style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={change.variable}
                        onChange={(e) => { const updated = [...(parentNode.data as any).stateChanges]; updated[index] = { ...updated[index], variable: e.target.value }; onUpdateStory({ ...story, nodes: { ...story.nodes, [parentNode.id]: { ...parentNode, data: { ...parentNode.data, stateChanges: updated } } } }); }} />
                </div>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Operator</label>
                    <select value={change.operator} onChange={(e) => { const updated = [...(parentNode.data as any).stateChanges]; updated[index] = { ...updated[index], operator: e.target.value }; onUpdateStory({ ...story, nodes: { ...story.nodes, [parentNode.id]: { ...parentNode, data: { ...parentNode.data, stateChanges: updated } } } }); }} style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }}>
                        <option value="=">=</option><option value="+=">+=</option><option value="-=">-=</option>
                    </select>
                </div>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Value</label>
                    <input type="number" style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={change.value}
                        onChange={(e) => { const updated = [...(parentNode.data as any).stateChanges]; updated[index] = { ...updated[index], value: parseInt(e.target.value || '0', 10) }; onUpdateStory({ ...story, nodes: { ...story.nodes, [parentNode.id]: { ...parentNode, data: { ...parentNode.data, stateChanges: updated } } } }); }} />
                </div>
                <button onClick={() => { const updated = [...(parentNode.data as any).stateChanges]; updated.splice(index, 1); onUpdateStory({ ...story, nodes: { ...story.nodes, [parentNode.id]: { ...parentNode, data: { ...parentNode.data, stateChanges: updated } } } }); }}
                    style={{ width: '100%', padding: '8px 12px', background: '#aa4444', border: 'none', color: '#fff', borderRadius: 4, cursor: 'pointer' }}>Delete Change</button>
            </aside>
        );
    }

    if (selection.kind === 'transition') {
        const { parentNode, parentId, index, transition, isOption } = selection;
        return (
            <aside style={{ padding: 16, color: '#ddd', height: '100%', boxSizing: 'border-box', overflowY: 'auto', fontFamily: 'system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", Arial' }}>
                <h2 style={{ marginTop: 0 }}>Edit Transition</h2>
                <p style={{ fontSize: 12, color: '#aaa' }}>From: {parentId}</p>
                <p style={{ fontSize: 12, color: '#aaa' }}>Target: {transition.targetNodeId}</p>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Priority</label>
                    <input type="number" style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={transition.priority ?? 0}
                        onChange={(e) => { const updated = isOption ? updateOptionTransition(parentNode, parentId, index, { ...transition, priority: parseInt(e.target.value || '0', 10) }) : updateNodeTransition(parentNode, index, { ...transition, priority: parseInt(e.target.value || '0', 10) }); if (updated) onUpdateNode(updated); }} />
                </div>
                {transition.condition && (
                    <div style={{ marginBottom: 12, padding: 8, background: '#1a3a1a', borderRadius: 4, borderLeft: '3px solid #6ac06a' }}>
                        <p style={{ margin: '0 0 8px 0', fontSize: 12, color: '#cfe8cf' }}>Condition: {formatCondition(transition.condition)}</p>
                    </div>
                )}
                <button onClick={() => { const updated = isOption ? deleteOptionTransition(parentNode, parentId, index) : deleteNodeTransition(parentNode, index); if (updated) onUpdateNode(updated); }}
                    style={{ width: '100%', padding: '8px 12px', background: '#aa4444', border: 'none', color: '#fff', borderRadius: 4, cursor: 'pointer' }}>Delete Transition</button>
            </aside>
        );
    }

    if (selection.kind === 'comparisonBlock') {
        const { parentNode, parentId, transitionIndex, isOption, condition } = selection;
        const transition = isOption
            ? (parentNode.data as any).choices?.[parseInt(parentId.split('-option-')[1], 10)]?.transitions?.[transitionIndex]
            : parentNode.data.transitions?.[transitionIndex];
        if (!transition || !condition) return null;

        const handleComparisonChange = (updates: any) => {
            const updatedFullCondition = updateConditionInTree(transition.condition, condition, updates);
            const updatedTransition = { ...transition, condition: updatedFullCondition };
            const updatedNode = isOption ? updateOptionTransition(parentNode, parentId, transitionIndex, updatedTransition) : updateNodeTransition(parentNode, transitionIndex, updatedTransition);
            if (updatedNode) onUpdateStory({ ...story, nodes: { ...story.nodes, [updatedNode.id]: updatedNode } });
        };

        return (
            <aside style={{ padding: 16, color: '#ddd', height: '100%', boxSizing: 'border-box', overflowY: 'auto', fontFamily: 'system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", Arial' }}>
                <h2 style={{ marginTop: 0 }}>Edit Comparison</h2>
                <p style={{ fontSize: 12, color: '#aaa' }}>Part of: {isOption ? `${parentId} → ${transition.targetNodeId}` : parentId}</p>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Variable</label>
                    <input style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={condition.variable || ''} onChange={(e) => handleComparisonChange({ variable: e.target.value })} />
                </div>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Operator</label>
                    <select value={condition.operator || '=='} onChange={(e) => handleComparisonChange({ operator: e.target.value })} style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }}>
                        <option value="==">==</option><option value="!=">!=</option><option value=">">&gt;</option><option value="<">&lt;</option><option value=">=">&gt;=</option><option value="<=">&lt;=</option>
                    </select>
                </div>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Value</label>
                    <input style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={condition.value ?? ''} onChange={(e) => handleComparisonChange({ value: parseFloat(e.target.value) })} />
                </div>
                <button onClick={() => { const { id, condition: dup } = duplicateConditionAsOrphan(condition); onUpdateEditorState({ ...editorState, orphanedConditions: { ...editorState.orphanedConditions, [id]: dup } }); }}
                    style={{ width: '100%', padding: '8px 12px', marginBottom: 8, background: '#2a4a6a', border: 'none', color: '#fff', borderRadius: 4, cursor: 'pointer' }}>Duplicate &amp; Subconditions</button>
                <button onClick={() => {
                    const result = removeConditionNode(transition.condition, condition);
                    const updatedTransition = { ...transition, condition: result.nextCondition };
                    const updatedNode = isOption ? updateOptionTransition(parentNode, parentId, transitionIndex, updatedTransition) : updateNodeTransition(parentNode, transitionIndex, updatedTransition);
                    if (updatedNode) {
                        const newOrphans = Object.fromEntries(result.orphaned.map(o => [crypto.randomUUID(), o]));
                        onUpdateStory({ ...story, nodes: { ...story.nodes, [updatedNode.id]: updatedNode } });
                        onUpdateEditorState({ ...editorState, orphanedConditions: { ...editorState.orphanedConditions, ...newOrphans } });
                    }
                }} style={{ width: '100%', padding: '8px 12px', background: '#aa4444', border: 'none', color: '#fff', borderRadius: 4, cursor: 'pointer' }}>Delete Comparison</button>
            </aside>
        );
    }

    if (selection.kind === 'orphanedComparison') {
        const { orphanId, condition } = selection;
        const handleChange = (updates: any) => {
            const root = editorState.orphanedConditions[orphanId];
            if (!root) return;
            onUpdateEditorState({ ...editorState, orphanedConditions: { ...editorState.orphanedConditions, [orphanId]: updateConditionInTree(root, condition, updates) as Condition } });
        };
        return (
            <aside style={{ padding: 16, color: '#ddd', height: '100%', boxSizing: 'border-box', overflowY: 'auto', fontFamily: 'system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", Arial' }}>
                <h2 style={{ marginTop: 0 }}>Edit Orphaned Comparison</h2>
                <p style={{ fontSize: 12, color: '#aaa' }}>Detached — drag onto a transition to reconnect.</p>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Variable</label>
                    <input style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={condition.variable || ''} onChange={(e) => handleChange({ variable: e.target.value })} />
                </div>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Operator</label>
                    <select value={condition.operator || '=='} onChange={(e) => handleChange({ operator: e.target.value })} style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }}>
                        <option value="==">==</option><option value="!=">!=</option><option value=">">&gt;</option><option value="<">&lt;</option><option value=">=">&gt;=</option><option value="<=">&lt;=</option>
                    </select>
                </div>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Value</label>
                    <input style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={condition.value ?? ''} onChange={(e) => handleChange({ value: parseFloat(e.target.value) })} />
                </div>
                <button onClick={() => { const { id, condition: dup } = duplicateConditionAsOrphan(condition); onUpdateEditorState({ ...editorState, orphanedConditions: { ...editorState.orphanedConditions, [id]: dup } }); }}
                    style={{ width: '100%', padding: '8px 12px', marginBottom: 8, background: '#2a4a6a', border: 'none', color: '#fff', borderRadius: 4, cursor: 'pointer' }}>Duplicate &amp; Subconditions</button>
                <button onClick={() => {
                    const root = editorState.orphanedConditions[orphanId];
                    if (!root) return;
                    const result = removeConditionNode(root, condition);
                    const newOrphans = Object.fromEntries(result.orphaned.map(o => [crypto.randomUUID(), o]));
                    const updated = { ...editorState.orphanedConditions };
                    if (result.nextCondition) updated[orphanId] = result.nextCondition;
                    else delete updated[orphanId];
                    onUpdateEditorState({ ...editorState, orphanedConditions: { ...updated, ...newOrphans } });
                }} style={{ width: '100%', padding: '8px 12px', background: '#aa4444', border: 'none', color: '#fff', borderRadius: 4, cursor: 'pointer' }}>Delete Comparison</button>
            </aside>
        );
    }

    if (selection.kind === 'option') {
        const { parentNode, optionIndex, option } = selection;
        const choices = (parentNode.data as any).choices as ChoiceOption[];
        return (
            <aside style={{ padding: 16, color: '#ddd', height: '100%', boxSizing: 'border-box', overflowY: 'auto', fontFamily: 'system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", Arial' }}>
                <h2 style={{ marginTop: 0 }}>Edit Option</h2>
                <p style={{ fontSize: 12, color: '#aaa' }}>In node: {parentNode.id}</p>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Display Text</label>
                    <input style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={option.displayText || ''}
                        onChange={(e) => { const updated = [...choices]; updated[optionIndex] = { ...updated[optionIndex], displayText: e.target.value }; onUpdateStory({ ...story, nodes: { ...story.nodes, [parentNode.id]: { ...parentNode, data: { ...parentNode.data, choices: updated } } } }); }} />
                </div>
                <div style={{ marginBottom: 12, padding: 8, background: '#1a1a2a', borderRadius: 4, borderLeft: '3px solid #6a8ac0' }}>
                    <p style={{ margin: 0, fontSize: 12, color: '#aaa' }}>Transitions: {option.transitions?.length ?? 0}</p>
                </div>
                <button onClick={() => {
                    const updated = [...choices];
                    const [removed] = updated.splice(optionIndex, 1);
                    const newOrphans = Object.fromEntries((removed.transitions || []).map((t: any) => [crypto.randomUUID(), t]));
                    onUpdateStory({ ...story, nodes: { ...story.nodes, [parentNode.id]: { ...parentNode, data: { ...parentNode.data, choices: updated } } } });
                    onUpdateEditorState({ ...editorState, orphanedTransitions: { ...editorState.orphanedTransitions, ...newOrphans } });
                }} style={{ width: '100%', padding: '8px 12px', background: '#aa4444', border: 'none', color: '#fff', borderRadius: 4, cursor: 'pointer' }}>Delete Option</button>
            </aside>
        );
    }

    if (selection.kind === 'orphanedOption') {
        const { orphanId, option } = selection;
        return (
            <aside style={{ padding: 16, color: '#ddd', height: '100%', boxSizing: 'border-box', overflowY: 'auto', fontFamily: 'system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", Arial' }}>
                <h2 style={{ marginTop: 0 }}>Edit Orphaned Option</h2>
                <p style={{ fontSize: 12, color: '#aaa' }}>Detached — wire to a choice node to reconnect.</p>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Display Text</label>
                    <input style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={option.displayText || ''}
                        onChange={(e) => onUpdateEditorState({ ...editorState, orphanedOptions: { ...editorState.orphanedOptions, [orphanId]: { ...option, displayText: e.target.value } } })} />
                </div>
                <div style={{ marginBottom: 12, padding: 8, background: '#1a1a2a', borderRadius: 4, borderLeft: '3px solid #6a8ac0' }}>
                    <p style={{ margin: 0, fontSize: 12, color: '#aaa' }}>Transitions: {option.transitions?.length ?? 0}</p>
                </div>
                <button onClick={() => { const updated = { ...editorState.orphanedOptions }; delete updated[orphanId]; onUpdateEditorState({ ...editorState, orphanedOptions: updated }); }}
                    style={{ width: '100%', padding: '8px 12px', background: '#aa4444', border: 'none', color: '#fff', borderRadius: 4, cursor: 'pointer' }}>Delete Option</button>
            </aside>
        );
    }

    if (selection.kind === 'orphanedTransition') {
        const { orphanId, transition } = selection;
        return (
            <aside style={{ padding: 16, color: '#ddd', height: '100%', boxSizing: 'border-box', overflowY: 'auto', fontFamily: 'system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", Arial' }}>
                <h2 style={{ marginTop: 0 }}>Edit Orphaned Transition</h2>
                <p style={{ fontSize: 12, color: '#aaa' }}>Detached — wire to a node to reconnect.</p>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Target Node</label>
                    <input style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={transition.targetNodeId || ''}
                        onChange={(e) => onUpdateEditorState({ ...editorState, orphanedTransitions: { ...editorState.orphanedTransitions, [orphanId]: { ...transition, targetNodeId: e.target.value } } })} />
                </div>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Priority</label>
                    <input type="number" style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={transition.priority ?? 0}
                        onChange={(e) => onUpdateEditorState({ ...editorState, orphanedTransitions: { ...editorState.orphanedTransitions, [orphanId]: { ...transition, priority: parseInt(e.target.value || '0', 10) } } })} />
                </div>
                {transition.condition && (
                    <div style={{ marginBottom: 12, padding: 8, background: '#1a3a1a', borderRadius: 4, borderLeft: '3px solid #6ac06a' }}>
                        <p style={{ margin: 0, fontSize: 12, color: '#cfe8cf' }}>Condition: {formatCondition(transition.condition)}</p>
                    </div>
                )}
                <button onClick={() => { const updated = { ...editorState.orphanedTransitions }; delete updated[orphanId]; onUpdateEditorState({ ...editorState, orphanedTransitions: updated }); }}
                    style={{ width: '100%', padding: '8px 12px', background: '#aa4444', border: 'none', color: '#fff', borderRadius: 4, cursor: 'pointer' }}>Delete Transition</button>
            </aside>
        );
    }

    if (selection.kind === 'orphanedVariable') {
        const { orphanId, change } = selection;
        return (
            <aside style={{ padding: 16, color: '#ddd', height: '100%', boxSizing: 'border-box', overflowY: 'auto', fontFamily: 'system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", Arial' }}>
                <h2 style={{ marginTop: 0 }}>Edit Orphaned Variable Change</h2>
                <p style={{ fontSize: 12, color: '#aaa' }}>Detached — wire to a state change node to reconnect.</p>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Variable</label>
                    <input style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={change.variable || ''}
                        onChange={(e) => onUpdateEditorState({ ...editorState, orphanedVariables: { ...editorState.orphanedVariables, [orphanId]: { ...change, variable: e.target.value } } })} />
                </div>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Operator</label>
                    <select value={change.operator || '='} onChange={(e) => onUpdateEditorState({ ...editorState, orphanedVariables: { ...editorState.orphanedVariables, [orphanId]: { ...change, operator: e.target.value as any } } })} style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }}>
                        <option value="=">=</option><option value="+=">+=</option><option value="-=">-=</option>
                    </select>
                </div>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Value</label>
                    <input type="number" style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={change.value ?? 0}
                        onChange={(e) => onUpdateEditorState({ ...editorState, orphanedVariables: { ...editorState.orphanedVariables, [orphanId]: { ...change, value: parseInt(e.target.value || '0', 10) } } })} />
                </div>
                <button onClick={() => { const updated = { ...editorState.orphanedVariables }; delete updated[orphanId]; onUpdateEditorState({ ...editorState, orphanedVariables: updated }); }}
                    style={{ width: '100%', padding: '8px 12px', background: '#aa4444', border: 'none', color: '#fff', borderRadius: 4, cursor: 'pointer' }}>Delete Variable Change</button>
            </aside>
        );
    }

    if (selection.kind === 'orphanedCondition') {
        const { orphanId, condition } = selection;
        const conditionLabel = condition?.type === 'comparison'
            ? `${condition.variable} ${condition.operator} ${condition.value}`
            : (condition?.type === 'and' || condition?.type === 'or') ? condition.type.toUpperCase() : condition?.type || 'condition';
        return (
            <aside style={{ padding: 16, color: '#ddd', height: '100%', boxSizing: 'border-box', overflowY: 'auto', fontFamily: 'system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", Arial' }}>
                <h2 style={{ marginTop: 0 }}>Orphaned Condition</h2>
                <p style={{ fontSize: 12, color: '#aaa' }}>This condition block is detached. Drag it onto a transition to reconnect it.</p>
                <p style={{ fontSize: 12, color: '#cfe8cf' }}>Parsed as: {conditionLabel}</p>
                <button onClick={() => { const { id, condition: dup } = duplicateConditionAsOrphan(condition); onUpdateEditorState({ ...editorState, orphanedConditions: { ...editorState.orphanedConditions, [id]: dup } }); }}
                    style={{ width: '100%', padding: '8px 12px', marginBottom: 8, background: '#2a4a6a', border: 'none', color: '#fff', borderRadius: 4, cursor: 'pointer' }}>Duplicate &amp; Subconditions</button>
                <button onClick={() => {
                    const root = editorState.orphanedConditions[orphanId];
                    if (!root) return;
                    const result = removeConditionNode(root, condition);
                    const newOrphans = Object.fromEntries(result.orphaned.map(o => [crypto.randomUUID(), o]));
                    const updated = { ...editorState.orphanedConditions };
                    if (result.nextCondition) updated[orphanId] = result.nextCondition;
                    else delete updated[orphanId];
                    onUpdateEditorState({ ...editorState, orphanedConditions: { ...updated, ...newOrphans } });
                }} style={{ width: '100%', padding: '8px 12px', marginBottom: 8, background: '#664400', border: 'none', color: '#fff', borderRadius: 4, cursor: 'pointer' }}>Delete Block Only</button>
                <button onClick={() => { const updated = { ...editorState.orphanedConditions }; delete updated[orphanId]; onUpdateEditorState({ ...editorState, orphanedConditions: updated }); }}
                    style={{ width: '100%', padding: '8px 12px', background: '#aa4444', border: 'none', color: '#fff', borderRadius: 4, cursor: 'pointer' }}>Delete Entire Subtree</button>
            </aside>
        );
    }

    if (selection.kind === 'condition') {
        const { parentNode, parentId, index, transition, isOption, condition } = selection;
        const conditionLabel = condition?.type === 'comparison'
            ? `${condition.variable} ${condition.operator} ${condition.value}`
            : (condition?.type === 'and' || condition?.type === 'or') ? condition.type.toUpperCase() : condition?.type || 'condition';
        return (
            <aside style={{ padding: 16, color: '#ddd', height: '100%', boxSizing: 'border-box', overflowY: 'auto', fontFamily: 'system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", Arial' }}>
                <h2 style={{ marginTop: 0 }}>Condition Block</h2>
                <p style={{ fontSize: 12, color: '#aaa' }}>Part of: {isOption ? `${parentId} / ${transition.targetNodeId}` : parentId}</p>
                <p style={{ fontSize: 12, color: '#cfe8cf' }}>Parsed as: {conditionLabel}</p>
                <button onClick={() => { const copy = JSON.parse(JSON.stringify(condition)); onUpdateEditorState({ ...editorState, orphanedConditions: { ...editorState.orphanedConditions, [crypto.randomUUID()]: copy } }); }}
                    style={{ width: '100%', padding: '8px 12px', marginBottom: 8, background: '#2a4a6a', border: 'none', color: '#fff', borderRadius: 4, cursor: 'pointer' }}>Duplicate &amp; Subconditions</button>
                <button onClick={() => {
                    const result = removeConditionNode(transition.condition, condition);
                    const updatedTransition = { ...transition, condition: result.nextCondition };
                    const updatedNode = isOption ? updateOptionTransition(parentNode, parentId, index, updatedTransition) : updateNodeTransition(parentNode, index, updatedTransition);
                    if (updatedNode) {
                        const newOrphans = Object.fromEntries(result.orphaned.map(o => [crypto.randomUUID(), o]));
                        onUpdateStory({ ...story, nodes: { ...story.nodes, [updatedNode.id]: updatedNode } });
                        onUpdateEditorState({ ...editorState, orphanedConditions: { ...editorState.orphanedConditions, ...newOrphans } });
                    }
                }} style={{ width: '100%', padding: '8px 12px', background: '#aa4444', border: 'none', color: '#fff', borderRadius: 4, cursor: 'pointer' }}>Delete Condition</button>
            </aside>
        );
    }

    if (selection.kind === 'orphanedOptionTransition') {
        const { optionOrphanId, transitionIndex, transition } = selection;
        const updateTransition = (updated: Transition) => {
            const option = editorState.orphanedOptions[optionOrphanId];
            if (!option) return;
            const transitions = [...(option.transitions || [])];
            transitions[transitionIndex] = updated;
            onUpdateEditorState({ ...editorState, orphanedOptions: { ...editorState.orphanedOptions, [optionOrphanId]: { ...option, transitions } } });
        };
        return (
            <aside style={{ padding: 16, color: '#ddd', height: '100%', boxSizing: 'border-box', overflowY: 'auto', fontFamily: 'system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", Arial' }}>
                <h2 style={{ marginTop: 0 }}>Edit Transition</h2>
                <p style={{ fontSize: 12, color: '#aaa' }}>In orphaned option block.</p>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Target Node</label>
                    <input style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={transition.targetNodeId || ''} onChange={(e) => updateTransition({ ...transition, targetNodeId: e.target.value })} />
                </div>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Priority</label>
                    <input type="number" style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={transition.priority ?? 0} onChange={(e) => updateTransition({ ...transition, priority: parseInt(e.target.value || '0', 10) })} />
                </div>
                {transition.condition && (
                    <div style={{ marginBottom: 12, padding: 8, background: '#1a3a1a', borderRadius: 4, borderLeft: '3px solid #6ac06a' }}>
                        <p style={{ margin: 0, fontSize: 12, color: '#cfe8cf' }}>Condition: {formatCondition(transition.condition)}</p>
                    </div>
                )}
                <button onClick={() => {
                    const option = editorState.orphanedOptions[optionOrphanId];
                    if (!option) return;
                    const transitions = [...(option.transitions || [])];
                    transitions.splice(transitionIndex, 1);
                    onUpdateEditorState({ ...editorState, orphanedOptions: { ...editorState.orphanedOptions, [optionOrphanId]: { ...option, transitions } } });
                }} style={{ width: '100%', padding: '8px 12px', background: '#aa4444', border: 'none', color: '#fff', borderRadius: 4, cursor: 'pointer' }}>Delete Transition</button>
            </aside>
        );
    }

    if (selection.kind === 'orphanedOptionComparison') {
        const { optionOrphanId, transitionIndex, transition, condition } = selection;
        const handleChange = (updates: any) => {
            const option = editorState.orphanedOptions[optionOrphanId];
            if (!option) return;
            const transitions = [...(option.transitions || [])];
            transitions[transitionIndex] = { ...transition, condition: updateConditionInTree(transition.condition, condition, updates) };
            onUpdateEditorState({ ...editorState, orphanedOptions: { ...editorState.orphanedOptions, [optionOrphanId]: { ...option, transitions } } });
        };
        return (
            <aside style={{ padding: 16, color: '#ddd', height: '100%', boxSizing: 'border-box', overflowY: 'auto', fontFamily: 'system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", Arial' }}>
                <h2 style={{ marginTop: 0 }}>Edit Comparison</h2>
                <p style={{ fontSize: 12, color: '#aaa' }}>In orphaned option block.</p>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Variable</label>
                    <input style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={condition.variable || ''} onChange={(e) => handleChange({ variable: e.target.value })} />
                </div>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Operator</label>
                    <select value={condition.operator || '=='} onChange={(e) => handleChange({ operator: e.target.value })} style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }}>
                        <option value="==">==</option><option value="!=">!=</option><option value=">">&gt;</option><option value="<">&lt;</option><option value=">=">&gt;=</option><option value="<=">&lt;=</option>
                    </select>
                </div>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Value</label>
                    <input style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={condition.value ?? ''} onChange={(e) => handleChange({ value: parseFloat(e.target.value) })} />
                </div>
                <button onClick={() => {
                    const option = editorState.orphanedOptions[optionOrphanId];
                    if (!option) return;
                    const result = removeConditionNode(transition.condition, condition);
                    const transitions = [...(option.transitions || [])];
                    transitions[transitionIndex] = { ...transition, condition: result.nextCondition };
                    const newOrphans = Object.fromEntries(result.orphaned.map(o => [crypto.randomUUID(), o]));
                    onUpdateEditorState({ ...editorState, orphanedOptions: { ...editorState.orphanedOptions, [optionOrphanId]: { ...option, transitions } }, orphanedConditions: { ...editorState.orphanedConditions, ...newOrphans } });
                }} style={{ width: '100%', padding: '8px 12px', background: '#aa4444', border: 'none', color: '#fff', borderRadius: 4, cursor: 'pointer' }}>Delete Comparison</button>
            </aside>
        );
    }

    if (selection.kind === 'orphanedOptionCondition') {
        const { optionOrphanId, transitionIndex, transition, condition } = selection;
        const conditionLabel = condition?.type === 'comparison'
            ? `${condition.variable} ${condition.operator} ${condition.value}`
            : (condition?.type === 'and' || condition?.type === 'or') ? condition.type.toUpperCase() : condition?.type || 'condition';
        return (
            <aside style={{ padding: 16, color: '#ddd', height: '100%', boxSizing: 'border-box', overflowY: 'auto', fontFamily: 'system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", Arial' }}>
                <h2 style={{ marginTop: 0 }}>Condition Block</h2>
                <p style={{ fontSize: 12, color: '#aaa' }}>In orphaned option block.</p>
                <p style={{ fontSize: 12, color: '#cfe8cf' }}>Parsed as: {conditionLabel}</p>
                <button onClick={() => {
                    const option = editorState.orphanedOptions[optionOrphanId];
                    if (!option) return;
                    const result = removeConditionNode(transition.condition, condition);
                    const transitions = [...(option.transitions || [])];
                    transitions[transitionIndex] = { ...transition, condition: result.nextCondition };
                    const newOrphans = Object.fromEntries(result.orphaned.map(o => [crypto.randomUUID(), o]));
                    onUpdateEditorState({ ...editorState, orphanedOptions: { ...editorState.orphanedOptions, [optionOrphanId]: { ...option, transitions } }, orphanedConditions: { ...editorState.orphanedConditions, ...newOrphans } });
                }} style={{ width: '100%', padding: '8px 12px', background: '#aa4444', border: 'none', color: '#fff', borderRadius: 4, cursor: 'pointer' }}>Delete Condition</button>
            </aside>
        );
    }

    // Regular node inspector
    if (selection.kind !== 'node') return null;
    const node = selection.node;
    return (
        <aside style={{ padding: 16, color: '#ddd', height: '100%', boxSizing: 'border-box', overflowY: 'auto', fontFamily: 'system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", Arial' }}>
            <h2 style={{ marginTop: 0 }}>Inspector</h2>
            <p>Selected Node: {node.id} ({node.type})</p>
            <div style={{ marginBottom: 12 }}>
                <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Label</label>
                <input style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={node.data.label}
                    onChange={(e) => onUpdateNode({ ...node, data: { ...node.data, label: e.target.value } })} />
            </div>
            <div style={{ marginBottom: 12 }}>
                <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Node Id</label>
                <input style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={node.id}
                    onChange={(e) => onUpdateNode({ ...node, id: e.target.value })} />
            </div>
            <div style={{ marginBottom: 12 }}>
                <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Display Text</label>
                <textarea style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box', minHeight: 120 }} value={node.data.displayText}
                    onChange={(e) => onUpdateNode({ ...node, data: { ...node.data, displayText: e.target.value } })} />
            </div>
            <button onClick={() => onDeleteNode(node.id)} disabled={node.id === story.startNodeId}
                style={{ width: '100%', padding: '8px 12px', cursor: node.id === story.startNodeId ? 'not-allowed' : 'pointer', background: node.id === story.startNodeId ? '#3a3a3a' : '#5b1d1d', color: node.id === story.startNodeId ? '#666' : '#fff', border: node.id === story.startNodeId ? '1px solid #555' : '1px solid #7a2a2a', borderRadius: 4, opacity: node.id === story.startNodeId ? 0.5 : 1 }}
                title={node.id === story.startNodeId ? 'Cannot delete the start node' : 'Delete this node'}>
                {node.id === story.startNodeId ? 'Cannot Delete (Start Node)' : 'Delete Node'}
            </button>
        </aside>
    );
};
