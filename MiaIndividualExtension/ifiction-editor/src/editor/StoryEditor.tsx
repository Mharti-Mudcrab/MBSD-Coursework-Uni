import React, { useCallback, useEffect, useMemo } from 'react';
import { ReactFlow, Background, Controls, useNodesState, type Node } from '@xyflow/react'
import type { StoryData } from '../types'
import '@xyflow/react/dist/style.css'
import { StartNode } from './nodes/StartNode';
import { EndNode } from './nodes/EndNode';


const nodeTypes = {
    start: StartNode,
    end: EndNode
}

interface Props {
    story: StoryData,
    onStoryChange: (story: StoryData) => void;
    selectedNodeId: string | null;
    onSelectNode: (nodeId: string | null) => void;
}

export const StoryEditor: React.FC<Props> = ({story, onStoryChange, selectedNodeId, onSelectNode}) => {

    const initialNodes = useMemo<Node<Record<string, unknown>>[]>(() => {
        return Object.values(story.nodes).map((node) => ({
            id: node.id,
            type: node.type,
            position: node.position,
            data: node.data as unknown as Record<string, unknown>,
            selected: node.id === selectedNodeId
        }));
    }, [story.nodes, selectedNodeId]);

    const [nodes, setNodes, onNodesChange] = useNodesState(initialNodes);

    useEffect(() => {
        setNodes(initialNodes);
    }, [initialNodes, setNodes]);

    const onNodeDragStop = useCallback(
        (_event: React.MouseEvent, node: Node<Record<string, unknown>>) => {
            const currentStoryNode = story.nodes[node.id];

            if (!currentStoryNode) {
                return;
            }

            onStoryChange({
                ...story,
                nodes: {
                    ...story.nodes,
                    [node.id]: {
                        ...currentStoryNode,
                        position: node.position,
                    },
                },
            });
        },
        [story, onStoryChange]
    );


    const handleNodeClick = useCallback(
        (_event: React.MouseEvent, node: Node<Record<string, unknown>>) => {
            onSelectNode(node.id);
        },
        [onSelectNode]
    );


    const handlePaneClick = useCallback(() => {
        onSelectNode(null);
    }, [onSelectNode]);

    const edges: any[] = []
    return (
        <div style={{ width: '100%', height: '100%', minHeight: '500px' }}>
            <ReactFlow
                nodes={nodes}
                edges={edges}
                nodeTypes={nodeTypes}
                onNodesChange={onNodesChange}
                onNodeDragStop={onNodeDragStop}
                onNodeClick={handleNodeClick}
                onPaneClick={handlePaneClick}
                colorMode="dark"
                fitView
                minZoom={0.1}
                style={{ width: '100%', height: '100%' }}
            >
                <Background color="#333" gap={20} />
                <Controls />
            </ReactFlow>
        </div>
    )

}