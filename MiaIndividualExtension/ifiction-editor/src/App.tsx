import { VirtualConsole } from "./editor/VirtualConsole";
import { StoryEditor } from './editor/StoryEditor';
import { StoryInspector } from "./editor/StoryInspector";
import type { StoryData } from './types';
import { enchantedForest } from "./testStory";
import { useState } from 'react';
import './App.css'

const emptyStory: StoryData = {
    name: "New Story", 
    startNodeId: "node_1",
    nodes: {
        "node_1": {
            id: "node_1",
            type: "start",
            position: { x: 100, y: 100 },
            data: { 
                    label: "Start", 
                    displayText: "Welcome to your new story.",
                    transitions: [{ targetNodeId: "node_2"}]
            },
        },
        "node_2": {
            id: "node_2",
            type: "end",
            position: { x: 500, y: 100 },
            data: { 
                    label: "End", 
                    displayText: "Ending of the story.",
            },
        },

        
    }
};

function App() {
    const [story, setStory] = useState<StoryData>(emptyStory);
    const [showPreview, setShowPreview] = useState(true);
    const [sessionKey, setSessionKey] = useState(0);
    const [selectedNodeId, setSelectedNodeId] = useState<string | null>(null);
    const [showInspector, setShowInspector] = useState(true);
    
    const handleRestart = () => {
        setSessionKey(prev => prev + 1);
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
                <div style={{ flex: 1, position: 'relative' }}>
                    <StoryEditor story={story} onStoryChange={setStory} selectedNodeId={selectedNodeId} onSelectNode={setSelectedNodeId} />
                    {/* Reset Button */}
                    <button 
                        onClick={() => setShowPreview(!showPreview)}
                        style = {{position: 'absolute', bottom: '20px', right: '20px', zIndex: 10, padding: '8px 12px', cursor: 'pointer'}}
                    >
                        {showPreview ? "Hide Output" : "Show Output"}
                    </button>
                </div>

                <div id="inspector-panel" style={{ width: showInspector ? 340 : 40, height: '100%', boxSizing: 'border-box', borderLeft: '1px solid #222', background: '#0f0f0f', transition: 'width 180ms ease', position: 'relative' }}>
                    {showInspector ? (
                        <StoryInspector story={story} selectedNode={selectedNodeId} onUpdateNode={(updatedNode) => {
                        setStory(currentStory => ({
                            ...currentStory,
                            nodes: {
                                ...currentStory.nodes,
                                [updatedNode.id]: updatedNode
                            }
                        }));
                        }} onDeleteNode={(nodeId) => {
                        setStory(currentStory => {
                            const nextNodes = { ...currentStory.nodes };
                            delete nextNodes[nodeId];
                            return {
                                ...currentStory,
                                nodes: nextNodes
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
                    <VirtualConsole key={sessionKey} story={story} />
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