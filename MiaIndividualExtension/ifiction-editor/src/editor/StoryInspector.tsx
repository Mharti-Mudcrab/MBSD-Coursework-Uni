import React from 'react';
import type { Condition, StoryData, StoryNode, Transition, EditorState, StateChangeOperator, StateChange } from '../types';
import type { BlockRegistryEntry } from './types';
import { resolveInspectorSelection } from './inspectorSelection';
import { removeConditionNode, updateConditionInTree, formatCondition, duplicateConditionAsOrphan, isConditionStructurallyValid } from '../model/conditionUtils';
import { updateNodeTransition, deleteNodeTransition, updateOptionTransition, deleteOptionTransition } from '../model/transitionUtils';

interface Props {
    story: StoryData;
    editorState: EditorState;
    selectedNode: string | null;
    onUpdateNode: (node: StoryNode) => void;
    onDeleteNode: (nodeId: string) => void;
    onUpdateStory: (story: StoryData) => void;
    onUpdateEditorState: (editorState: EditorState) => void;
    blockToConditionRef?: React.MutableRefObject<Map<string, BlockRegistryEntry>>;
}

const panelStyle: React.CSSProperties = {
    padding: 16, color: '#ddd', height: '100%', boxSizing: 'border-box',
    overflowY: 'auto', fontFamily: 'system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", Arial'
};

const InspectorPanel: React.FC<{ children: React.ReactNode }> = ({ children }) => (
    <aside style={panelStyle}>{children}</aside>
);

const ComparisonFields: React.FC<{ condition: any; onChange: (updates: any) => void }> = ({ condition, onChange }) => (
    <>
        <div style={{ marginBottom: 12 }}>
            <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Variable</label>
            <input style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={condition.variable || ''} onChange={(e) => onChange({ variable: e.target.value })} />
        </div>
        <div style={{ marginBottom: 12 }}>
            <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Operator</label>
            <select value={condition.operator || '=='} onChange={(e) => onChange({ operator: e.target.value })} style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }}>
                <option value="==">==</option><option value="!=">!=</option><option value=">">&gt;</option><option value="<">&lt;</option><option value=">=">&gt;=</option><option value="<=">&lt;=</option>
            </select>
        </div>
        <div style={{ marginBottom: 12 }}>
            <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Value</label>
            <input type="number" style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={Number.isFinite(condition.value) ? condition.value : ''} onChange={(e) => { const val = parseFloat(e.target.value); if (Number.isFinite(val)) onChange({ value: val }); }} />
        </div>
    </>
);

function conditionLabel(condition: any): string {
    if (condition?.type === 'comparison') return `${condition.variable} ${condition.operator} ${condition.value}`;
    if (condition?.type === 'and' || condition?.type === 'or') return condition.type.toUpperCase();
    return condition?.type || 'condition';
}

export const StoryInspector: React.FC<Props> = ({
    story, editorState, selectedNode, onUpdateNode, onDeleteNode, onUpdateStory, onUpdateEditorState, blockToConditionRef
}) => {
    const selection = resolveInspectorSelection(story, selectedNode, blockToConditionRef);

    if (selection.kind === 'none') {
        return <div style={{ padding: '20px', color: '#888' }}>Select a node to view details</div>;
    }

    if (selection.kind === 'variable') {
        const { parentNode, index, change } = selection;

        const updateChange = (partial: Partial<StateChange>) => {
            const updated = [...parentNode.data.stateChanges];
            updated[index] = { ...updated[index], ...partial };
            onUpdateStory({ ...story, nodes: { ...story.nodes, [parentNode.id]: { ...parentNode, data: { ...parentNode.data, stateChanges: updated } } } });
        };

        return (
            <InspectorPanel>
                <h2 style={{ marginTop: 0 }}>Edit Variable Change</h2>
                <p style={{ fontSize: 12, color: '#aaa' }}>In node: {parentNode.id}</p>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Variable</label>
                    <input style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={change.variable}
                        onChange={(e) => updateChange({ variable: e.target.value })} />
                </div>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Operator</label>
                    <select value={change.operator} onChange={(e) => updateChange({ operator: e.target.value as StateChangeOperator })} style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }}>
                        <option value="=">=</option><option value="+=">+=</option><option value="-=">-=</option>
                    </select>
                </div>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Value</label>
                    <input type="number" style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={change.value}
                        onChange={(e) => updateChange({ value: parseInt(e.target.value || '0', 10) })} />
                </div>
                <button onClick={() => {
                    const updated = [...parentNode.data.stateChanges];
                    updated.splice(index, 1);
                    onUpdateStory({ ...story, nodes: { ...story.nodes, [parentNode.id]: { ...parentNode, data: { ...parentNode.data, stateChanges: updated } } } });
                }} style={{ width: '100%', padding: '8px 12px', background: '#aa4444', border: 'none', color: '#fff', borderRadius: 4, cursor: 'pointer' }}>Delete Change</button>
            </InspectorPanel>
        );
    }

    if (selection.kind === 'transition') {
        const { parentNode, parentId, index, transition, isOption } = selection;
        return (
            <InspectorPanel>
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
                        {!isConditionStructurallyValid(transition.condition) && (
                            <p style={{ margin: 0, fontSize: 12, color: '#c06a6a' }}>Condition is incomplete — transition cannot be traversed.</p>
                        )}
                    </div>
                )}
                <button onClick={() => { const updated = isOption ? deleteOptionTransition(parentNode, parentId, index) : deleteNodeTransition(parentNode, index); if (updated) onUpdateNode(updated); }}
                    style={{ width: '100%', padding: '8px 12px', background: '#aa4444', border: 'none', color: '#fff', borderRadius: 4, cursor: 'pointer' }}>Delete Transition</button>
            </InspectorPanel>
        );
    }

    if (selection.kind === 'comparisonBlock') {
        const { parentNode, parentId, transitionIndex, isOption, condition } = selection;
        const transition = isOption
            ? (parentNode.type === 'choice' ? parentNode.data.choices[parseInt(parentId.split('-option-')[1], 10)]?.transitions?.[transitionIndex] : undefined)
            : parentNode.data.transitions?.[transitionIndex];
        if (!transition || !condition) return null;

        const handleChange = (updates: any) => {
            const updatedFullCondition = updateConditionInTree(transition.condition, condition, updates);
            const updatedTransition = { ...transition, condition: updatedFullCondition };
            const updatedNode = isOption ? updateOptionTransition(parentNode, parentId, transitionIndex, updatedTransition) : updateNodeTransition(parentNode, transitionIndex, updatedTransition);
            if (updatedNode) onUpdateStory({ ...story, nodes: { ...story.nodes, [updatedNode.id]: updatedNode } });
        };

        return (
            <InspectorPanel>
                <h2 style={{ marginTop: 0 }}>Edit Comparison</h2>
                <p style={{ fontSize: 12, color: '#aaa' }}>Part of: {isOption ? `${parentId} → ${transition.targetNodeId}` : parentId}</p>
                <ComparisonFields condition={condition} onChange={handleChange} />
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
            </InspectorPanel>
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
            <InspectorPanel>
                <h2 style={{ marginTop: 0 }}>Edit Orphaned Comparison</h2>
                <p style={{ fontSize: 12, color: '#aaa' }}>Detached — drag onto a transition to reconnect.</p>
                <ComparisonFields condition={condition} onChange={handleChange} />
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
            </InspectorPanel>
        );
    }

    if (selection.kind === 'option') {
        const { parentNode, optionIndex, option } = selection;
        const choices = parentNode.data.choices;

        const updateOption = (displayText: string) => {
            const updated = [...choices];
            updated[optionIndex] = { ...updated[optionIndex], displayText };
            onUpdateStory({ ...story, nodes: { ...story.nodes, [parentNode.id]: { ...parentNode, data: { ...parentNode.data, choices: updated } } } });
        };

        return (
            <InspectorPanel>
                <h2 style={{ marginTop: 0 }}>Edit Option</h2>
                <p style={{ fontSize: 12, color: '#aaa' }}>In node: {parentNode.id}</p>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Display Text</label>
                    <input style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={option.displayText || ''}
                        onChange={(e) => updateOption(e.target.value)} />
                </div>
                <div style={{ marginBottom: 12, padding: 8, background: '#1a1a2a', borderRadius: 4, borderLeft: '3px solid #6a8ac0' }}>
                    <p style={{ margin: 0, fontSize: 12, color: '#aaa' }}>Transitions: {option.transitions.length}</p>
                </div>
                <button onClick={() => {
                    const updated = [...choices];
                    const [removed] = updated.splice(optionIndex, 1);
                    const newOrphans = Object.fromEntries(removed.transitions.map(t => [crypto.randomUUID(), t]));
                    onUpdateStory({ ...story, nodes: { ...story.nodes, [parentNode.id]: { ...parentNode, data: { ...parentNode.data, choices: updated } } } });
                    onUpdateEditorState({ ...editorState, orphanedTransitions: { ...editorState.orphanedTransitions, ...newOrphans } });
                }} style={{ width: '100%', padding: '8px 12px', background: '#aa4444', border: 'none', color: '#fff', borderRadius: 4, cursor: 'pointer' }}>Delete Option</button>
            </InspectorPanel>
        );
    }

    if (selection.kind === 'orphanedOption') {
        const { orphanId, option } = selection;
        return (
            <InspectorPanel>
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
            </InspectorPanel>
        );
    }

    if (selection.kind === 'orphanedTransition') {
        const { orphanId, transition } = selection;
        return (
            <InspectorPanel>
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
                        <p style={{ margin: '0 0 8px 0', fontSize: 12, color: '#cfe8cf' }}>Condition: {formatCondition(transition.condition)}</p>
                        {!isConditionStructurallyValid(transition.condition) && (
                            <p style={{ margin: 0, fontSize: 12, color: '#c06a6a' }}>Condition is incomplete — transition cannot be traversed.</p>
                        )}
                    </div>
                )}
                <button onClick={() => { const updated = { ...editorState.orphanedTransitions }; delete updated[orphanId]; onUpdateEditorState({ ...editorState, orphanedTransitions: updated }); }}
                    style={{ width: '100%', padding: '8px 12px', background: '#aa4444', border: 'none', color: '#fff', borderRadius: 4, cursor: 'pointer' }}>Delete Transition</button>
            </InspectorPanel>
        );
    }

    if (selection.kind === 'orphanedVariable') {
        const { orphanId, change } = selection;
        return (
            <InspectorPanel>
                <h2 style={{ marginTop: 0 }}>Edit Orphaned Variable Change</h2>
                <p style={{ fontSize: 12, color: '#aaa' }}>Detached — wire to a state change node to reconnect.</p>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Variable</label>
                    <input style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={change.variable || ''}
                        onChange={(e) => onUpdateEditorState({ ...editorState, orphanedVariables: { ...editorState.orphanedVariables, [orphanId]: { ...change, variable: e.target.value } } })} />
                </div>
                <div style={{ marginBottom: 12 }}>
                    <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Operator</label>
                    <select value={change.operator || '='} onChange={(e) => onUpdateEditorState({ ...editorState, orphanedVariables: { ...editorState.orphanedVariables, [orphanId]: { ...change, operator: e.target.value as StateChangeOperator } } })} style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }}>
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
            </InspectorPanel>
        );
    }

    if (selection.kind === 'orphanedCondition') {
        const { orphanId, condition } = selection;
        const incomplete = (condition.type === 'and' || condition.type === 'or') && !isConditionStructurallyValid(condition);
        return (
            <InspectorPanel>
                <h2 style={{ marginTop: 0 }}>Orphaned Condition</h2>
                <p style={{ fontSize: 12, color: '#aaa' }}>This condition block is detached. Drag it onto a transition to reconnect it.</p>
                <p style={{ fontSize: 12, color: '#cfe8cf' }}>Parsed as: {conditionLabel(condition)}</p>
                {incomplete && <p style={{ fontSize: 12, color: '#c06a6a' }}>Block is incomplete — transitions this is attached to cannot be traversed.</p>}
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
            </InspectorPanel>
        );
    }

    if (selection.kind === 'condition') {
        const { parentNode, parentId, index, transition, isOption, condition } = selection;
        const incomplete = (condition.type === 'and' || condition.type === 'or') && !isConditionStructurallyValid(condition);
        return (
            <InspectorPanel>
                <h2 style={{ marginTop: 0 }}>Condition Block</h2>
                <p style={{ fontSize: 12, color: '#aaa' }}>Part of: {isOption ? `${parentId} / ${transition.targetNodeId}` : parentId}</p>
                <p style={{ fontSize: 12, color: '#cfe8cf' }}>Parsed as: {conditionLabel(condition)}</p>
                {incomplete && <p style={{ fontSize: 12, color: '#c06a6a' }}>Block is incomplete — transitions this is attached to cannot be traversed.</p>}
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
            </InspectorPanel>
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
            <InspectorPanel>
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
                        <p style={{ margin: '0 0 8px 0', fontSize: 12, color: '#cfe8cf' }}>Condition: {formatCondition(transition.condition)}</p>
                        {!isConditionStructurallyValid(transition.condition) && (
                            <p style={{ margin: 0, fontSize: 12, color: '#c06a6a' }}>Condition is incomplete — transition cannot be traversed.</p>
                        )}
                    </div>
                )}
                <button onClick={() => {
                    const option = editorState.orphanedOptions[optionOrphanId];
                    if (!option) return;
                    const transitions = [...(option.transitions || [])];
                    transitions.splice(transitionIndex, 1);
                    onUpdateEditorState({ ...editorState, orphanedOptions: { ...editorState.orphanedOptions, [optionOrphanId]: { ...option, transitions } } });
                }} style={{ width: '100%', padding: '8px 12px', background: '#aa4444', border: 'none', color: '#fff', borderRadius: 4, cursor: 'pointer' }}>Delete Transition</button>
            </InspectorPanel>
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
            <InspectorPanel>
                <h2 style={{ marginTop: 0 }}>Edit Comparison</h2>
                <p style={{ fontSize: 12, color: '#aaa' }}>In orphaned option block.</p>
                <ComparisonFields condition={condition} onChange={handleChange} />
                <button onClick={() => {
                    const option = editorState.orphanedOptions[optionOrphanId];
                    if (!option) return;
                    const result = removeConditionNode(transition.condition, condition);
                    const transitions = [...(option.transitions || [])];
                    transitions[transitionIndex] = { ...transition, condition: result.nextCondition };
                    const newOrphans = Object.fromEntries(result.orphaned.map(o => [crypto.randomUUID(), o]));
                    onUpdateEditorState({ ...editorState, orphanedOptions: { ...editorState.orphanedOptions, [optionOrphanId]: { ...option, transitions } }, orphanedConditions: { ...editorState.orphanedConditions, ...newOrphans } });
                }} style={{ width: '100%', padding: '8px 12px', background: '#aa4444', border: 'none', color: '#fff', borderRadius: 4, cursor: 'pointer' }}>Delete Comparison</button>
            </InspectorPanel>
        );
    }

    if (selection.kind === 'orphanedOptionCondition') {
        const { optionOrphanId, transitionIndex, transition, condition } = selection;
        const incomplete = (condition.type === 'and' || condition.type === 'or') && !isConditionStructurallyValid(condition);
        return (
            <InspectorPanel>
                <h2 style={{ marginTop: 0 }}>Condition Block</h2>
                <p style={{ fontSize: 12, color: '#aaa' }}>In orphaned option block.</p>
                <p style={{ fontSize: 12, color: '#cfe8cf' }}>Parsed as: {conditionLabel(condition)}</p>
                {incomplete && <p style={{ fontSize: 12, color: '#c06a6a' }}>Block is incomplete — transitions this is attached to cannot be traversed.</p>}
                <button onClick={() => {
                    const option = editorState.orphanedOptions[optionOrphanId];
                    if (!option) return;
                    const result = removeConditionNode(transition.condition, condition);
                    const transitions = [...(option.transitions || [])];
                    transitions[transitionIndex] = { ...transition, condition: result.nextCondition };
                    const newOrphans = Object.fromEntries(result.orphaned.map(o => [crypto.randomUUID(), o]));
                    onUpdateEditorState({ ...editorState, orphanedOptions: { ...editorState.orphanedOptions, [optionOrphanId]: { ...option, transitions } }, orphanedConditions: { ...editorState.orphanedConditions, ...newOrphans } });
                }} style={{ width: '100%', padding: '8px 12px', background: '#aa4444', border: 'none', color: '#fff', borderRadius: 4, cursor: 'pointer' }}>Delete Condition</button>
            </InspectorPanel>
        );
    }

    // Regular node inspector
    if (selection.kind !== 'node') return null;
    const node = selection.node;
    return (
        <InspectorPanel>
            <h2 style={{ marginTop: 0 }}>Inspector</h2>
            <p>Selected Node: {node.id} ({node.type})</p>
            <div style={{ marginBottom: 12 }}>
                <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Label</label>
                <input style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={node.data.label}
                    onChange={(e) => onUpdateNode({ ...node, data: { ...node.data, label: e.target.value } } as StoryNode)} />
            </div>
            <div style={{ marginBottom: 12 }}>
                <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Node Id</label>
                <input style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }} value={node.id}
                    onChange={(e) => onUpdateNode({ ...node, id: e.target.value } as StoryNode)} />
            </div>
            <div style={{ marginBottom: 12 }}>
                <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Display Text</label>
                <textarea style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box', minHeight: 120 }} value={node.data.displayText}
                    onChange={(e) => onUpdateNode({ ...node, data: { ...node.data, displayText: e.target.value } } as StoryNode)} />
            </div>
            <button onClick={() => onDeleteNode(node.id)} disabled={node.id === story.startNodeId}
                style={{ width: '100%', padding: '8px 12px', cursor: node.id === story.startNodeId ? 'not-allowed' : 'pointer', background: node.id === story.startNodeId ? '#3a3a3a' : '#5b1d1d', color: node.id === story.startNodeId ? '#666' : '#fff', border: node.id === story.startNodeId ? '1px solid #555' : '1px solid #7a2a2a', borderRadius: 4, opacity: node.id === story.startNodeId ? 0.5 : 1 }}
                title={node.id === story.startNodeId ? 'Cannot delete the start node' : 'Delete this node'}>
                {node.id === story.startNodeId ? 'Cannot Delete (Start Node)' : 'Delete Node'}
            </button>
        </InspectorPanel>
    );
};
