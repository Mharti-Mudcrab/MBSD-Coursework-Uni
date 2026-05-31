import React, { useCallback, useEffect, useMemo, useRef } from 'react';
import { ReactFlow, Background, Controls, useNodesState, useReactFlow, type Node, type Connection } from '@xyflow/react'
import type { StoryData, EditorState } from '../types'
import type { CanvasNodeData, BlockRegistryEntry } from './types'
import '@xyflow/react/dist/style.css'
import { StartNode } from './nodes/StartNode';
import { EndNode } from './nodes/EndNode';
import { DialogueNode } from './nodes/DialogueNode';
import { ChoiceNode } from './nodes/ChoiceNode';
import { StateChangeNode } from './nodes/StateChangeNode';
import { VariableBlock } from './nodes/VariableBlock';
import { OptionBlock } from './nodes/OptionBlock';
import { TransitionBlock } from './nodes/TransitionBlock';
import { ComparisonBlock } from './nodes/ComparisonBlock';
import { AndNode } from './nodes/AndNode';
import { OrNode } from './nodes/OrNode';
import { buildCanvasNodes, buildCanvasEdges } from './canvasLayout';
import { applyWiring } from './wiring';

const nodeTypes = {
    start: StartNode,
    end: EndNode,
    dialogue: DialogueNode,
    choice: ChoiceNode,
    stateChange: StateChangeNode,
    variableBlock: VariableBlock,
    optionBlock: OptionBlock,
    transitionBlock: TransitionBlock,
    comparisonBlock: ComparisonBlock,
    andNode: AndNode,
    orNode: OrNode,
}

const ViewportTracker: React.FC<{
    spawnPositionRef: React.MutableRefObject<() => { x: number; y: number }>;
    containerRef: React.RefObject<HTMLDivElement | null>;
}> = ({ spawnPositionRef, containerRef }) => {
    const { screenToFlowPosition } = useReactFlow();
    spawnPositionRef.current = () => {
        const rect = containerRef.current?.getBoundingClientRect();
        if (!rect) return { x: 300, y: 300 };
        return screenToFlowPosition({ x: rect.left + rect.width / 2, y: rect.top + rect.height / 2 });
    };
    return null;
};

interface Props {
    story: StoryData;
    editorState: EditorState;
    onStoryChange: (story: StoryData) => void;
    onEditorStateChange: (editorState: EditorState) => void;
    selectedNodeId: string | null;
    onSelectNode: (nodeId: string | null) => void;
    blockToConditionRef: React.MutableRefObject<Map<string, BlockRegistryEntry>>;
    spawnPositionRef: React.MutableRefObject<() => { x: number; y: number }>;
}

export const StoryEditor: React.FC<Props> = ({ story, editorState, onStoryChange, onEditorStateChange, selectedNodeId, onSelectNode, blockToConditionRef, spawnPositionRef }) => {
    const flowContainerRef = useRef<HTMLDivElement>(null);

    const { nodes: initialNodes, conditionEdges, registry: nextRegistry } = useMemo(
        () => buildCanvasNodes(story, editorState, selectedNodeId, onSelectNode),
        [story.nodes, editorState, selectedNodeId, onSelectNode]
    );

    const [nodes, setNodes, onNodesChange] = useNodesState(initialNodes);

    useEffect(() => {
        setNodes(prev => {
            const prevById = new Map(prev.map(n => [n.id, n]));
            return initialNodes.map(n => {
                const old = prevById.get(n.id);
                if (old && old.position) return { ...n, position: old.position };
                return n;
            });
        });
    }, [initialNodes, setNodes]);

    useEffect(() => {
        setNodes(current => current.map(n => ({ ...n, selected: n.id === selectedNodeId })));
    }, [selectedNodeId, setNodes]);

    useEffect(() => {
        blockToConditionRef.current = nextRegistry;
    }, [nextRegistry, blockToConditionRef]);

    const onNodeDragStop = useCallback(
        (_event: React.MouseEvent, node: Node<CanvasNodeData>) => {
            onEditorStateChange({ ...editorState, canvasPositions: { ...editorState.canvasPositions, [node.id]: node.position } });
        },
        [editorState, onEditorStateChange]
    );

    const handleNodeClick = useCallback(
        (_event: React.MouseEvent, node: Node<CanvasNodeData>) => { onSelectNode(node.id); },
        [onSelectNode]
    );

    const handlePaneClick = useCallback(() => { onSelectNode(null); }, [onSelectNode]);

    const onConnect = useCallback(
        (connection: Connection) => {
            const result = applyWiring(connection, story, editorState, blockToConditionRef.current);
            if (!result) return;
            if (result.nextStory) onStoryChange(result.nextStory);
            if (result.nextEditorState) onEditorStateChange(result.nextEditorState);
        },
        [story, editorState, onStoryChange, onEditorStateChange, blockToConditionRef]
    );

    const edges = useMemo(
        () => buildCanvasEdges(story, editorState, conditionEdges),
        [story.nodes, editorState.orphanedTransitions, editorState.orphanedOptions, conditionEdges]
    );

    return (
        <div ref={flowContainerRef} style={{ width: '100%', height: '100%', minHeight: '500px' }}>
            <ReactFlow
                nodes={nodes}
                edges={edges}
                nodeTypes={nodeTypes}
                onNodesChange={onNodesChange}
                onNodeDragStop={onNodeDragStop}
                onNodeClick={handleNodeClick}
                onPaneClick={handlePaneClick}
                onConnect={onConnect}
                colorMode="dark"
                fitView
                minZoom={0.1}
                style={{ width: '100%', height: '100%' }}
            >
                <Background color="#333" gap={20} />
                <Controls />
                <ViewportTracker spawnPositionRef={spawnPositionRef} containerRef={flowContainerRef} />
            </ReactFlow>
        </div>
    );
};
