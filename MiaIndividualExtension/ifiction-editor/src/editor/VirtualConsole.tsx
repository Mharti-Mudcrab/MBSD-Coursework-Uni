import React, { useState, useEffect, useRef, useMemo } from 'react';
import { StoryRunner } from '../StoryRunner';
import type { StoryData } from '../types';

export const VirtualConsole: React.FC<{ story: StoryData }> = ({ story }) => {
    // Init runner
    const runner = useMemo(() => new StoryRunner(story), [story]);
    const [history, setHistory] = useState<string[]>([]);
    const [inputValue, setInputValue] = useState('');
    const scrollRef = useRef<HTMLDivElement>(null);

    useEffect(() => {
        // Init logs from start node
        setHistory([...runner.logs]);
        printChoices(runner);
    }, [runner]);

    useEffect(() => {
        scrollRef.current?.scrollIntoView({ behavior: 'smooth' });
    }, [history]);


    const printChoices = (runner: StoryRunner) => {
        const choices = runner.getAvailableChoices();
            if (choices.length > 0) {
                const choiceText = "\nAvailable Options:\n" + choices.map((c, i) => `- ${c}`).join('\n');
                setHistory(prev => [...prev, choiceText]);
            }
    };

    const handleCommand = (e: React.FormEvent) => {
        e.preventDefault();
        const input = inputValue.trim();
        if (!input) return;

        const availableChoices = runner.getAvailableChoices();

        setHistory(prev => [...prev, `> ${input}`]);

        const match = availableChoices.find(
            choice => choice.toLowerCase() === input.toLowerCase()
        );

        if (match) {
            runner.handleChoice(match);
            setHistory([...runner.logs]);
            printChoices(runner);
        } else {
            setHistory(prev => [...prev, `Error: Invalid input '${input}'.`])
        }

        setInputValue('');
    };

    return (
        <div style= {{
            backgroundColor: '#0c0c0c',
            color: '#d1d1d1',
            fontFamily: 'monospace',
            padding: '20px',
            height: '100%',
            width: '100%',
            boxSizing: "border-box",
            display: 'flex',
            flexDirection: 'column',
            border: '1px solid #333'
        }}>
            {/* Output */}
            <div style={{ flex: 1, overflowY: 'auto', overflowX: 'hidden', marginBottom: '10px', whiteSpace: "pre-wrap", wordBreak: "break-word" }}>
                {history.map((line, i) => (
                    <div key={i} style = {{
                        marginBottom: '8px',
                        lineHeight: '1.5',
                        color: line.startsWith('>') ? '#4ec9b0' : line.startsWith("Error") ? '#f44747' : '#d1d1d1'
                    }}>
                        {line}
                    </div>
                ))}
                <div ref={scrollRef} />
            </div>
            {/* Input Line */}
            <form onSubmit={handleCommand} style={{ display: 'flex', borderTop: '1px solid #333', paddingTop: '10px' }}>
                <span style={{ color: '#4ec9b0', marginRight: '10px'}}>$</span>
                <input
                    autoFocus
                    value={inputValue}
                    onChange={(e) => setInputValue(e.target.value)}
                    placeholder="How will you proceed...?"
                    style={{
                        backgroundColor: 'transparent',
                        border: 'none',
                        color: '#fff',
                        outline: 'none', 
                        flex: 1,
                        fontSize: '1rem',
                    }}
                    />
            </form>
        </div>
    );

};