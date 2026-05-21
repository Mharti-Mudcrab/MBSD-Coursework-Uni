import { VirtualConsole } from "./editor/VirtualConsole";
import { StoryEditor } from './editor/StoryEditor';
import { StoryInspector } from "./editor/StoryInspector";
import { NodeToolbar } from "./editor/NodeToolbar";
import type { StoryData, StoryNode, Transition } from './types';
import { enchantedForest } from "./testStory";
import { useState, useRef } from 'react';
import './App.css'

function App() {
    const [story, setStory] = useState<StoryData>(enchantedForest);
    const [showPreview, setShowPreview] = useState(true);
    const [selectedNodeId, setSelectedNodeId] = useState<string | null>(null);
    const [showInspector, setShowInspector] = useState(true);
    const blockToConditionRef = useRef<Map<string, any>>(new Map());

    const updateNodeInStory = (updatedNode: StoryNode) => {
        setStory(currentStory => {
            const previousNodeId = selectedNodeId && currentStory.nodes[selectedNodeId]
                ? selectedNodeId
                : updatedNode.id;

            if (!updatedNode.id.trim()) {
                return currentStory;
            }

            if (updatedNode.id !== previousNodeId && currentStory.nodes[updatedNode.id]) {
                return currentStory;
            }

            const nextNodes: StoryData["nodes"] = {};

            for (const [nodeId, node] of Object.entries(currentStory.nodes)) {
                if (nodeId === previousNodeId) {
                    nextNodes[updatedNode.id] = {
                        ...updatedNode,
                        data: {
                            ...updatedNode.data,
                            transitions: (updatedNode.data.transitions ?? []).map((transition: Transition) => (
                                transition.targetNodeId === previousNodeId
                                    ? { ...transition, targetNodeId: updatedNode.id }
                                    : transition
                            )),
                        },
                    };
                    continue;
                }

                nextNodes[nodeId] = {
                    ...node,
                    data: {
                        ...node.data,
                        transitions: node.data.transitions?.map((transition: Transition) => (
                            transition.targetNodeId === previousNodeId
                                ? { ...transition, targetNodeId: updatedNode.id }
                                : transition
                        )),
                    },
                };
            }

            return {
                ...currentStory,
                nodes: nextNodes,
                startNodeId: currentStory.startNodeId === previousNodeId
                    ? updatedNode.id
                    : currentStory.startNodeId,
            };
        });

        setSelectedNodeId(updatedNode.id);
    };

    return (
        <div style={{
            width: "100vw",
            height: "100vh",
            display: "flex", 
            flexDirection: "row", 
            backgroundColor: "#1a1a1a",
            overflow: "hidden",
            position: 'relative'
        }}>
            {/* Main Editor */}
            <div style = {{
                flex: 1,
                position: 'relative',
                display: 'flex',
                flexDirection: 'row',
                borderRight: "1px solid #333"
            }}>
                <div style={{ flex: 1, display: 'flex', flexDirection: 'column' }}>
                    <NodeToolbar story={story} onStoryChange={setStory} onSelectNode={setSelectedNodeId} />
                    <div style={{ flex: 1, position: 'relative' }}>
                        <StoryEditor story={story} onStoryChange={setStory} selectedNodeId={selectedNodeId} onSelectNode={setSelectedNodeId} blockToConditionRef={blockToConditionRef} />
                        <button
                            onClick={() => setShowPreview(!showPreview)}
                            style={{ position: 'absolute', bottom: '20px', right: '20px', zIndex: 10, padding: '8px 12px', cursor: 'pointer' }}
                        >
                            {showPreview ? "Hide Output" : "Show Output"}
                        </button>
                    </div>
                </div>

                <div id="inspector-panel" style={{ width: showInspector ? 340 : 40, height: '100%', boxSizing: 'border-box', borderLeft: '1px solid #222', background: '#0f0f0f', transition: 'width 180ms ease', position: 'relative' }}>
                    {showInspector ? (
                        <StoryInspector story={story} selectedNode={selectedNodeId} onUpdateNode={updateNodeInStory} blockToConditionRef={blockToConditionRef} onUpdateStory={setStory} onDeleteNode={(nodeId) => {
                        if (story.startNodeId === nodeId) {
                            return;
                        }

                        setStory(currentStory => {
                            const nodeToDelete = currentStory.nodes[nodeId];
                            const nextNodes = { ...currentStory.nodes };
                            delete nextNodes[nodeId];

                            const stampedVariables = nodeToDelete?.type === 'stateChange'
                                ? ((nodeToDelete.data as any).stateChanges || []).map((sc: any) => ({ ...sc, _orphanId: crypto.randomUUID() }))
                                : [];

                            const stampedOptions = nodeToDelete?.type === 'choice'
                                ? ((nodeToDelete.data as any).choices || []).map((opt: any) => ({ ...opt, _orphanId: crypto.randomUUID() }))
                                : [];

                            return {
                                ...currentStory,
                                nodes: nextNodes,
                                orphanedVariables: [...(currentStory.orphanedVariables || []), ...stampedVariables],
                                orphanedOptions: [...(currentStory.orphanedOptions || []), ...stampedOptions],
                            };
                        });
                        setSelectedNodeId(null);
                        }} />
                    ) : (
                        <div style={{ width: '100%', height: '100%', display: 'flex', alignItems: 'center', justifyContent: 'center', color: '#888' }}>
                            <div style={{ writingMode: 'vertical-rl', transform: 'rotate(180deg)', fontSize: 12 }}>Inspector</div>
                        </div>
                    )}
                    {/* Inspector seam toggle - attached to inspector panel */}
                    <button id="inspector-toggle-2" onClick={() => setShowInspector(v => !v)} style={{ position: 'absolute', left: -20, top: '50%', transform: 'translateY(-50%)', padding: '6px 8px', cursor: 'pointer', width: 36, borderRadius: 6, background: '#111', color: '#ddd', border: '1px solid #333' }}>{showInspector ? '▶' : '◀'}</button>
                </div>
                
            </div>
            {/* Console panel (collapsible) */}
            <div id="console-panel" style={{ width: showPreview ? 350 : 40, height: '100%', borderLeft: '1px solid #333', transition: 'width 180ms ease', boxSizing: 'border-box', background: '#0f0f0f', position: 'relative' }}>
                {showPreview ? (
                    <VirtualConsole story={story} />
                ) : (
                    <div style={{ width: '100%', height: '100%', display: 'flex', alignItems: 'center', justifyContent: 'center', color: '#888' }}>
                        <div style={{ writingMode: 'vertical-rl', transform: 'rotate(180deg)', fontSize: 12 }}>Output</div>
                    </div>
                )}
                {/* Console seam toggle - attached to console panel */}
                <button id="console-toggle" onClick={() => setShowPreview(v => !v)} style={{ position: 'absolute', left: -20, top: '50%', transform: 'translateY(-50%)', padding: '6px 8px', cursor: 'pointer', width: 36, borderRadius: 6, background: '#111', color: '#ddd', border: '1px solid #333' }}>{showPreview ? '▶' : '◀'}</button>
            </div>
        </div>
    )

}

export default App;