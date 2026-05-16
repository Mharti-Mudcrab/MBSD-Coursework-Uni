import React, { useCallback, useEffect, useMemo } from 'react';
import { ReactFlow, Background, Controls, useNodesState, type Node } from '@xyflow/react'
import type { StoryData } from '../types'
import '@xyflow/react/dist/style.css'
import { StartNode } from './nodes/StartNode';
import { EndNode } from './nodes/EndNode';
import { DialogueNode } from './nodes/DialogueNode';
import { ChoiceNode } from './nodes/ChoiceNode';
import { StateChangeNode } from './nodes/StateChangeNode';
import { OptionBlock } from './nodes/OptionBlock';
import { TransitionBlock } from './nodes/TransitionBlock';


const nodeTypes = {
    start: StartNode,
    end: EndNode,
    dialogue: DialogueNode,
    choice: ChoiceNode,
    stateChange: StateChangeNode,
    optionBlock: OptionBlock,
    transitionBlock: TransitionBlock
}

interface Props {
    story: StoryData,
    onStoryChange: (story: StoryData) => void;
    selectedNodeId: string | null;
    onSelectNode: (nodeId: string | null) => void;
}

export const StoryEditor: React.FC<Props> = ({story, onStoryChange, selectedNodeId, onSelectNode}) => {

    const initialNodes = useMemo<Node<Record<string, unknown>>[]>(() => {
        const regularNodes =  Object.values(story.nodes).map((node) => ({
            id: node.id,
            type: node.type,
            position: node.position,
            data: node.data as unknown as Record<string, unknown>,
            selected: node.id === selectedNodeId
        }));

        const optionBlocks: Node<Record<string, unknown>>[] = [];
        const transitonBlocks: Node<Record<string, unknown>>[] = [];
        
        Object.values(story.nodes).forEach(node => {
            // Add transition blocks for node-level transitions
                if (node.data.transitions) {
                node.data.transitions.forEach((transition, index) => {
                    // Render transition blocks at their saved position, otherwise neutral origin
                    transitonBlocks.push({
                        id: `${node.id}-${index}`,
                        type: 'transitionBlock',
                        position: transition.position || { x: 0, y: 0 },
                        data: { transitionId: `${node.id}-${index}`, transition, parentNodeId: node.id, isSelected: false, onSelect: () => {} }
                    });
                });
            }
            
            // Add option blocks and their transitions for choice nodes
            if (node.type === 'choice' && (node.data as any).choices) {
                (node.data as any).choices.forEach((option: any, optionIndex: number) => {
                    const optionBlockId = `${node.id}-option-${optionIndex}`;
                    const computedPosition = option.position || { x: 0, y: 0 };
                    optionBlocks.push({
                        id: optionBlockId,
                        type: 'optionBlock',
                        position: computedPosition,
                        data: { 
                            optionId: optionBlockId, 
                            option,
                            parentNodeId: node.id, 
                            optionIndex,
                            optionText: option.displayText || 'Option',
                            transitionCount: option.transitions?.length || 0
                        }
                    });
                    
                 // Add transition blocks for option-level transitions
                    if (option.transitions) {
                        option.transitions.forEach((transition: any, transitionIndex: number) => {
                            // Use the computed option block position as the base for option transitions
                            const optionBase = option.position || computedPosition;
                            const defaultOptionPos = transition.position || { x: 0, y: 0 };
                            transitonBlocks.push({
                                id: `${optionBlockId}-${transitionIndex}`,
                                type: 'transitionBlock',
                                position: defaultOptionPos,
                                data: { 
                                    transitionId: `${optionBlockId}-${transitionIndex}`, 
                                    transition, 
                                    parentNodeId: optionBlockId,
                                    isOption: true,
                                    isSelected: false, 
                                    onSelect: () => {} 
                                }
                            });
                        });
                    }
                });
            }
        });

        return [...regularNodes, ...optionBlocks, ...transitonBlocks];
        

    }, [story.nodes, selectedNodeId]);


    const [nodes, setNodes, onNodesChange] = useNodesState(initialNodes);

    useEffect(() => {
        setNodes(initialNodes);
    }, [initialNodes, setNodes]);

    const onNodeDragStop = useCallback(
        (_event: React.MouseEvent, node: Node<Record<string, unknown>>) => {
            // Check if it's a story node first
            if (story.nodes[node.id]) {
                // Regular story node: persist the moved node's position only.
                const currentStoryNode = story.nodes[node.id];
                const updatedNode = { ...currentStoryNode, position: node.position };

                onStoryChange({
                    ...story,
                    nodes: {
                        ...story.nodes,
                        [node.id]: updatedNode,
                    },
                });
            } else if (node.id.includes('-option-')) {
                // Could be either an option block itself (parentId-option-index)
                // or a transition block from an option (parentId-option-index-transitionIndex)
                const parts = node.id.split('-option-');
                const parentNodeId = parts[0];
                const rest = parts[1];
                const restParts = rest.split('-');
                const optionIndex = parseInt(restParts[0], 10);

                const parentNode = story.nodes[parentNodeId];
                if (!parentNode?.data || parentNode.type !== 'choice') return;

                // If restParts.length === 1 it's the option block itself
                if (restParts.length === 1) {
                    const choices = (parentNode.data as any).choices || [];
                    const updatedChoices = [...choices];
                    updatedChoices[optionIndex] = {
                        ...updatedChoices[optionIndex],
                        position: node.position,
                    };

                    onStoryChange({
                        ...story,
                        nodes: {
                            ...story.nodes,
                            [parentNodeId]: {
                                ...parentNode,
                                data: {
                                    ...parentNode.data,
                                    choices: updatedChoices,
                                },
                            },
                        },
                    });
                    return;
                }

                // Otherwise it's an option transition block: restParts[1] is transitionIndex
                const transitionIndex = parseInt(restParts[1], 10);
                const choices = (parentNode.data as any).choices || [];
                if (!choices[optionIndex]?.transitions) return;

                const updatedChoices = [...choices];
                const updatedTransitions = [...updatedChoices[optionIndex].transitions];
                updatedTransitions[transitionIndex] = {
                    ...updatedTransitions[transitionIndex],
                    position: node.position,
                };
                updatedChoices[optionIndex] = {
                    ...updatedChoices[optionIndex],
                    transitions: updatedTransitions,
                };

                onStoryChange({
                    ...story,
                    nodes: {
                        ...story.nodes,
                        [parentNodeId]: {
                            ...parentNode,
                            data: {
                                ...parentNode.data,
                                choices: updatedChoices,
                            },
                        },
                    },
                });
            } else {
                // Must be a transition block from a node: parse id as "parentNodeId-index"
                const lastDashIndex = node.id.lastIndexOf('-');
                const parentNodeId = node.id.substring(0, lastDashIndex);
                const transitionIndex = parseInt(node.id.substring(lastDashIndex + 1), 10);
                
                const parentNode = story.nodes[parentNodeId];
                if (!parentNode?.data.transitions) return;
                
                const updatedTransitions = [...parentNode.data.transitions];
                updatedTransitions[transitionIndex] = {
                    ...updatedTransitions[transitionIndex],
                    position: node.position,
                };
                
                onStoryChange({
                    ...story,
                    nodes: {
                        ...story.nodes,
                        [parentNodeId]: {
                            ...parentNode,
                            data: {
                                ...parentNode.data,
                                transitions: updatedTransitions,
                            },
                        },
                    },
                });
            }
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

    const edges = useMemo(() => {
        const derivedEdges: any[] = [];
        
        Object.values(story.nodes).forEach(node => {
            if (node.data.transitions) {
                node.data.transitions.forEach((transition, index) => {
                    const transitionBlockId = `${node.id}-${index}`;
                    
                    // Edge from node to transition
                    derivedEdges.push({
                        id: `${node.id}-to-${transitionBlockId}`,
                        source: node.id,
                        target: transitionBlockId,
                        sourceHandle: 'source',
                        targetHandle: 'target',
                    });
                    
                    // Edge from transition to target node
                    derivedEdges.push({
                        id: `${transitionBlockId}-to-${transition.targetNodeId}`,
                        source: transitionBlockId,
                        target: transition.targetNodeId,
                        sourceHandle: 'source',
                        targetHandle: 'target',
                    });
                });
            }
            
            // If this is a choice node, add edges to its option blocks and option transitions
            if (node.type === 'choice' && (node.data as any).choices) {
                (node.data as any).choices.forEach((option: any, optionIndex: number) => {
                    const optionBlockId = `${node.id}-option-${optionIndex}`;

                    // Edge from choice node to its option block
                    derivedEdges.push({
                        id: `${node.id}-to-${optionBlockId}`,
                        source: node.id,
                        target: optionBlockId,
                        sourceHandle: 'source',
                        targetHandle: 'target',
                    });

                    // Option-level transitions (optionBlock -> optionTransitionBlock -> target)
                    if (option.transitions) {
                        option.transitions.forEach((transition: any, tIndex: number) => {
                            const optionTransitionId = `${optionBlockId}-${tIndex}`;

                            // Edge from option block to its transition block
                            derivedEdges.push({
                                id: `${optionBlockId}-to-${optionTransitionId}`,
                                source: optionBlockId,
                                target: optionTransitionId,
                                sourceHandle: 'source',
                                targetHandle: 'target',
                            });

                            // Edge from option transition to the real target node
                            derivedEdges.push({
                                id: `${optionTransitionId}-to-${transition.targetNodeId}`,
                                source: optionTransitionId,
                                target: transition.targetNodeId,
                                sourceHandle: 'source',
                                targetHandle: 'target',
                            });
                        });
                    }
                });
            }
        });
        
        return derivedEdges;
    }, [story.nodes]);

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