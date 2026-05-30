import { VirtualConsole } from "./editor/VirtualConsole";
import { StoryEditor } from './editor/StoryEditor';
import { StoryInspector } from "./editor/StoryInspector";
import { NodeToolbar } from "./editor/NodeToolbar";
import type { StoryData, StoryNode, Transition, EditorState } from './types';
import { emptyEditorState } from './types';
import { useState, useRef } from 'react';
import './App.css'

const emptyStory: StoryData = {
    name: 'New Story',
    startNodeId: 'start',
    nodes: {
        start: {
            id: 'start',
            type: 'start',
            data: { label: 'Start', displayText: '' },
        },
    },
};

const initialEditorState: EditorState = {
    ...emptyEditorState(),
    canvasPositions: { start: { x: 200, y: 200 } },
};

function App() {
    const [story, setStory] = useState<StoryData>(emptyStory);
    const [editorState, setEditorState] = useState<EditorState>(initialEditorState);
    const [canvasKey, setCanvasKey] = useState(0);
    const [showPreview, setShowPreview] = useState(true);
    const [selectedNodeId, setSelectedNodeId] = useState<string | null>(null);
    const [showInspector, setShowInspector] = useState(true);
    const blockToConditionRef = useRef<Map<string, any>>(new Map());
    const spawnPositionRef = useRef<() => { x: number; y: number }>(() => ({ x: 300, y: 300 }));

    const loadStory = (loaded: StoryData, loadedEditorState: EditorState) => {
        setStory(loaded);
        setEditorState(loadedEditorState);
        setSelectedNodeId(null);
        blockToConditionRef.current.clear();
        setCanvasKey(k => k + 1);
    };

    const updateNodeInStory = (updatedNode: StoryNode) => {
        setStory(currentStory => {
            const previousNodeId = selectedNodeId && currentStory.nodes[selectedNodeId]
                ? selectedNodeId
                : updatedNode.id;

            if (!updatedNode.id.trim()) return currentStory;
            if (updatedNode.id !== previousNodeId && currentStory.nodes[updatedNode.id]) return currentStory;

            const nextNodes: StoryData["nodes"] = {};
            for (const [nodeId, node] of Object.entries(currentStory.nodes)) {
                if (nodeId === previousNodeId) {
                    nextNodes[updatedNode.id] = {
                        ...updatedNode,
                        data: {
                            ...updatedNode.data,
                            transitions: (updatedNode.data.transitions ?? []).map((transition: Transition) =>
                                transition.targetNodeId === previousNodeId
                                    ? { ...transition, targetNodeId: updatedNode.id }
                                    : transition
                            ),
                        },
                    };
                    continue;
                }
                nextNodes[nodeId] = {
                    ...node,
                    data: {
                        ...node.data,
                        transitions: node.data.transitions?.map((transition: Transition) =>
                            transition.targetNodeId === previousNodeId
                                ? { ...transition, targetNodeId: updatedNode.id }
                                : transition
                        ),
                    },
                };
            }

            return {
                ...currentStory,
                nodes: nextNodes,
                startNodeId: currentStory.startNodeId === previousNodeId ? updatedNode.id : currentStory.startNodeId,
            };
        });

        // Remap the canvas position to the new node ID if the ID changed
        if (selectedNodeId && story.nodes[selectedNodeId] && updatedNode.id !== selectedNodeId) {
            setEditorState(current => {
                const updated = { ...current.canvasPositions };
                if (updated[selectedNodeId]) {
                    updated[updatedNode.id] = updated[selectedNodeId];
                    delete updated[selectedNodeId];
                }
                return { ...current, canvasPositions: updated };
            });
        }

        if (selectedNodeId && story.nodes[selectedNodeId]) {
            setSelectedNodeId(updatedNode.id);
        }
    };

    const deleteNode = (nodeId: string) => {
        if (story.startNodeId === nodeId) return;

        const nodeToDelete = story.nodes[nodeId];
        const nextNodes = { ...story.nodes };
        delete nextNodes[nodeId];

        // Promote the deleted node's children to orphans in editorState
        const newOrphanedVariables = nodeToDelete?.type === 'stateChange'
            ? Object.fromEntries(((nodeToDelete.data as any).stateChanges || []).map((sc: any) => [crypto.randomUUID(), sc]))
            : {};
        const newOrphanedOptions = nodeToDelete?.type === 'choice'
            ? Object.fromEntries(((nodeToDelete.data as any).choices || []).map((opt: any) => [crypto.randomUUID(), opt]))
            : {};

        setStory(current => ({ ...current, nodes: nextNodes }));
        setEditorState(current => ({
            ...current,
            orphanedVariables: { ...current.orphanedVariables, ...newOrphanedVariables },
            orphanedOptions: { ...current.orphanedOptions, ...newOrphanedOptions },
        }));
        setSelectedNodeId(null);
    };

    return (
        <div style={{ width: "100vw", height: "100vh", display: "flex", flexDirection: "row", backgroundColor: "#1a1a1a", overflow: "hidden", position: 'relative' }}>
            {/* Main Editor */}
            <div style={{ flex: 1, position: 'relative', display: 'flex', flexDirection: 'row', borderRight: "1px solid #333" }}>
                <div style={{ flex: 1, display: 'flex', flexDirection: 'column' }}>
                    <NodeToolbar
                        story={story}
                        editorState={editorState}
                        onStoryChange={setStory}
                        onEditorStateChange={setEditorState}
                        onLoadStory={loadStory}
                        onSelectNode={setSelectedNodeId}
                        getSpawnPosition={() => spawnPositionRef.current()}
                    />
                    <div style={{ flex: 1, position: 'relative' }}>
                        <StoryEditor
                            key={canvasKey}
                            story={story}
                            editorState={editorState}
                            onStoryChange={setStory}
                            onEditorStateChange={setEditorState}
                            selectedNodeId={selectedNodeId}
                            onSelectNode={setSelectedNodeId}
                            blockToConditionRef={blockToConditionRef}
                            spawnPositionRef={spawnPositionRef}
                        />
                    </div>
                </div>

                <div id="inspector-panel" style={{ width: showInspector ? 340 : 40, height: '100%', boxSizing: 'border-box', borderLeft: '1px solid #222', background: '#0f0f0f', transition: 'width 180ms ease', position: 'relative' }}>
                    {showInspector ? (
                        <StoryInspector
                            story={story}
                            editorState={editorState}
                            selectedNode={selectedNodeId}
                            onUpdateNode={updateNodeInStory}
                            onDeleteNode={deleteNode}
                            onUpdateStory={setStory}
                            onUpdateEditorState={setEditorState}
                            blockToConditionRef={blockToConditionRef}
                        />
                    ) : (
                        <div style={{ width: '100%', height: '100%', display: 'flex', alignItems: 'center', justifyContent: 'center', color: '#888' }}>
                            <div style={{ writingMode: 'vertical-rl', transform: 'rotate(180deg)', fontSize: 12 }}>Inspector</div>
                        </div>
                    )}
                    <button id="inspector-toggle-2" onClick={() => setShowInspector(v => !v)} style={{ position: 'absolute', left: -20, top: '50%', transform: 'translateY(-50%)', padding: '6px 8px', cursor: 'pointer', width: 36, borderRadius: 6, background: '#111', color: '#ddd', border: '1px solid #333' }}>{showInspector ? '▶' : '◀'}</button>
                </div>
            </div>

            {/* Console panel */}
            <div id="console-panel" style={{ width: showPreview ? 350 : 40, height: '100%', borderLeft: '1px solid #333', transition: 'width 180ms ease', boxSizing: 'border-box', background: '#0f0f0f', position: 'relative' }}>
                {showPreview ? (
                    <VirtualConsole story={story} />
                ) : (
                    <div style={{ width: '100%', height: '100%', display: 'flex', alignItems: 'center', justifyContent: 'center', color: '#888' }}>
                        <div style={{ writingMode: 'vertical-rl', transform: 'rotate(180deg)', fontSize: 12 }}>Output</div>
                    </div>
                )}
                <button id="console-toggle" onClick={() => setShowPreview(v => !v)} style={{ position: 'absolute', left: -20, top: '50%', transform: 'translateY(-50%)', padding: '6px 8px', cursor: 'pointer', width: 36, borderRadius: 6, background: '#111', color: '#ddd', border: '1px solid #333' }}>{showPreview ? '▶' : '◀'}</button>
            </div>
        </div>
    );
}

export default App;
