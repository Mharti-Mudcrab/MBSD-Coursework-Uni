import type { StoryNode, Transition } from '../types';

export const updateNodeTransition = (parentNode: StoryNode, index: number, updatedTransition: Transition): StoryNode | null => {
    if (!parentNode.data.transitions) return null;
    const updated = [...parentNode.data.transitions];
    updated[index] = updatedTransition;
    return { ...parentNode, data: { ...parentNode.data, transitions: updated } };
};

export const deleteNodeTransition = (parentNode: StoryNode, index: number): StoryNode | null => {
    if (!parentNode.data.transitions) return null;
    const updated = [...parentNode.data.transitions];
    updated.splice(index, 1);
    return { ...parentNode, data: { ...parentNode.data, transitions: updated } };
};

export const updateOptionTransition = (parentNode: StoryNode, parentId: string, index: number, updatedTransition: Transition): StoryNode | null => {
    if (parentNode.type !== 'choice') return null;
    const optionIndex = parseInt(parentId.split('-option-')[1], 10);
    const choices = [...parentNode.data.choices];
    const option = choices[optionIndex];
    if (!option) return null;
    const transitions = [...option.transitions];
    transitions[index] = updatedTransition;
    choices[optionIndex] = { ...option, transitions };
    return { ...parentNode, data: { ...parentNode.data, choices } } as StoryNode;
};

export const deleteOptionTransition = (parentNode: StoryNode, parentId: string, index: number): StoryNode | null => {
    if (parentNode.type !== 'choice') return null;
    const optionIndex = parseInt(parentId.split('-option-')[1], 10);
    const choices = [...parentNode.data.choices];
    const option = choices[optionIndex];
    if (!option) return null;
    const transitions = [...option.transitions];
    transitions.splice(index, 1);
    choices[optionIndex] = { ...option, transitions };
    return { ...parentNode, data: { ...parentNode.data, choices } } as StoryNode;
};
