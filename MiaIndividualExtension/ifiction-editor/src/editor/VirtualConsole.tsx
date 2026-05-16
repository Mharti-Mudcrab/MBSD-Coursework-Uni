import React, { useState, useEffect, useRef, useMemo } from 'react';
import { StoryRunner } from '../StoryRunner';
import type { StoryData } from '../types';

const getExecutionSignature = (story: StoryData): string => {
    const normalizedNodes = Object.entries(story.nodes)
        .sort(([a], [b]) => a.localeCompare(b))
        .map(([id, node]) => ({
            id,
            type: node.type,
            data: {
                ...node.data,
                transitions: (node.data.transitions || []).map(({ position, ...transition }) => transition),
                choices: (node.data.choices || []).map(({ position, transitions, ...choice }) => ({
                    ...choice,
                    transitions: (transitions || []).map(({ position: _optionTransitionPosition, ...transition }) => transition),
                })),
            },
        }));

    return JSON.stringify({
        name: story.name,
        startNodeId: story.startNodeId,
        nodes: normalizedNodes,
    });
};

export const VirtualConsole: React.FC<{ story: StoryData }> = ({ story }) => {
    
    const [history, setHistory] = useState<string[]>([]);
    const [inputValue, setInputValue] = useState('');
    const scrollRef = useRef<HTMLDivElement>(null);
    const [executionId, setExecutionId] = useState(0);
    const [choiceHistory, setChoiceHistory] = useState<string[]>([]);
    const [resumeNotice, setResumeNotice] = useState<string | null>(null);

    const executionSignature = useMemo(() => getExecutionSignature(story), [story]);
    const executionStory = useMemo(() => story, [executionSignature]);

    const runnerBuild = useMemo(() => {
        try {
            const builtRunner = new StoryRunner(executionStory);

            for (let i = 0; i < choiceHistory.length; i++) {
                const chosenText = choiceHistory[i];
                const availableChoices = builtRunner.getAvailableChoices();
                const matchedChoice = availableChoices.find(
                    c => c.toLowerCase() === chosenText.toLowerCase()
                );

                if (!matchedChoice) {
                    return {
                        runner: builtRunner,
                        error: null as string | null,
                        replayFailed: true,
                        failedChoice: chosenText,
                    };
                }

                builtRunner.handleChoice(matchedChoice);
            }

            return {
                runner: builtRunner,
                error: null as string | null,
                replayFailed: false,
                failedChoice: null as string | null,
            };
        } catch (e: any) {
            return {
                runner: null,
                error: e?.message || 'Failed to initialize runner',
                replayFailed: false,
                failedChoice: null as string | null,
            };
        }
    }, [executionStory, executionId, choiceHistory]);

    const runner = runnerBuild.runner;

    useEffect(() => {
        if (!runnerBuild.replayFailed || choiceHistory.length === 0) {
            return;
        }

        setResumeNotice(
            `Story changed and invalidated choice '${runnerBuild.failedChoice}'. Restarted from start.`
        );
        setChoiceHistory([]);
    }, [runnerBuild.replayFailed, runnerBuild.failedChoice, choiceHistory.length]);


    const handleRestart = () => {
        setHistory([]);
        setChoiceHistory([]);
        setResumeNotice(null);
        setExecutionId(prev => prev +1);
    };


    useEffect(() => {
        if (!runner) {
            setHistory(runnerBuild.error ? [`Error: ${runnerBuild.error}`] : []);
            return;
        }
        // Init logs from start node
        setHistory([...runner.logs]);
        printChoices(runner);
    }, [runner, runnerBuild.error]);

    useEffect(() => {
        scrollRef.current?.scrollIntoView({ behavior: 'smooth' });
    }, [history]);


    const printChoices = (runner: StoryRunner) => {
        const choices = runner.getAvailableChoices();
            if (choices.length > 0) {
                const choiceText = "\nAvailable Options:\n" + choices.map((c) => `- ${c}`).join('\n');
                setHistory(prev => [...prev, choiceText]);
            }
    };

    const handleCommand = (e: React.FormEvent) => {
        e.preventDefault();
        if (!runner) {
            return;
        }
        const input = inputValue.trim();
        if (!input) return;

        const availableChoices = runner.getAvailableChoices();

        setHistory(prev => [...prev, `> ${input}`]);

        const match = availableChoices.find(
            choice => choice.toLowerCase() === input.toLowerCase()
        );

        if (match) {
            setChoiceHistory(prev => [...prev, match]);
        } else {
            setHistory(prev => [...prev, `Error: Invalid input '${input}'.`])
        }

        setInputValue('');
    };

    return (
        <div style= {{
            backgroundColor: '#0f0f0f',
            color: '#d1d1d1',
            fontFamily: 'system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", Arial',
            padding: '16px',
            height: '100%',
            width: '100%',
            boxSizing: "border-box",
            display: 'flex',
            flexDirection: 'column'
        }}>
            <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '4px 0 16px 0', color: '#ddd', borderBottom: "1px solid #222" }}>
                <h2 style={{ margin: 0, fontSize: '1rem', color: '#ddd' }}>Output</h2>
                <button onClick={handleRestart} style={{ background: '#111', color: '#ddd', border: '1px solid #333', padding: '6px 10px', cursor: 'pointer', borderRadius: 6 }}>Restart</button>
            </div>
            {resumeNotice && (
                <div style={{ marginTop: 10, marginBottom: 4, padding: '8px 10px', border: '1px solid #4f3a00', background: '#2a1e00', color: '#f8d37a', borderRadius: 6, fontSize: 12 }}>
                    {resumeNotice}
                </div>
            )}
            {/* Output */}
            <div style={{ flex: 1, overflowY: 'auto', overflowX: 'hidden', marginTop: '10px', marginBottom: '10px', whiteSpace: "pre-wrap", wordBreak: "break-word" }}>
                {history.map((line, i) => (
                    <div key={i} style = {{
                        marginBottom: '8px',
                        lineHeight: '1.5',
                        color: line.startsWith('>') ? '#4ec9b0' : line.startsWith("Error") ? '#f44747' : '#d1d1d1',
                        fontFamily: 'inherit'
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
                        fontFamily: 'inherit'
                    }}
                    />
            </form>
        </div>
    );

};