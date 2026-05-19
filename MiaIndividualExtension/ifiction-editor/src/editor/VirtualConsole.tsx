import React, { useState, useEffect, useRef, useMemo } from 'react';
import { StoryRunner } from '../StoryRunner';
import type { StoryData } from '../types';

const isConditionStructurallyValid = (condition: any): boolean => {
    if (!condition) return true;
    if (typeof condition !== 'object' || !condition.type) return false;

    if (condition.type === 'comparison') {
        const validOperators = new Set(['==', '!=', '<', '>', '<=', '>=']);
        return (
            typeof condition.variable === 'string' &&
            condition.variable.trim() !== '' &&
            typeof condition.value === 'number' &&
            Number.isFinite(condition.value) &&
            validOperators.has(condition.operator)
        );
    }

    if (condition.type === 'and' || condition.type === 'or') {
        return !!condition.left && !!condition.right &&
            isConditionStructurallyValid(condition.left) &&
            isConditionStructurallyValid(condition.right);
    }

    if (condition.type === 'parentheses') {
        return !!condition.condition && isConditionStructurallyValid(condition.condition);
    }

    return false;
};

const collectInvalidTransitionIds = (story: StoryData): Set<string> => {
    const invalid = new Set<string>();

    Object.values(story.nodes).forEach(node => {
        (node.data.transitions || []).forEach((transition, index) => {
            if (!isConditionStructurallyValid((transition as any).condition)) {
                invalid.add(`${node.id}-${index}`);
            }
        });

        if (node.type === 'choice' && Array.isArray((node.data as any).choices)) {
            (node.data as any).choices.forEach((choice: any, optionIndex: number) => {
                (choice.transitions || []).forEach((transition: any, transitionIndex: number) => {
                    if (!isConditionStructurallyValid(transition.condition)) {
                        invalid.add(`${node.id}-option-${optionIndex}-${transitionIndex}`);
                    }
                });
            });
        }
    });

    return invalid;
};

const collectTakenTransitionIds = (story: StoryData, choices: string[]): Set<string> => {
    const taken = new Set<string>();
    const runner = new StoryRunner(story);

    const pushCurrentTransitionCandidates = () => {
        const node = runner.getCurrentNode();
        if (!node) return;

        if (node.type !== 'choice') {
            // Non-choice transitions auto-fire in StoryRunner; record best candidate for current state.
            const transitions = node.data.transitions || [];
            const target = transitions
                .map((transition, index) => ({ transition, id: `${node.id}-${index}` }))
                .sort((a, b) => (b.transition.priority || 0) - (a.transition.priority || 0))[0];

            if (target) taken.add(target.id);
        }
    };

    // Capture initial automatic progression context.
    pushCurrentTransitionCandidates();

    for (let i = 0; i < choices.length; i++) {
        const choiceText = choices[i];
        const node = runner.getCurrentNode();
        if (!node || node.type !== 'choice') break;

        const optionIndex = (node.data.choices || []).findIndex(opt => opt.displayText.toLowerCase() === choiceText.toLowerCase());
        if (optionIndex < 0) break;

        const transitions = ((node.data.choices || [])[optionIndex] as any)?.transitions || [];
        const target = transitions
            .map((transition: any, transitionIndex: number) => ({ transition, id: `${node.id}-option-${optionIndex}-${transitionIndex}` }))
            .sort((a: any, b: any) => (b.transition.priority || 0) - (a.transition.priority || 0))[0];

        if (target) taken.add(target.id);

        runner.handleChoice(choiceText);
        pushCurrentTransitionCandidates();
    }

    return taken;
};

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
    const lastTakenTransitionsRef = useRef<Set<string>>(new Set());

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
        const invalidTransitionIds = collectInvalidTransitionIds(story);
        const previousTaken = lastTakenTransitionsRef.current;
        const hit = Array.from(previousTaken).find(id => invalidTransitionIds.has(id));

        if (hit) {
            setResumeNotice(`Condition became invalid on transition '${hit}'. Restarted from start.`);
            setHistory([]);
            setChoiceHistory([]);
            setExecutionId(prev => prev + 1);
        }
    }, [story]);

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

        lastTakenTransitionsRef.current = collectTakenTransitionIds(story, choiceHistory);
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