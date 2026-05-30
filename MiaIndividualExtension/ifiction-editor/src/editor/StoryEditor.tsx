import React, { useCallback, useEffect, useMemo, useRef } from 'react';
import { ReactFlow, Background, Controls, useNodesState, useReactFlow, type Node, type Connection } from '@xyflow/react'
import type { StoryData, Condition, EditorState } from '../types'
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
    story: StoryData;
    editorState: EditorState;
    onStoryChange: (story: StoryData) => void;
    onEditorStateChange: (editorState: EditorState) => void;
    selectedNodeId: string | null;
    onSelectNode: (nodeId: string | null) => void;
    blockToConditionRef: React.MutableRefObject<Map<string, any>>;
    spawnPositionRef: React.MutableRefObject<() => { x: number; y: number }>;
}

export const StoryEditor: React.FC<Props> = ({ story, editorState, onStoryChange, onEditorStateChange, selectedNodeId, onSelectNode, blockToConditionRef, spawnPositionRef }) => {
    const flowContainerRef = useRef<HTMLDivElement>(null);
    const { canvasPositions } = editorState;

    const { initialNodes, conditionEdges } = useMemo<{ initialNodes: Node<CanvasNodeData>[]; conditionEdges: any[] }>(() => {
        blockToConditionRef.current.clear();

        const regularNodes = Object.values(story.nodes).map((node) => ({
            id: node.id,
            type: node.type,
            position: canvasPositions[node.id] ?? { x: 200, y: 200 },
            data: { ...(node.data as unknown as Record<string, unknown>), isSelected: node.id === selectedNodeId },
        }));

        const optionBlocks: Node<OptionBlockData>[] = [];
        const transitionBlocks: Node<TransitionBlockData>[] = [];
        const variableBlocks: Node<any>[] = [];
        const conditionNodes: Node<ConditionBlockData>[] = [];
        const conditionEdgesList: any[] = [];

        Object.values(story.nodes).forEach(node => {
            if (node.data.transitions) {
                node.data.transitions.forEach((transition, index) => {
                    const transitionBlockId = `${node.id}-${index}`;
                    transitionBlocks.push({
                        id: transitionBlockId,
                        type: 'transitionBlock',
                        position: canvasPositions[transitionBlockId] ?? { x: 0, y: 0 },
                        data: { transitionId: transitionBlockId, transition, parentNodeId: node.id, isSelected: transitionBlockId === selectedNodeId, onSelect: () => onSelectNode(transitionBlockId) }
                    });

                    if (transition.condition) {
                        const conditionBlocks = conditionASTToBlocks(transition.condition, transitionBlockId, selectedNodeId, canvasPositions);
                        conditionNodes.push(...conditionBlocks.nodes);
                        conditionEdgesList.push(...conditionBlocks.edges);
                        conditionBlocks.blockToCondition.forEach((cond, blockId) => {
                            blockToConditionRef.current.set(blockId, { parentTransitionId: transitionBlockId, condition: cond });
                        });
                    }
                });
            }

            if (node.type === 'choice' && (node.data as any).choices) {
                (node.data as any).choices.forEach((option: any, optionIndex: number) => {
                    const optionBlockId = `${node.id}-option-${optionIndex}`;
                    optionBlocks.push({
                        id: optionBlockId,
                        type: 'optionBlock',
                        position: canvasPositions[optionBlockId] ?? { x: 0, y: 0 },
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

                    if (option.transitions) {
                        option.transitions.forEach((transition: any, transitionIndex: number) => {
                            const optionTransitionId = `${optionBlockId}-${transitionIndex}`;
                            transitionBlocks.push({
                                id: optionTransitionId,
                                type: 'transitionBlock',
                                position: canvasPositions[optionTransitionId] ?? { x: 0, y: 0 },
                                data: {
                                    transitionId: optionTransitionId,
                                    transition,
                                    parentNodeId: optionBlockId,
                                    isOption: true,
                                    isSelected: optionTransitionId === selectedNodeId,
                                    onSelect: () => onSelectNode(optionTransitionId)
                                }
                            });

                            if (transition.condition) {
                                const conditionBlocks = conditionASTToBlocks(transition.condition, optionTransitionId, selectedNodeId, canvasPositions);
                                conditionNodes.push(...conditionBlocks.nodes);
                                conditionEdgesList.push(...conditionBlocks.edges);
                                conditionBlocks.blockToCondition.forEach((cond, blockId) => {
                                    blockToConditionRef.current.set(blockId, { parentTransitionId: optionTransitionId, condition: cond });
                                });
                            }
                        });
                    }
                });
            }
        });

        Object.values(story.nodes).forEach(node => {
            if (node.type === 'stateChange' && (node.data as any).stateChanges) {
                (node.data as any).stateChanges.forEach((change: any, idx: number) => {
                    const varBlockId = `${node.id}-var-${idx}`;
                    variableBlocks.push({
                        id: varBlockId,
                        type: 'variableBlock',
                        position: canvasPositions[varBlockId] ?? { x: 0, y: 0 },
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

        // Orphaned blocks from editorState
        Object.entries(editorState.orphanedConditions).forEach(([orphanId, condition]) => {
            const orphanTransitionId = `orphan-${orphanId}`;
            const conditionBlocks = conditionASTToBlocks(condition, orphanTransitionId, selectedNodeId, canvasPositions);
            conditionNodes.push(...conditionBlocks.nodes);
            conditionEdgesList.push(...conditionBlocks.edges);
            conditionBlocks.blockToCondition.forEach((cond, blockId) => {
                blockToConditionRef.current.set(blockId, { parentTransitionId: orphanTransitionId, condition: cond, orphanId });
            });
        });

        Object.entries(editorState.orphanedTransitions).forEach(([orphanId, transition]) => {
            const blockId = `orphan-transition-${orphanId}`;
            transitionBlocks.push({
                id: blockId,
                type: 'transitionBlock',
                position: canvasPositions[blockId] ?? { x: 0, y: 0 },
                data: { transitionId: blockId, transition, parentNodeId: null, isSelected: blockId === selectedNodeId, onSelect: () => onSelectNode(blockId) }
            });
            blockToConditionRef.current.set(blockId, { kind: 'orphanedTransition', orphanId, transition });

            if (transition.condition) {
                const conditionBlocks = conditionASTToBlocks(transition.condition, blockId, selectedNodeId, canvasPositions);
                conditionNodes.push(...conditionBlocks.nodes);
                conditionEdgesList.push(...conditionBlocks.edges);
                conditionBlocks.blockToCondition.forEach((cond, cBlockId) => {
                    blockToConditionRef.current.set(cBlockId, { parentTransitionId: blockId, condition: cond });
                });
            }
        });

        Object.entries(editorState.orphanedVariables).forEach(([orphanId, change]) => {
            const blockId = `orphan-variable-${orphanId}`;
            variableBlocks.push({
                id: blockId,
                type: 'variableBlock',
                position: canvasPositions[blockId] ?? { x: 0, y: 0 },
                data: { changeId: blockId, change, parentNodeId: null, index: -1, isSelected: blockId === selectedNodeId, onSelect: () => onSelectNode(blockId) }
            });
            blockToConditionRef.current.set(blockId, { kind: 'orphanedVariable', orphanId, change });
        });

        Object.entries(editorState.orphanedOptions).forEach(([orphanId, option]) => {
            const blockId = `orphan-option-${orphanId}`;
            optionBlocks.push({
                id: blockId,
                type: 'optionBlock',
                position: canvasPositions[blockId] ?? { x: 0, y: 0 },
                data: { optionId: blockId, option, parentNodeId: null, optionIndex: -1, optionText: option.displayText || 'Option', transitionCount: option.transitions?.length || 0, isSelected: blockId === selectedNodeId, onSelect: () => onSelectNode(blockId) }
            });
            blockToConditionRef.current.set(blockId, { kind: 'orphanedOption', orphanId, option });

            if (option.transitions) {
                option.transitions.forEach((transition: any, transitionIndex: number) => {
                    const optionTransitionId = `${blockId}-${transitionIndex}`;
                    transitionBlocks.push({
                        id: optionTransitionId,
                        type: 'transitionBlock',
                        position: canvasPositions[optionTransitionId] ?? { x: 0, y: 0 },
                        data: { transitionId: optionTransitionId, transition, parentNodeId: blockId, isOption: true, isSelected: optionTransitionId === selectedNodeId, onSelect: () => onSelectNode(optionTransitionId) }
                    });
                    blockToConditionRef.current.set(optionTransitionId, { kind: 'orphanedOptionTransition', optionOrphanId: orphanId, transitionIndex, transition });
                    if (transition.condition) {
                        const conditionBlocks = conditionASTToBlocks(transition.condition, optionTransitionId, selectedNodeId, canvasPositions);
                        conditionNodes.push(...conditionBlocks.nodes);
                        conditionEdgesList.push(...conditionBlocks.edges);
                        conditionBlocks.blockToCondition.forEach((cond, cBlockId) => {
                            blockToConditionRef.current.set(cBlockId, { parentTransitionId: optionTransitionId, condition: cond, optionOrphanId: orphanId, transitionIndex, transition });
                        });
                    }
                });
            }
        });

        return {
            initialNodes: [...regularNodes, ...optionBlocks, ...transitionBlocks, ...variableBlocks, ...conditionNodes],
            conditionEdges: conditionEdgesList
        };

    }, [story.nodes, editorState, selectedNodeId, onSelectNode]);

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

    // All drags write to canvasPositions — story data is never touched.
    const onNodeDragStop = useCallback(
        (_event: React.MouseEvent, node: Node<CanvasNodeData>) => {
            onEditorStateChange({
                ...editorState,
                canvasPositions: { ...canvasPositions, [node.id]: node.position }
            });
        },
        [editorState, canvasPositions, onEditorStateChange]
    );

    const handleNodeClick = useCallback(
        (_event: React.MouseEvent, node: Node<CanvasNodeData>) => { onSelectNode(node.id); },
        [onSelectNode]
    );

    const handlePaneClick = useCallback(() => { onSelectNode(null); }, [onSelectNode]);

    const onConnect = useCallback(
        (connection: Connection) => {
            const { source, target, targetHandle } = connection;
            if (!source || !target) return;

            // Returns updated story with the given transitionBlockId's targetNodeId set, or null
            const setTransitionTargetNode = (blockId: string, newTargetId: string): StoryData | null => {
                if (blockId.startsWith('orphan-transition-')) {
                    const orphanId = blockId.slice('orphan-transition-'.length);
                    const orphan = editorState.orphanedTransitions[orphanId];
                    if (!orphan) return null;
                    // Adopt into the story — handled separately in Case 2
                    return null;
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

            const setTransitionCondition = (blockId: string, condition: Condition): StoryData | null => {
                if (blockId.startsWith('orphan-transition-')) {
                    const orphanId = blockId.slice('orphan-transition-'.length);
                    const updated = { ...editorState.orphanedTransitions[orphanId], condition };
                    onEditorStateChange({ ...editorState, orphanedTransitions: { ...editorState.orphanedTransitions, [orphanId]: updated } });
                    return null; // handled via editorState
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

            const touchParentTransition = (parentTransitionId: string): StoryData => {
                if (parentTransitionId.startsWith('orphan-')) return story;
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
            if (targetHandle === 'input' && story.nodes[target] && !source.startsWith('condition-')) {
                if (source.startsWith('orphan-transition-')) {
                    const orphanId = source.slice('orphan-transition-'.length);
                    const orphan = editorState.orphanedTransitions[orphanId];
                    if (!orphan) return;
                    onEditorStateChange({ ...editorState, orphanedTransitions: { ...editorState.orphanedTransitions, [orphanId]: { ...orphan, targetNodeId: target } } });
                    return;
                }
                const updated = setTransitionTargetNode(source, target);
                if (updated) onStoryChange(updated);
                return;
            }

            // ── Case 2: Node/OptionBlock.output → orphaned TransitionBlock.input ──
            if (targetHandle === 'input' && target.startsWith('orphan-transition-')) {
                const orphanId = target.slice('orphan-transition-'.length);
                const orphaned = editorState.orphanedTransitions[orphanId];
                if (!orphaned) return;

                const orphanBlockId = `orphan-transition-${orphanId}`;
                const remainingOrphans = Object.fromEntries(Object.entries(editorState.orphanedTransitions).filter(([k]) => k !== orphanId));
                const updatedPositions = { ...editorState.canvasPositions };

                let newBlockId: string | null = null;
                let updatedOrphanedOptions = editorState.orphanedOptions;

                if (source.includes('-option-') && !source.startsWith('orphan-')) {
                    const splitIdx = source.indexOf('-option-');
                    const parentNodeId = source.substring(0, splitIdx);
                    const optionIndex = parseInt(source.substring(splitIdx + '-option-'.length), 10);
                    const parentNode = story.nodes[parentNodeId];
                    if (!parentNode) return;
                    const choices = [...(parentNode.data as any).choices];
                    newBlockId = `${source}-${(choices[optionIndex].transitions || []).length}`;
                    choices[optionIndex] = { ...choices[optionIndex], transitions: [...(choices[optionIndex].transitions || []), orphaned] };
                    onStoryChange({ ...story, nodes: { ...story.nodes, [parentNodeId]: { ...parentNode, data: { ...parentNode.data, choices } } } });
                } else if (story.nodes[source]) {
                    const parentNode = story.nodes[source];
                    newBlockId = `${source}-${(parentNode.data.transitions || []).length}`;
                    const transitions = [...(parentNode.data.transitions || []), orphaned];
                    onStoryChange({ ...story, nodes: { ...story.nodes, [source]: { ...parentNode, data: { ...parentNode.data, transitions } } } });
                } else if (source.startsWith('orphan-option-')) {
                    const sourceOrphanId = source.slice('orphan-option-'.length);
                    const orphanOption = editorState.orphanedOptions[sourceOrphanId];
                    if (!orphanOption) return;
                    newBlockId = `${source}-${(orphanOption.transitions || []).length}`;
                    updatedOrphanedOptions = { ...editorState.orphanedOptions, [sourceOrphanId]: { ...orphanOption, transitions: [...(orphanOption.transitions || []), orphaned] } };
                }

                if (!newBlockId) return;
                for (const key of Object.keys(updatedPositions)) {
                    if (key.includes(orphanBlockId)) {
                        updatedPositions[key.replace(orphanBlockId, newBlockId)] = updatedPositions[key];
                        delete updatedPositions[key];
                    }
                }
                onEditorStateChange({ ...editorState, orphanedTransitions: remainingOrphans, orphanedOptions: updatedOrphanedOptions, canvasPositions: updatedPositions });
                return;
            }

            // ── Case 2b: ChoiceNode.output → orphaned OptionBlock.input ──────────
            if (targetHandle === 'input' && target.startsWith('orphan-option-')) {
                const orphanId = target.slice('orphan-option-'.length);
                const orphaned = editorState.orphanedOptions[orphanId];
                if (!orphaned || story.nodes[source]?.type !== 'choice') return;
                const parentNode = story.nodes[source];
                const currentChoices = (parentNode.data as any).choices || [];
                const newBlockId = `${source}-option-${currentChoices.length}`;

                const orphanBlockId = `orphan-option-${orphanId}`;
                const updatedPositions = { ...editorState.canvasPositions };
                for (const key of Object.keys(updatedPositions)) {
                    if (key.includes(orphanBlockId)) {
                        updatedPositions[key.replace(orphanBlockId, newBlockId)] = updatedPositions[key];
                        delete updatedPositions[key];
                    }
                }

                onStoryChange({ ...story, nodes: { ...story.nodes, [source]: { ...parentNode, data: { ...parentNode.data, choices: [...currentChoices, orphaned] } } } });
                onEditorStateChange({ ...editorState, orphanedOptions: Object.fromEntries(Object.entries(editorState.orphanedOptions).filter(([k]) => k !== orphanId)), canvasPositions: updatedPositions });
                return;
            }

            // ── Case 3: orphaned ConditionBlock.output → TransitionBlock.condition
            if (targetHandle === 'condition' && source.startsWith('condition-')) {
                const condRef = blockToConditionRef.current.get(source);
                if (!condRef?.parentTransitionId?.startsWith('orphan-')) return;
                const orphanId = condRef.orphanId ?? condRef.parentTransitionId.slice('orphan-'.length);
                const orphanRoot = editorState.orphanedConditions[orphanId];
                if (!orphanRoot) return;

                const oldPrefix = `condition-orphan-${orphanId}-`;
                const newPrefix = `condition-${target}-`;
                const updatedPositions = { ...editorState.canvasPositions };
                for (const key of Object.keys(updatedPositions)) {
                    if (key.startsWith(oldPrefix)) {
                        updatedPositions[newPrefix + key.slice(oldPrefix.length)] = updatedPositions[key];
                        delete updatedPositions[key];
                    }
                }
                const remainingConditions = Object.fromEntries(Object.entries(editorState.orphanedConditions).filter(([k]) => k !== orphanId));

                // Orphaned standalone transition — handle inline to avoid double onEditorStateChange
                if (target.startsWith('orphan-transition-')) {
                    const transOrphanId = target.slice('orphan-transition-'.length);
                    const orphanedTrans = editorState.orphanedTransitions[transOrphanId];
                    if (!orphanedTrans) return;
                    onEditorStateChange({ ...editorState, orphanedTransitions: { ...editorState.orphanedTransitions, [transOrphanId]: { ...orphanedTrans, condition: orphanRoot } }, orphanedConditions: remainingConditions, canvasPositions: updatedPositions });
                    return;
                }

                // Transition inside an orphaned option block
                if (target.startsWith('orphan-option-')) {
                    const withoutPrefix = target.slice('orphan-option-'.length);
                    const lastDash = withoutPrefix.lastIndexOf('-');
                    const optionOrphanId = withoutPrefix.substring(0, lastDash);
                    const transitionIndex = parseInt(withoutPrefix.substring(lastDash + 1), 10);
                    const orphanOption = editorState.orphanedOptions[optionOrphanId];
                    if (!orphanOption) return;
                    const transitions = [...(orphanOption.transitions || [])];
                    transitions[transitionIndex] = { ...transitions[transitionIndex], condition: orphanRoot };
                    onEditorStateChange({ ...editorState, orphanedOptions: { ...editorState.orphanedOptions, [optionOrphanId]: { ...orphanOption, transitions } }, orphanedConditions: remainingConditions, canvasPositions: updatedPositions });
                    return;
                }

                // Regular story transition
                const updated = setTransitionCondition(target, orphanRoot);
                if (updated) onStoryChange(updated);
                onEditorStateChange({ ...editorState, orphanedConditions: remainingConditions, canvasPositions: updatedPositions });
                return;
            }

            // ── Case 4: orphaned ConditionBlock.output → AND/OR.conditionA/conditionB
            if ((targetHandle === 'conditionA' || targetHandle === 'conditionB') && source.startsWith('condition-')) {
                const sourceCondRef = blockToConditionRef.current.get(source);
                if (!sourceCondRef?.parentTransitionId?.startsWith('orphan-')) return;
                const orphanId = sourceCondRef.orphanId ?? sourceCondRef.parentTransitionId.slice('orphan-'.length);
                const orphanRoot = editorState.orphanedConditions[orphanId];
                if (!orphanRoot) return;

                const targetCondRef = blockToConditionRef.current.get(target);
                if (!targetCondRef) return;
                const slot = targetHandle === 'conditionA' ? 'left' : 'right';
                targetCondRef.condition[slot] = orphanRoot;

                // Remap orphan subtree positions: condition-orphan-{id}-root → {andOrNodeId}-{slot}
                const oldCondPrefix = `condition-orphan-${orphanId}-root`;
                const newCondPrefix = `${target}-${slot}`;
                const updatedPositions = { ...editorState.canvasPositions };
                for (const key of Object.keys(updatedPositions)) {
                    if (key === oldCondPrefix || key.startsWith(oldCondPrefix + '-')) {
                        updatedPositions[newCondPrefix + key.slice(oldCondPrefix.length)] = updatedPositions[key];
                        delete updatedPositions[key];
                    }
                }

                const touched = touchParentTransition(targetCondRef.parentTransitionId);
                onStoryChange(touched);
                onEditorStateChange({ ...editorState, orphanedConditions: Object.fromEntries(Object.entries(editorState.orphanedConditions).filter(([k]) => k !== orphanId)), canvasPositions: updatedPositions });
                return;
            }

            // ── Case 5: orphaned VariableBlock.output → StateChangeNode.var ───────
            if (targetHandle === 'var' && source.startsWith('orphan-variable-') && story.nodes[target]?.type === 'stateChange') {
                const orphanId = source.slice('orphan-variable-'.length);
                const orphaned = editorState.orphanedVariables[orphanId];
                if (!orphaned) return;
                const targetNode = story.nodes[target];
                const currentChanges = (targetNode.data as any).stateChanges || [];
                const orphanBlockId = `orphan-variable-${orphanId}`;
                const newBlockId = `${target}-var-${currentChanges.length}`;
                const updatedPositions = { ...editorState.canvasPositions };
                for (const key of Object.keys(updatedPositions)) {
                    if (key.includes(orphanBlockId)) {
                        updatedPositions[key.replace(orphanBlockId, newBlockId)] = updatedPositions[key];
                        delete updatedPositions[key];
                    }
                }
                onStoryChange({ ...story, nodes: { ...story.nodes, [target]: { ...targetNode, data: { ...targetNode.data, stateChanges: [...currentChanges, orphaned] } } } });
                onEditorStateChange({ ...editorState, orphanedVariables: Object.fromEntries(Object.entries(editorState.orphanedVariables).filter(([k]) => k !== orphanId)), canvasPositions: updatedPositions });
                return;
            }
        },
        [story, editorState, onStoryChange, onEditorStateChange, blockToConditionRef]
    );

    const edges = useMemo(() => {
        const derivedEdges: any[] = [];

        Object.values(story.nodes).forEach(node => {
            if (node.data.transitions) {
                node.data.transitions.forEach((transition, index) => {
                    const transitionBlockId = `${node.id}-${index}`;
                    derivedEdges.push({ id: `${node.id}-to-${transitionBlockId}`, source: node.id, target: transitionBlockId, sourceHandle: 'output', targetHandle: 'input' });
                    derivedEdges.push({ id: `${transitionBlockId}-to-${transition.targetNodeId}`, source: transitionBlockId, target: transition.targetNodeId, sourceHandle: 'output', targetHandle: 'input' });
                });
            }

            if (node.type === 'stateChange' && (node.data as any).stateChanges) {
                (node.data as any).stateChanges.forEach((_change: any, idx: number) => {
                    const varBlockId = `${node.id}-var-${idx}`;
                    derivedEdges.push({ id: `${varBlockId}-to-${node.id}`, source: varBlockId, target: node.id, sourceHandle: 'output', targetHandle: 'var' });
                });
            }

            if (node.type === 'choice' && (node.data as any).choices) {
                (node.data as any).choices.forEach((option: any, optionIndex: number) => {
                    const optionBlockId = `${node.id}-option-${optionIndex}`;
                    derivedEdges.push({ id: `${node.id}-to-${optionBlockId}`, source: node.id, target: optionBlockId, sourceHandle: 'output', targetHandle: 'input' });

                    if (option.transitions) {
                        option.transitions.forEach((transition: any, tIndex: number) => {
                            const optionTransitionId = `${optionBlockId}-${tIndex}`;
                            derivedEdges.push({ id: `${optionBlockId}-to-${optionTransitionId}`, source: optionBlockId, target: optionTransitionId, sourceHandle: 'output', targetHandle: 'input' });
                            derivedEdges.push({ id: `${optionTransitionId}-to-${transition.targetNodeId}`, source: optionTransitionId, target: transition.targetNodeId, sourceHandle: 'output', targetHandle: 'input' });
                        });
                    }
                });
            }
        });

        Object.entries(editorState.orphanedTransitions).forEach(([orphanId, orphaned]) => {
            const blockId = `orphan-transition-${orphanId}`;
            if (orphaned.targetNodeId) {
                derivedEdges.push({ id: `${blockId}-to-${orphaned.targetNodeId}`, source: blockId, target: orphaned.targetNodeId, sourceHandle: 'output', targetHandle: 'input' });
            }
        });

        Object.entries(editorState.orphanedOptions).forEach(([orphanId, option]) => {
            const optBlockId = `orphan-option-${orphanId}`;
            (option.transitions || []).forEach((transition: any, tIndex: number) => {
                const optionTransitionId = `${optBlockId}-${tIndex}`;
                derivedEdges.push({ id: `${optBlockId}-to-${optionTransitionId}`, source: optBlockId, target: optionTransitionId, sourceHandle: 'output', targetHandle: 'input' });
                if (transition.targetNodeId) {
                    derivedEdges.push({ id: `${optionTransitionId}-to-${transition.targetNodeId}`, source: optionTransitionId, target: transition.targetNodeId, sourceHandle: 'output', targetHandle: 'input' });
                }
            });
        });

        derivedEdges.push(...conditionEdges);
        return derivedEdges;
    }, [story.nodes, editorState.orphanedTransitions, editorState.orphanedOptions, conditionEdges]);

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
