import type { StoryData, StoryNode } from '../types';

interface Props {
    story: StoryData;
    selectedNode: string | null;
    onUpdateNode: (node: StoryNode) => void;
    onDeleteNode: (nodeId: string) => void;
}

export const StoryInspector: React.FC<Props> = ({ 
    story, 
    selectedNode, 
    onUpdateNode, 
    onDeleteNode
}) => {
    const node = selectedNode && selectedNode in story.nodes
        ? story.nodes[selectedNode]
        : null;
    
    if (!node) {
        return (
            <div style={{ padding: '20px', color: '#888' }}>
                Select a node to view details
            </div>
        );
    }

    return (
        <aside style={{ padding: 16, color: '#ddd', height: '100%', boxSizing: 'border-box', overflowY: 'auto', fontFamily: 'system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", Arial' }}>
            <h2 style={{ marginTop: 0 }}>Inspector</h2>
            <p> Selected Node: {node.id} ({node.type}) </p>

            <div style={{ marginBottom: 12 }}>
                <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Label</label>
                <input
                    style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }}
                    value={node.data.label}
                    onChange={(e) =>
                        onUpdateNode({
                            ...node,
                            data: {
                                ...node.data,
                                label: e.target.value,
                            },
                        })
                    }
                />
            </div>

            <div style={{ marginBottom: 12 }}>
                <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Node Id</label>
                <input
                    style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box' }}
                    value={node.id}
                    onChange={(e) =>
                        onUpdateNode({
                            ...node,
                            id: e.target.value,
                        })
                    }
                />
            </div>

            <div style={{ marginBottom: 12 }}>
                <label style={{ display: 'block', color: '#aaa', fontSize: 12 }}>Display Text</label>
                <textarea
                    style={{ width: '100%', padding: '6px 8px', boxSizing: 'border-box', minHeight: 120 }}
                    value={node.data.displayText}
                    onChange={(e) =>
                        onUpdateNode({
                            ...node,
                            data: {
                                ...node.data,
                                displayText: e.target.value,
                            },
                        })
                    }
                />
            </div>

            <button
                onClick={() => onDeleteNode(node.id)}
                disabled={node.id === story.startNodeId}
                style={{
                    width: '100%',
                    padding: '8px 12px',
                    cursor: node.id === story.startNodeId ? 'not-allowed' : 'pointer',
                    background: node.id === story.startNodeId ? '#3a3a3a' : '#5b1d1d',
                    color: node.id === story.startNodeId ? '#666' : '#fff',
                    border: node.id === story.startNodeId ? '1px solid #555' : '1px solid #7a2a2a',
                    borderRadius: 4,
                    opacity: node.id === story.startNodeId ? 0.5 : 1,
                }}
                title={node.id === story.startNodeId ? 'Cannot delete the start node' : 'Delete this node'}
            >
                {node.id === story.startNodeId ? 'Cannot Delete (Start Node)' : 'Delete Node'}
            </button>
        </aside>
    );
};

