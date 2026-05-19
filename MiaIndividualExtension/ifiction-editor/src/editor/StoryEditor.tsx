import React, { useCallback, useEffect, useMemo } from 'react';
import { ReactFlow, Background, Controls, useNodesState, type Node } from '@xyflow/react'
import type { StoryData } from '../types'
import type { ConditionBlockData, TransitionBlockData, OptionBlockData, CanvasNodeData } from './types'
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
import { conditionASTToBlocks } from '../model/conditionBlocksGenerator';


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

interface Props {
    story: StoryData,
    onStoryChange: (story: StoryData) => void;
    selectedNodeId: string | null;
    onSelectNode: (nodeId: string | null) => void;
    blockToConditionRef: React.MutableRefObject<Map<string, any>>;
}

export const StoryEditor: React.FC<Props> = ({story, onStoryChange, selectedNodeId, onSelectNode, blockToConditionRef}) => {

    const { initialNodes, conditionEdges } = useMemo<{ initialNodes: Node<CanvasNodeData>[]; conditionEdges: any[] }>(() => {
        blockToConditionRef.current.clear();
        const regularNodes =  Object.values(story.nodes).map((node) => ({
            id: node.id,
            type: node.type,
            position: node.position,
            data: node.data as unknown as Record<string, unknown>,
            // selected state is managed separately by effect to keep position persistence independent of UI selection
        }));

        const optionBlocks: Node<OptionBlockData>[] = [];
        const transitonBlocks: Node<TransitionBlockData>[] = [];
        const variableBlocks: Node<any>[] = [];
        const conditionNodes: Node<ConditionBlockData>[] = [];
        const conditionEdgesList: any[] = [];
        
        Object.values(story.nodes).forEach(node => {
            // Add transition blocks for node-level transitions
                if (node.data.transitions) {
                node.data.transitions.forEach((transition, index) => {
                    const transitionBlockId = `${node.id}-${index}`;
                    const transitionPos = transition.position || { x: 0, y: 0 };
                    // Render transition blocks at their saved position, otherwise neutral origin
                    transitonBlocks.push({
                        id: transitionBlockId,
                        type: 'transitionBlock',
                        position: transitionPos,
                        data: { transitionId: transitionBlockId, transition, parentNodeId: node.id, isSelected: transitionBlockId === selectedNodeId, onSelect: () => onSelectNode(transitionBlockId) }
                    });

                    // Generate condition blocks if this transition has a condition
                    if (transition.condition) {
                        const conditionBlocks = conditionASTToBlocks(transition.condition, transitionBlockId);
                        conditionNodes.push(...conditionBlocks.nodes);
                        conditionEdgesList.push(...conditionBlocks.edges);
                        // Store block to condition mapping with parent transition ID for reliable lookup
                        conditionBlocks.blockToCondition.forEach((cond, blockId) => {
                            blockToConditionRef.current.set(blockId, { parentTransitionId: transitionBlockId, condition: cond });
                        });
                    }
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
                            const optionTransitionId = `${optionBlockId}-${transitionIndex}`;
                            const transitionPos = transition.position || { x: 0, y: 0 };
                            transitonBlocks.push({
                                id: optionTransitionId,
                                type: 'transitionBlock',
                                position: transitionPos,
                                data: { 
                                    transitionId: optionTransitionId, 
                                    transition, 
                                    parentNodeId: optionBlockId,
                                    isOption: true,
                                    isSelected: optionTransitionId === selectedNodeId, 
                                    onSelect: () => onSelectNode(optionTransitionId) 
                                }
                            });

                            // Generate condition blocks if this option transition has a condition
                            if (transition.condition) {
                                const conditionBlocks = conditionASTToBlocks(transition.condition, optionTransitionId);
                                conditionNodes.push(...conditionBlocks.nodes);
                                conditionEdgesList.push(...conditionBlocks.edges);
                                // Store block to condition mapping with parent transition ID for reliable lookup
                                conditionBlocks.blockToCondition.forEach((cond, blockId) => {
                                    blockToConditionRef.current.set(blockId, { parentTransitionId: optionTransitionId, condition: cond });
                                });
                            }
                        });
                    }
                });
            }
        });

        // Add variable blocks for stateChange nodes (one per state change)
        Object.values(story.nodes).forEach(node => {
            if (node.type === 'stateChange' && (node.data as any).stateChanges) {
                (node.data as any).stateChanges.forEach((change: any, idx: number) => {
                    const varBlockId = `${node.id}-var-${idx}`;
                    const pos = change.position || { x: 0, y: 0 };
                    variableBlocks.push({
                        id: varBlockId,
                        type: 'variableBlock',
                        position: pos,
                        data: {
                            changeId: varBlockId,
                            change,
                            parentNodeId: node.id,
                            index: idx,
                            isSelected: varBlockId === selectedNodeId,
                            onSelect: () => onSelectNode(varBlockId)
                        }
                    });
                });
            }
        });

        // Render orphaned conditions separately, once globally, to avoid duplicate rendering
        if (story.orphanedConditions && story.orphanedConditions.length > 0) {
            story.orphanedConditions.forEach((orphaned: any, orphanIndex: number) => {
                const orphanId = orphaned._orphanId ?? `idx-${orphanIndex}`;
                const orphanTransitionId = `orphan-${orphanId}`;
                const conditionBlocks = conditionASTToBlocks(orphaned, orphanTransitionId);
                conditionNodes.push(...conditionBlocks.nodes);
                conditionEdgesList.push(...conditionBlocks.edges);
                conditionBlocks.blockToCondition.forEach((cond, blockId) => {
                    blockToConditionRef.current.set(blockId, { parentTransitionId: orphanTransitionId, condition: cond, orphanId });
                });
            });
        }

        return { 
            initialNodes: [...regularNodes, ...optionBlocks, ...transitonBlocks, ...variableBlocks, ...conditionNodes],
            conditionEdges: conditionEdgesList
        };

    }, [story.nodes, story.orphanedConditions, selectedNodeId, onSelectNode]);


    const [nodes, setNodes, onNodesChange] = useNodesState(initialNodes);

    useEffect(() => {
        setNodes(prev => {
            // Merge previous node positions for nodes that existed, to avoid resetting derived block positions
            const prevById = new Map(prev.map(n => [n.id, n]));
            return initialNodes.map(n => {
                const old = prevById.get(n.id);
                if (old && old.position) {
                    return { ...n, position: old.position };
                }
                return n;
            });
        });
    }, [initialNodes, setNodes]);

    // Update selected flag without replacing node positions when selection changes
    useEffect(() => {
        setNodes(current => current.map(n => ({ ...n, selected: n.id === selectedNodeId })));
    }, [selectedNodeId, setNodes]);

    const onNodeDragStop = useCallback(
        (_event: React.MouseEvent, node: Node<CanvasNodeData>) => {
            // Check if it's a condition block first
            if (node.id.startsWith('condition-')) {
                const conditionRef = blockToConditionRef.current.get(node.id);
                if (conditionRef) {
                    const { transition, condition: conditionNode } = conditionRef;
                    // Update the condition's position
                    (conditionNode as any).position = node.position;
                    
                    // Find and update the transition in story to trigger a re-render
                    // We need to find which node and transition index this is
                    let found = false;
                    const updatedStory = { ...story, nodes: { ...story.nodes } };
                    
                    Object.values(story.nodes).forEach((storyNode) => {
                        if (!found && storyNode.data.transitions) {
                            storyNode.data.transitions.forEach((t) => {
                                if (t === transition) {
                                    // Found it - update the node
                                    updatedStory.nodes[storyNode.id] = {
                                        ...storyNode,
                                        data: {
                                            ...storyNode.data,
                                            transitions: storyNode.data.transitions ? [...storyNode.data.transitions] : undefined,
                                        },
                                    };
                                    found = true;
                                }
                            });
                        }
                        
                        if (!found && storyNode.type === 'choice' && (storyNode.data as any).choices) {
                            (storyNode.data as any).choices.forEach((option: any) => {
                                if (option.transitions) {
                                    option.transitions.forEach((t: any) => {
                                        if (t === transition) {
                                            // Found it - update the choice
                                            updatedStory.nodes[storyNode.id] = {
                                                ...storyNode,
                                                data: {
                                                    ...storyNode.data,
                                                    choices: [...(storyNode.data as any).choices],
                                                },
                                            };
                                            found = true;
                                        }
                                    });
                                }
                            });
                        }
                    });
                    
                    if (found) {
                        onStoryChange(updatedStory);
                    }
                }
                return;
            }
            
            // Check if it's a story node
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

                // Variable block (parentId-var-index)
                if (node.id.includes('-var-')) {
                    const parts = node.id.split('-var-');
                    const parentNodeId = parts[0];
                    const idx = parseInt(parts[1], 10);
                    const parentNode = story.nodes[parentNodeId];
                    if (!parentNode || parentNode.type !== 'stateChange') return;

                    const updates = [...(parentNode.data.stateChanges || [])];
                    updates[idx] = { ...updates[idx], position: node.position };

                    onStoryChange({
                        ...story,
                        nodes: {
                            ...story.nodes,
                            [parentNodeId]: {
                                ...parentNode,
                                data: {
                                    ...parentNode.data,
                                    stateChanges: updates,
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
        (_event: React.MouseEvent, node: Node<CanvasNodeData>) => {
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
            // Add variable-to-stateChange edges will be added later when building edges

            // Add edges from variable blocks -> stateChange nodes
            if (node.type === 'stateChange' && (node.data as any).stateChanges) {
                (node.data as any).stateChanges.forEach((_change: any, idx: number) => {
                    const varBlockId = `${node.id}-var-${idx}`;
                    derivedEdges.push({
                        id: `${varBlockId}-to-${node.id}`,
                        source: varBlockId,
                        target: node.id,
                        sourceHandle: 'source',
                        targetHandle: 'var',
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
        
        // Add condition block edges computed during node initialization
        derivedEdges.push(...conditionEdges);
        
        return derivedEdges;
    }, [story.nodes, conditionEdges]);

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