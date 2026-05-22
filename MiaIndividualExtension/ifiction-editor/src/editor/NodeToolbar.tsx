import React, { useRef } from 'react';
import type { StoryData, StoryNode, NodeType } from '../types';

interface Props {
    story: StoryData;
    onStoryChange: (story: StoryData) => void;
    onLoadStory: (story: StoryData) => void;
    onSelectNode: (nodeId: string | null) => void;
}

function uniqueId(base: string, existing: Set<string>): string {
    let i = 1;
    while (existing.has(`${base}-${i}`)) i++;
    return `${base}-${i}`;
}

const btnStyle: React.CSSProperties = {
    padding: '4px 11px',
    fontSize: 12,
    cursor: 'pointer',
    background: '#1e1e1e',
    color: '#ccc',
    border: '1px solid #444',
    borderRadius: 4,
};

const dividerStyle: React.CSSProperties = {
    width: 1,
    height: 20,
    background: '#444',
    margin: '0 6px',
    alignSelf: 'center',
    flexShrink: 0,
};

const labelStyle: React.CSSProperties = {
    fontSize: 10,
    color: '#555',
    textTransform: 'uppercase',
    letterSpacing: 1,
    marginRight: 2,
    flexShrink: 0,
};

export const NodeToolbar: React.FC<Props> = ({ story, onStoryChange, onLoadStory, onSelectNode }) => {
    const existingIds = new Set(Object.keys(story.nodes));
    const fileInputRef = useRef<HTMLInputElement>(null);

    const saveStory = () => {
        const blob = new Blob([JSON.stringify(story, null, 2)], { type: 'application/json' });
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
                const loaded = JSON.parse(ev.target?.result as string) as StoryData;
                onLoadStory(loaded);
                onSelectNode(null);
            } catch {
                alert('Invalid story JSON.');
            }
        };
        reader.readAsText(file);
        e.target.value = '';
    };

    const addStoryNode = (type: NodeType) => {
        const id = uniqueId(type, existingIds);
        const pos = { x: 150 + Math.random() * 250, y: 150 + Math.random() * 250 };

        const dataMap: Record<string, object> = {
            dialogue: { label: 'New Dialogue', displayText: 'Enter text here.', transitions: [] },
            choice: { label: 'New Choice', displayText: 'Make a choice.', choices: [] },
            stateChange: { label: 'New State Change', displayText: '', stateChanges: [] },
            end: { label: 'End', displayText: '' },
        };

        const newNode: StoryNode = { id, type, position: pos, data: dataMap[type] as StoryNode['data'] };
        onStoryChange({ ...story, nodes: { ...story.nodes, [id]: newNode } });
        onSelectNode(id);
    };

    const addOrphanTransition = () => {
        const orphan = {
            targetNodeId: '',
            priority: 0,
            position: { x: 200 + Math.random() * 200, y: 200 + Math.random() * 200 },
            _orphanId: crypto.randomUUID(),
        };
        onStoryChange({ ...story, orphanedTransitions: [...(story.orphanedTransitions ?? []), orphan as any] });
    };

    const addOrphanOption = () => {
        const orphan = {
            displayText: 'New Option',
            transitions: [],
            position: { x: 200 + Math.random() * 200, y: 200 + Math.random() * 200 },
            _orphanId: crypto.randomUUID(),
        };
        onStoryChange({ ...story, orphanedOptions: [...(story.orphanedOptions ?? []), orphan as any] });
    };

    const addOrphanVariable = () => {
        const orphan = {
            variable: 'newVar',
            operator: '=' as const,
            value: 0,
            position: { x: 200 + Math.random() * 200, y: 200 + Math.random() * 200 },
            _orphanId: crypto.randomUUID(),
        };
        onStoryChange({ ...story, orphanedVariables: [...(story.orphanedVariables ?? []), orphan as any] });
    };

    const addOrphanComparison = () => {
        const orphan = {
            type: 'comparison' as const,
            variable: 'newVar',
            operator: '==' as const,
            value: 0,
            position: { x: 200 + Math.random() * 200, y: 200 + Math.random() * 200 },
            _orphanId: crypto.randomUUID(),
        };
        onStoryChange({ ...story, orphanedConditions: [...(story.orphanedConditions ?? []), orphan as any] });
    };

    const addOrphanLogical = (gateType: 'and' | 'or') => {
        const orphan = {
            type: gateType,
            left: null,
            right: null,
            position: { x: 200 + Math.random() * 200, y: 200 + Math.random() * 200 },
            _orphanId: crypto.randomUUID(),
        };
        onStoryChange({ ...story, orphanedConditions: [...(story.orphanedConditions ?? []), orphan as any] });
    };

    return (
        <div style={{
            display: 'flex',
            flexDirection: 'row',
            alignItems: 'center',
            gap: 5,
            padding: '0 12px',
            background: '#111',
            borderBottom: '1px solid #2a2a2a',
            height: 38,
            flexShrink: 0,
        }}>
            <span style={labelStyle}>Node</span>
            <button style={btnStyle} onClick={() => addStoryNode('dialogue')}>Dialogue</button>
            <button style={btnStyle} onClick={() => addStoryNode('choice')}>Choice</button>
            <button style={btnStyle} onClick={() => addStoryNode('stateChange')}>State Change</button>
            <button style={btnStyle} onClick={() => addStoryNode('end')}>End</button>
            <div style={dividerStyle} />
            <span style={labelStyle}>Block</span>
            <button style={btnStyle} onClick={addOrphanTransition}>Transition</button>
            <button style={btnStyle} onClick={addOrphanOption}>Option</button>
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
