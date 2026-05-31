import type { NodePosition } from '../types';

type Positions = Record<string, NodePosition>;

export function remapBlockPositions(positions: Positions, oldBlockId: string, newBlockId: string): Positions {
    const result = { ...positions };
    for (const key of Object.keys(result)) {
        if (key.includes(oldBlockId)) {
            result[key.replace(oldBlockId, newBlockId)] = result[key];
            delete result[key];
        }
    }
    return result;
}

export function remapConditionSubtree(positions: Positions, oldRoot: string, newRoot: string): Positions {
    const result = { ...positions };
    for (const key of Object.keys(result)) {
        if (key === oldRoot || key.startsWith(oldRoot + '-')) {
            result[newRoot + key.slice(oldRoot.length)] = result[key];
            delete result[key];
        }
    }
    return result;
}
