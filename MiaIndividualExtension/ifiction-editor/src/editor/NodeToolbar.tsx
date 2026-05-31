import React, { useRef } from 'react';
import type { StoryData, StoryNode, NodeType, EditorState, Condition } from '../types';

interface Props {
    story: StoryData;
    editorState: EditorState;
    onStoryChange: (story: StoryData) => void;
    onEditorStateChange: (editorState: EditorState) => void;
    onLoadStory: (story: StoryData, editorState: EditorState) => void;
    onSelectNode: (nodeId: string | null) => void;
    getSpawnPosition?: () => { x: number; y: number };
}

function uniqueId(base: string, existing: Set<string>): string {
    let i = 1;
    while (existing.has(`${base}-${i}`)) i++;
    return `${base}-${i}`;
}

const btnStyle: React.CSSProperties = {
    padding: '4px 11px', fontSize: 12, cursor: 'pointer',
    background: '#1e1e1e', color: '#ccc', border: '1px solid #444', borderRadius: 4,
};
const dividerStyle: React.CSSProperties = {
    width: 1, height: 20, background: '#444', margin: '0 6px', alignSelf: 'center', flexShrink: 0,
};
const labelStyle: React.CSSProperties = {
    fontSize: 10, color: '#555', textTransform: 'uppercase', letterSpacing: 1, marginRight: 2, flexShrink: 0,
};

export const NodeToolbar: React.FC<Props> = ({ story, editorState, onStoryChange, onEditorStateChange, onLoadStory, onSelectNode, getSpawnPosition }) => {
    const existingIds = new Set(Object.keys(story.nodes));
    const fileInputRef = useRef<HTMLInputElement>(null);

    const spawnPos = () => {
        const base = getSpawnPosition ? getSpawnPosition() : { x: 300, y: 300 };
        return { x: base.x + (Math.random() - 0.5) * 120, y: base.y + (Math.random() - 0.5) * 120 };
    };

    const saveStory = () => {
        const blob = new Blob([JSON.stringify({ story, editorState }, null, 2)], { type: 'application/json' });
        const url = URL.createObjectURL(blob);
        const a = document.createElement('a');
        a.href = url;
        a.download = 'story.json';
        a.click();
        URL.revokeObjectURL(url);
    };

    const loadStory = (e: React.ChangeEvent<HTMLInputElement>) => {
        const file = e.target.files?.[0];
        if (!file) return;
        const reader = new FileReader();
        reader.onload = (ev) => {
            try {
                const parsed = JSON.parse(ev.target?.result as string);
                onLoadStory(parsed.story, parsed.editorState);
            } catch {
                alert('Invalid story JSON.');
            }
        };
        reader.readAsText(file);
        e.target.value = '';
    };

    const addStoryNode = (type: Exclude<NodeType, 'start'>) => {
        const id = uniqueId(type, existingIds);
        const pos = spawnPos();
        const dataMap: Record<Exclude<NodeType, 'start'>, object> = {
            dialogue: { label: 'New Dialogue', displayText: 'Enter text here.', transitions: [] },
            choice: { label: 'New Choice', displayText: 'Make a choice.', choices: [] },
            stateChange: { label: 'New State Change', displayText: '', stateChanges: [] },
            end: { label: 'End', displayText: '' },
        };
        const newNode = { id, type, data: dataMap[type] } as StoryNode;
        onStoryChange({ ...story, nodes: { ...story.nodes, [id]: newNode } });
        onEditorStateChange({ ...editorState, canvasPositions: { ...editorState.canvasPositions, [id]: pos } });
        onSelectNode(id);
    };

    const addOrphanTransition = () => {
        const id = crypto.randomUUID();
        onEditorStateChange({
            ...editorState,
            orphanedTransitions: { ...editorState.orphanedTransitions, [id]: { targetNodeId: '', priority: 0 } },
            canvasPositions: { ...editorState.canvasPositions, [`orphan-transition-${id}`]: spawnPos() },
        });
    };

    const addOrphanOption = () => {
        const id = crypto.randomUUID();
        onEditorStateChange({
            ...editorState,
            orphanedOptions: { ...editorState.orphanedOptions, [id]: { displayText: 'New Option', transitions: [] } },
            canvasPositions: { ...editorState.canvasPositions, [`orphan-option-${id}`]: spawnPos() },
        });
    };

    const addOrphanVariable = () => {
        const id = crypto.randomUUID();
        onEditorStateChange({
            ...editorState,
            orphanedVariables: { ...editorState.orphanedVariables, [id]: { variable: 'newVar', operator: '=' as const, value: 0 } },
            canvasPositions: { ...editorState.canvasPositions, [`orphan-variable-${id}`]: spawnPos() },
        });
    };

    const addOrphanComparison = () => {
        const id = crypto.randomUUID();
        const condition: Condition = { type: 'comparison', variable: 'newVar', operator: '==', value: 0 };
        onEditorStateChange({
            ...editorState,
            orphanedConditions: { ...editorState.orphanedConditions, [id]: condition },
            canvasPositions: { ...editorState.canvasPositions, [`condition-orphan-${id}-root`]: spawnPos() },
        });
    };

    const addOrphanLogical = (gateType: 'and' | 'or') => {
        const id = crypto.randomUUID();
        const condition: Condition = { type: gateType, left: null as any, right: null as any };
        onEditorStateChange({
            ...editorState,
            orphanedConditions: { ...editorState.orphanedConditions, [id]: condition },
            canvasPositions: { ...editorState.canvasPositions, [`condition-orphan-${id}-root`]: spawnPos() },
        });
    };

    return (
        <div style={{ display: 'flex', flexDirection: 'row', alignItems: 'center', gap: 5, padding: '0 12px', background: '#111', borderBottom: '1px solid #2a2a2a', height: 38, flexShrink: 0 }}>
            <span style={labelStyle}>Node</span>
            <button style={btnStyle} onClick={() => addStoryNode('dialogue')}>Dialogue</button>
            <button style={btnStyle} onClick={() => addStoryNode('choice')}>Choice</button>
            <button style={btnStyle} onClick={() => addStoryNode('stateChange')}>State Change</button>
            <button style={btnStyle} onClick={() => addStoryNode('end')}>End</button>
            <div style={dividerStyle} />
            <span style={labelStyle}>Block</span>
            <button style={btnStyle} onClick={addOrphanTransition}>Transition</button>
            <button style={btnStyle} onClick={addOrphanOption}>Choice Option</button>
            <button style={btnStyle} onClick={addOrphanVariable}>Variable</button>
            <div style={dividerStyle} />
            <span style={labelStyle}>Condition</span>
            <button style={btnStyle} onClick={addOrphanComparison}>Comparison</button>
            <button style={btnStyle} onClick={() => addOrphanLogical('and')}>AND</button>
            <button style={btnStyle} onClick={() => addOrphanLogical('or')}>OR</button>
            <div style={dividerStyle} />
            <span style={labelStyle}>File</span>
            <button style={btnStyle} onClick={saveStory}>Save</button>
            <button style={btnStyle} onClick={() => fileInputRef.current?.click()}>Load</button>
            <input ref={fileInputRef} type="file" accept=".json" style={{ display: 'none' }} onChange={loadStory} />
        </div>
    );
};
