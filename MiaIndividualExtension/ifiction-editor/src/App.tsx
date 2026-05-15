import { VirtualConsole } from "./editor/VirtualConsole";
import { StoryEditor } from './editor/StoryEditor';
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
            },
        },

        
    }
};

function App() {
    const [story, setStory] = useState<StoryData>(emptyStory);
    const [showPreview, setShowPreview] = useState(true);
    return (
        <div style={{
            width: "100vw",
            height: "100vh",
            display: "flex", 
            flexDirection: "row", 
            backgroundColor: "#1a1a1a",
            overflow: "hidden"
        }}>
            {/* Main Editor */}
            <div style = {{
                flex: 1, 
                position: 'relative',
                borderRight: "1px solid #333"
            }}>
                <button 
                    onClick={() => setShowPreview(!showPreview)}
                    style = {{position: 'absolute', bottom: '20px', right: '20px', zIndex: 10, padding: '8px 12px', cursor: 'pointer'}}
                >
                    {showPreview ? "Hide Output" : "Show Output"}
                </button>
            </div>
            {/* Console */}
            {showPreview && (
                <div style={{ width: '350px', height: '100%', borderLeft: '1px solid #333' }}>
                    <div style={{ padding: '10px', background: '#222', color: '#fff', fontSize: '0.8rem', borderBottom: '1px solid #333' }}>
                        LIVE RUNNER
                    </div>
                    {/* Key property forces the console to reset when the story ID changes or we manual reset */}
                    <VirtualConsole key={story.name} story={story} />
                </div>
            )}
        </div>
    )

}

export default App;