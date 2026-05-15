import React, { useState, useMemo, useEffect, useRef,} from 'react';
import { StoryNode } from '../types';
import { StoryRunner } from '../StoryRunner';
import type { StoryData } from '../types';

interface Props {
    story: StoryData;
}

export const StoryRunnerView: React.FC<Props> = ({ story }) => {

    const runner = useMemo(() => new StoryRunner(story), [story]);

    const [history, setHistory] = useState<string[]>([]);
    const [inputValue, setInputValue] = useState<string>('');
    const scrollRef = useRef<HTMLDivElement>(null);

    useEffect(() => {
        setHistory([...runner.logs]);
    }, []);

    useEffect(() => {
        if (scrollRef.current) {
            scrollRef.current.scrollIntoView({ behavior: 'smooth' });
        }
    }, [history]);


    const choices = runner.getAvailableChoices();
    const isEnd = runner.getCurrentNode().type === 'end';

    const onChoice