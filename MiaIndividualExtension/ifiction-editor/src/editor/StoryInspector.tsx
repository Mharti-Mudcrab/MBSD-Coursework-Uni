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
        </aside>
    );
};

