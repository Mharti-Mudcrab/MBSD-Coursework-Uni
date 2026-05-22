import React, { useCallback, useEffect, useMemo, useRef } from 'react';
import { ReactFlow, Background, Controls, useNodesState, useReactFlow, type Node, type Connection } from '@xyflow/react'
import type { StoryData, Condition } from '../types'
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
    story: StoryData,
    onStoryChange: (story: StoryData) => void;
    selectedNodeId: string | null;
    onSelectNode: (nodeId: string | null) => void;
    blockToConditionRef: React.MutableRefObject<Map<string, any>>;
    spawnPositionRef: React.MutableRefObject<() => { x: number; y: number }>;
}

export const StoryEditor: React.FC<Props> = ({story, onStoryChange, selectedNodeId, onSelectNode, blockToConditionRef, spawnPositionRef}) => {
    const flowContainerRef = useRef<HTMLDivElement>(null);

    const { initialNodes, conditionEdges } = useMemo<{ initialNodes: Node<CanvasNodeData>[]; conditionEdges: any[] }>(() => {
        blockToConditionRef.current.clear();
        const regularNodes =  Object.values(story.nodes).map((node) => ({
            id: node.id,
            type: node.type,
            position: node.position,
            data: { ...(node.data as unknown as Record<string, unknown>), isSelected: node.id === selectedNodeId },
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
                        const conditionBlocks = conditionASTToBlocks(transition.condition, transitionBlockId, selectedNodeId);
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
                            transitionCount: option.transitions?.length || 0,
                            isSelected: optionBlockId === selectedNodeId,
                            onSelect: () => onSelectNode(optionBlockId),
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
                                const conditionBlocks = conditionASTToBlocks(transition.condition, optionTransitionId, selectedNodeId);
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
                const conditionBlocks = conditionASTToBlocks(orphaned, orphanTransitionId, selectedNodeId);
                conditionNodes.push(...conditionBlocks.nodes);
                conditionEdgesList.push(...conditionBlocks.edges);
                conditionBlocks.blockToCondition.forEach((cond, blockId) => {
                    blockToConditionRef.current.set(blockId, { parentTransitionId: orphanTransitionId, condition: cond, orphanId });
                });
            });
        }

        if (story.orphanedTransitions && story.orphanedTransitions.length > 0) {
            story.orphanedTransitions.forEach((orphaned: any, orphanIndex: number) => {
                const orphanId = orphaned._orphanId ?? `trans-idx-${orphanIndex}`;
                const blockId = `orphan-transition-${orphanId}`;
                const pos = orphaned.position || { x: 0, y: 0 };
                transitonBlocks.push({
                    id: blockId,
                    type: 'transitionBlock',
                    position: pos,
                    data: { transitionId: blockId, transition: orphaned, parentNodeId: null, isSelected: blockId === selectedNodeId, onSelect: () => onSelectNode(blockId) }
                });
                blockToConditionRef.current.set(blockId, { kind: 'orphanedTransition', orphanId, transition: orphaned });

                if (orphaned.condition) {
                    const conditionBlocks = conditionASTToBlocks(orphaned.condition, blockId, selectedNodeId);
                    conditionNodes.push(...conditionBlocks.nodes);
                    conditionEdgesList.push(...conditionBlocks.edges);
                    conditionBlocks.blockToCondition.forEach((cond, cBlockId) => {
                        blockToConditionRef.current.set(cBlockId, { parentTransitionId: blockId, condition: cond });
                    });
                }
            });
        }

        if (story.orphanedVariables && story.orphanedVariables.length > 0) {
            story.orphanedVariables.forEach((orphaned: any, orphanIndex: number) => {
                const orphanId = orphaned._orphanId ?? `var-idx-${orphanIndex}`;
                const blockId = `orphan-variable-${orphanId}`;
                const pos = orphaned.position || { x: 0, y: 0 };
                variableBlocks.push({
                    id: blockId,
                    type: 'variableBlock',
                    position: pos,
                    data: { changeId: blockId, change: orphaned, parentNodeId: null, index: -1, isSelected: blockId === selectedNodeId, onSelect: () => onSelectNode(blockId) }
                });
                blockToConditionRef.current.set(blockId, { kind: 'orphanedVariable', orphanId, change: orphaned });
            });
        }

        if (story.orphanedOptions && story.orphanedOptions.length > 0) {
            story.orphanedOptions.forEach((orphaned: any, orphanIndex: number) => {
                const orphanId = orphaned._orphanId ?? `opt-idx-${orphanIndex}`;
                const blockId = `orphan-option-${orphanId}`;
                const pos = orphaned.position || { x: 0, y: 0 };
                optionBlocks.push({
                    id: blockId,
                    type: 'optionBlock',
                    position: pos,
                    data: { optionId: blockId, option: orphaned, parentNodeId: null, optionIndex: -1, optionText: orphaned.displayText || 'Option', transitionCount: orphaned.transitions?.length || 0, isSelected: blockId === selectedNodeId, onSelect: () => onSelectNode(blockId) }
                });
                blockToConditionRef.current.set(blockId, { kind: 'orphanedOption', orphanId, option: orphaned });
            });
        }

        return {
            initialNodes: [...regularNodes, ...optionBlocks, ...transitonBlocks, ...variableBlocks, ...conditionNodes],
            conditionEdges: conditionEdgesList
        };

    }, [story.nodes, story.orphanedConditions, story.orphanedTransitions, story.orphanedVariables, story.orphanedOptions, selectedNodeId, onSelectNode]);


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
            if (node.id.startsWith('orphan-option-')) {
                const orphanId = node.id.slice('orphan-option-'.length);
                onStoryChange({
                    ...story,
                    orphanedOptions: (story.orphanedOptions || []).map((o: any, i: number) =>
                        (o._orphanId ?? `opt-idx-${i}`) === orphanId ? { ...o, position: node.position } : o
                    )
                });
                return;
            }

            if (node.id.startsWith('orphan-transition-')) {
                const orphanId = node.id.slice('orphan-transition-'.length);
                onStoryChange({
                    ...story,
                    orphanedTransitions: (story.orphanedTransitions || []).map((o: any, i: number) =>
                        (o._orphanId ?? `trans-idx-${i}`) === orphanId ? { ...o, position: node.position } : o
                    )
                });
                return;
            }

            if (node.id.startsWith('orphan-variable-')) {
                const orphanId = node.id.slice('orphan-variable-'.length);
                onStoryChange({
                    ...story,
                    orphanedVariables: (story.orphanedVariables || []).map((o: any, i: number) =>
                        (o._orphanId ?? `var-idx-${i}`) === orphanId ? { ...o, position: node.position } : o
                    )
                });
                return;
            }

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
            } else if (node.id.includes('-var-')) {
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
        (_event: React.MouseEvent, node: Node<CanvasNodeData>) => {
            onSelectNode(node.id);
        },
        [onSelectNode]
    );


    const handlePaneClick = useCallback(() => {
        onSelectNode(null);
    }, [onSelectNode]);

    const onConnect = useCallback(
        (connection: Connection) => {
            const { source, target, targetHandle } = connection;
            if (!source || !target) return;

            // Returns updated story with the given transitionBlockId's targetNodeId set, or null
            const setTransitionTargetNode = (blockId: string, newTargetId: string): StoryData | null => {
                if (blockId.startsWith('orphan-transition-')) {
                    const orphanId = blockId.slice('orphan-transition-'.length);
                    return {
                        ...story,
                        orphanedTransitions: (story.orphanedTransitions || []).map((o: any, i: number) =>
                            (o._orphanId ?? `trans-idx-${i}`) === orphanId ? { ...o, targetNodeId: newTargetId } : o
                        ),
                    };
                }
                if (blockId.includes('-option-')) {
                    const splitIdx = blockId.indexOf('-option-');
                    const parentNodeId = blockId.substring(0, splitIdx);
                    const rest = blockId.substring(splitIdx + '-option-'.length).split('-');
                    const optionIndex = parseInt(rest[0], 10);
                    const transitionIndex = parseInt(rest[1], 10);
                    const parentNode = story.nodes[parentNodeId];
                    if (!parentNode) return null;
                    const choices = [...(parentNode.data as any).choices];
                    const transitions = [...choices[optionIndex].transitions];
                    transitions[transitionIndex] = { ...transitions[transitionIndex], targetNodeId: newTargetId };
                    choices[optionIndex] = { ...choices[optionIndex], transitions };
                    return { ...story, nodes: { ...story.nodes, [parentNodeId]: { ...parentNode, data: { ...parentNode.data, choices } } } };
                }
                const lastDash = blockId.lastIndexOf('-');
                const parentNodeId = blockId.substring(0, lastDash);
                const transitionIndex = parseInt(blockId.substring(lastDash + 1), 10);
                const parentNode = story.nodes[parentNodeId];
                if (!parentNode?.data.transitions) return null;
                const transitions = [...parentNode.data.transitions];
                transitions[transitionIndex] = { ...transitions[transitionIndex], targetNodeId: newTargetId };
                return { ...story, nodes: { ...story.nodes, [parentNodeId]: { ...parentNode, data: { ...parentNode.data, transitions } } } };
            };

            // Returns updated story with a condition set on the given transitionBlockId, or null
            const setTransitionCondition = (blockId: string, condition: Condition): StoryData | null => {
                if (blockId.startsWith('orphan-transition-')) {
                    const orphanId = blockId.slice('orphan-transition-'.length);
                    return {
                        ...story,
                        orphanedTransitions: (story.orphanedTransitions || []).map((o: any, i: number) =>
                            (o._orphanId ?? `trans-idx-${i}`) === orphanId ? { ...o, condition } : o
                        ),
                    };
                }
                if (blockId.includes('-option-')) {
                    const splitIdx = blockId.indexOf('-option-');
                    const parentNodeId = blockId.substring(0, splitIdx);
                    const rest = blockId.substring(splitIdx + '-option-'.length).split('-');
                    const optionIndex = parseInt(rest[0], 10);
                    const transitionIndex = parseInt(rest[1], 10);
                    const parentNode = story.nodes[parentNodeId];
                    if (!parentNode) return null;
                    const choices = [...(parentNode.data as any).choices];
                    const transitions = [...choices[optionIndex].transitions];
                    transitions[transitionIndex] = { ...transitions[transitionIndex], condition };
                    choices[optionIndex] = { ...choices[optionIndex], transitions };
                    return { ...story, nodes: { ...story.nodes, [parentNodeId]: { ...parentNode, data: { ...parentNode.data, choices } } } };
                }
                const lastDash = blockId.lastIndexOf('-');
                const parentNodeId = blockId.substring(0, lastDash);
                const transitionIndex = parseInt(blockId.substring(lastDash + 1), 10);
                const parentNode = story.nodes[parentNodeId];
                if (!parentNode?.data.transitions) return null;
                const transitions = [...parentNode.data.transitions];
                transitions[transitionIndex] = { ...transitions[transitionIndex], condition };
                return { ...story, nodes: { ...story.nodes, [parentNodeId]: { ...parentNode, data: { ...parentNode.data, transitions } } } };
            };

            // Shallow-touches the story subtree that owns a parentTransitionId, forcing a re-render
            // after a direct condition mutation (following the same pattern as onNodeDragStop)
            const touchParentTransition = (parentTransitionId: string): StoryData => {
                if (parentTransitionId.startsWith('orphan-transition-')) {
                    return { ...story, orphanedTransitions: [...(story.orphanedTransitions || [])] };
                }
                if (parentTransitionId.startsWith('orphan-')) {
                    // orphaned condition tree
                    return { ...story, orphanedConditions: [...(story.orphanedConditions || [])] };
                }
                if (parentTransitionId.includes('-option-')) {
                    const splitIdx = parentTransitionId.indexOf('-option-');
                    const parentNodeId = parentTransitionId.substring(0, splitIdx);
                    const parentNode = story.nodes[parentNodeId];
                    if (!parentNode) return story;
                    return { ...story, nodes: { ...story.nodes, [parentNodeId]: { ...parentNode, data: { ...parentNode.data } } } };
                }
                const lastDash = parentTransitionId.lastIndexOf('-');
                const parentNodeId = parentTransitionId.substring(0, lastDash);
                const parentNode = story.nodes[parentNodeId];
                if (!parentNode) return story;
                return { ...story, nodes: { ...story.nodes, [parentNodeId]: { ...parentNode } } };
            };

            // ── Case 1: TransitionBlock.output → StoryNode.input ─────────────────
            // Sets the transition's targetNodeId to the target story node
            if (targetHandle === 'input' && story.nodes[target] && !source.startsWith('condition-')) {
                const updated = setTransitionTargetNode(source, target);
                if (updated) onStoryChange(updated);
                return;
            }

            // ── Case 2: StoryNode/OptionBlock.output → orphaned TransitionBlock.input
            // Adopts the orphaned transition into the source node or option
            if (targetHandle === 'input' && target.startsWith('orphan-transition-')) {
                const orphanId = target.slice('orphan-transition-'.length);
                const orphaned = (story.orphanedTransitions || []).find((o: any, i: number) =>
                    (o._orphanId ?? `trans-idx-${i}`) === orphanId
                );
                if (!orphaned) return;
                const { _orphanId: _oid, ...transitionData } = orphaned as any;
                const newOrphans = (story.orphanedTransitions || []).filter((o: any, i: number) =>
                    (o._orphanId ?? `trans-idx-${i}`) !== orphanId
                );

                if (source.includes('-option-') && !source.startsWith('orphan-')) {
                    const splitIdx = source.indexOf('-option-');
                    const parentNodeId = source.substring(0, splitIdx);
                    const optionIndex = parseInt(source.substring(splitIdx + '-option-'.length), 10);
                    const parentNode = story.nodes[parentNodeId];
                    if (!parentNode) return;
                    const choices = [...(parentNode.data as any).choices];
                    choices[optionIndex] = { ...choices[optionIndex], transitions: [...(choices[optionIndex].transitions || []), transitionData] };
                    onStoryChange({ ...story, nodes: { ...story.nodes, [parentNodeId]: { ...parentNode, data: { ...parentNode.data, choices } } }, orphanedTransitions: newOrphans });
                } else if (story.nodes[source]) {
                    const parentNode = story.nodes[source];
                    const transitions = [...(parentNode.data.transitions || []), transitionData];
                    onStoryChange({ ...story, nodes: { ...story.nodes, [source]: { ...parentNode, data: { ...parentNode.data, transitions } } }, orphanedTransitions: newOrphans });
                }
                return;
            }

            // ── Case 2b: ChoiceNode.output → orphaned OptionBlock.input ─────────
            // Adopts the orphaned option into the choice node's choices array
            if (targetHandle === 'input' && target.startsWith('orphan-option-')) {
                const orphanId = target.slice('orphan-option-'.length);
                const orphaned = (story.orphanedOptions || []).find((o: any, i: number) =>
                    (o._orphanId ?? `opt-idx-${i}`) === orphanId
                );
                if (!orphaned || story.nodes[source]?.type !== 'choice') return;
                const { _orphanId: _oid, ...optionData } = orphaned as any;
                const parentNode = story.nodes[source];
                const choices = [...((parentNode.data as any).choices || []), optionData];
                onStoryChange({
                    ...story,
                    nodes: { ...story.nodes, [source]: { ...parentNode, data: { ...parentNode.data, choices } } },
                    orphanedOptions: (story.orphanedOptions || []).filter((o: any, i: number) =>
                        (o._orphanId ?? `opt-idx-${i}`) !== orphanId
                    ),
                });
                return;
            }

            // ── Case 3: (Orphaned) ConditionBlock.output → TransitionBlock.condition
            // Attaches the orphaned condition tree root to the transition's condition field
            if (targetHandle === 'condition' && source.startsWith('condition-')) {
                const condRef = blockToConditionRef.current.get(source);
                if (!condRef?.parentTransitionId?.startsWith('orphan-')) return;
                const orphanId = condRef.orphanId ?? condRef.parentTransitionId.slice('orphan-'.length);
                const orphanRoot = (story.orphanedConditions || []).find((o: any, i: number) =>
                    (o._orphanId ?? `idx-${i}`) === orphanId
                );
                if (!orphanRoot) return;
                const { _orphanId: _, ...conditionData } = orphanRoot as any;
                const updated = setTransitionCondition(target, conditionData as Condition);
                if (!updated) return;
                onStoryChange({
                    ...updated,
                    orphanedConditions: (story.orphanedConditions || []).filter((o: any, i: number) =>
                        (o._orphanId ?? `idx-${i}`) !== orphanId
                    ),
                });
                return;
            }

            // ── Case 4: (Orphaned) ConditionBlock.output → AND/OR.conditionA/conditionB
            // Wires an orphaned condition tree into the left or right slot of a logical group
            if ((targetHandle === 'conditionA' || targetHandle === 'conditionB') && source.startsWith('condition-')) {
                const sourceCondRef = blockToConditionRef.current.get(source);
                if (!sourceCondRef?.parentTransitionId?.startsWith('orphan-')) return;
                const orphanId = sourceCondRef.orphanId ?? sourceCondRef.parentTransitionId.slice('orphan-'.length);
                const orphanRoot = (story.orphanedConditions || []).find((o: any, i: number) =>
                    (o._orphanId ?? `idx-${i}`) === orphanId
                );
                if (!orphanRoot) return;
                const { _orphanId: _, ...conditionData } = orphanRoot as any;

                const targetCondRef = blockToConditionRef.current.get(target);
                if (!targetCondRef) return;
                // Direct mutation matches the existing pattern used in onNodeDragStop for positions
                targetCondRef.condition[targetHandle === 'conditionA' ? 'left' : 'right'] = conditionData;

                const touched = touchParentTransition(targetCondRef.parentTransitionId);
                onStoryChange({
                    ...touched,
                    orphanedConditions: (story.orphanedConditions || []).filter((o: any, i: number) =>
                        (o._orphanId ?? `idx-${i}`) !== orphanId
                    ),
                });
                return;
            }

            // ── Case 5: OrphanedVariable.output → StateChangeNode.var ────────────
            // Adopts an orphaned variable change block into the state change node
            if (targetHandle === 'var' && source.startsWith('orphan-variable-') && story.nodes[target]?.type === 'stateChange') {
                const orphanId = source.slice('orphan-variable-'.length);
                const orphaned = (story.orphanedVariables || []).find((o: any, i: number) =>
                    (o._orphanId ?? `var-idx-${i}`) === orphanId
                );
                if (!orphaned) return;
                const { _orphanId: _oid2, ...changeData } = orphaned as any;
                const targetNode = story.nodes[target];
                onStoryChange({
                    ...story,
                    nodes: {
                        ...story.nodes,
                        [target]: { ...targetNode, data: { ...targetNode.data, stateChanges: [...(targetNode.data.stateChanges || []), changeData] } },
                    },
                    orphanedVariables: (story.orphanedVariables || []).filter((o: any, i: number) =>
                        (o._orphanId ?? `var-idx-${i}`) !== orphanId
                    ),
                });
                return;
            }
        },
        [story, onStoryChange, blockToConditionRef]
    );

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
                        sourceHandle: 'output',
                        targetHandle: 'input',
                    });
                    
                    // Edge from transition to target node
                    derivedEdges.push({
                        id: `${transitionBlockId}-to-${transition.targetNodeId}`,
                        source: transitionBlockId,
                        target: transition.targetNodeId,
                        sourceHandle: 'output',
                        targetHandle: 'input',
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
                        sourceHandle: 'output',
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
                        sourceHandle: 'output',
                        targetHandle: 'input',
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
                                sourceHandle: 'output',
                                targetHandle: 'input',
                            });

                            // Edge from option transition to the real target node
                            derivedEdges.push({
                                id: `${optionTransitionId}-to-${transition.targetNodeId}`,
                                source: optionTransitionId,
                                target: transition.targetNodeId,
                                sourceHandle: 'output',
                                targetHandle: 'input',
                            });
                        });
                    }
                });
            }
        });
        
        // Add edges for orphaned transitions that have a targetNodeId wired
        (story.orphanedTransitions || []).forEach((orphaned: any, orphanIndex: number) => {
            const orphanId = orphaned._orphanId ?? `trans-idx-${orphanIndex}`;
            const blockId = `orphan-transition-${orphanId}`;
            if (orphaned.targetNodeId) {
                derivedEdges.push({
                    id: `${blockId}-to-${orphaned.targetNodeId}`,
                    source: blockId,
                    target: orphaned.targetNodeId,
                    sourceHandle: 'output',
                    targetHandle: 'input',
                });
            }
        });

        // Add condition block edges computed during node initialization
        derivedEdges.push(...conditionEdges);

        return derivedEdges;
    }, [story.nodes, story.orphanedTransitions, conditionEdges]);

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
    )

}