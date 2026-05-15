import type { FC } from 'react';
import type { StoryData } from '../types';

interface Props {
    story: StoryData;
}

/**
 * Deprecated in favor of VirtualConsole.
 * Kept as a no-op stub so older imports still compile.
 */
export const StoryRunnerView: FC<Props> = () => {
    return null;
};