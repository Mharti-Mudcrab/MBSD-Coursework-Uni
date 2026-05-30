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

const describeTransition = (story: StoryData, transitionId: string): string => {
    const optionMatch = transitionId.match(/^(.+)-option-(\d+)-(\d+)$/);
    if (optionMatch) {
        const [, nodeId, optionIndexStr, transitionIndexStr] = optionMatch;
        const node = story.nodes[nodeId];
        const nodeLabel = node?.data?.label ?? nodeId;
        const option = (node?.data as any)?.choices?.[parseInt(optionIndexStr)];
        const optionText = option?.displayText ?? `option ${optionIndexStr}`;
        const targetId = option?.transitions?.[parseInt(transitionIndexStr)]?.targetNodeId;
        const targetLabel = targetId ? (story.nodes[targetId]?.data?.label ?? targetId) : 'unknown';
        return `option "${optionText}" in "${nodeLabel}" → "${targetLabel}"`;
    }

    const lastDash = transitionId.lastIndexOf('-');
    if (lastDash >= 0) {
        const nodeId = transitionId.slice(0, lastDash);
        const index = parseInt(transitionId.slice(lastDash + 1));
        const node = story.nodes[nodeId];
        const nodeLabel = node?.data?.label ?? nodeId;
        const targetId = node?.data?.transitions?.[index]?.targetNodeId;
        const targetLabel = targetId ? (story.nodes[targetId]?.data?.label ?? targetId) : 'unknown';
        return `"${nodeLabel}" → "${targetLabel}"`;
    }

    return `'${transitionId}'`;
};

const getExecutionSignature = (story: StoryData): string => {
    const normalizedNodes = Object.entries(story.nodes)
        .sort(([a], [b]) => a.localeCompare(b));
    return JSON.stringify({ name: story.name, startNodeId: story.startNodeId, nodes: normalizedNodes });
};

export const VirtualConsole: React.FC<{ story: StoryData }> = ({ story }) => {

    const [displayLines, setDisplayLines] = useState<string[]>([]);
    const [inputValue, setInputValue] = useState('');
    const scrollRef = useRef<HTMLDivElement>(null);
    const [executionId, setExecutionId] = useState(0);
    const [resumeNotice, setResumeNotice] = useState<string | null>(null);

    const runnerRef = useRef<StoryRunner | null>(null);
    const choiceHistoryRef = useRef<string[]>([]);
    const prevLogLengthRef = useRef(0);
    const prevTakenIdsRef = useRef<string[]>([]);

    const executionSignature = useMemo(() => getExecutionSignature(story), [story]);
    const executionStory = useMemo(() => story, [executionSignature]);

    // Rebuild only when the story's execution-relevant data changes, or on explicit restart.
    // Choices do not trigger this path — they advance the live runner directly.
    useEffect(() => {
        // Check if any transition taken in the previous session is now structurally invalid.
        const invalidIds = collectInvalidTransitionIds(executionStory);
        const hitId = prevTakenIdsRef.current.find(id => invalidIds.has(id));
        if (hitId) {
            const label = describeTransition(executionStory, hitId);
            setResumeNotice(`Condition on transition ${label} became invalid. Story restarted.`);
            choiceHistoryRef.current = [];
            prevTakenIdsRef.current = [];
        }

        let runner: StoryRunner;
        try {
            runner = new StoryRunner(executionStory);
        } catch (e: any) {
            runnerRef.current = null;
            prevLogLengthRef.current = 0;
            setDisplayLines([`Error: ${e?.message || 'Failed to initialize runner'}`]);
            return;
        }

        // Replay the choice history to restore the player's position after an edit.
        let failedChoice: string | null = null;
        for (const choice of choiceHistoryRef.current) {
            const match = runner.getAvailableChoices().find(c => c.toLowerCase() === choice.toLowerCase());
            if (!match) {
                failedChoice = choice;
                choiceHistoryRef.current = [];
                try { runner = new StoryRunner(executionStory); } catch { /* error already shown above */ }
                break;
            }
            runner.handleChoice(match);
        }

        if (failedChoice) {
            setResumeNotice(`Story changed and invalidated choice '${failedChoice}'. Restarted from start.`);
        }

        runnerRef.current = runner;
        prevTakenIdsRef.current = [...runner.takenTransitionIds];
        prevLogLengthRef.current = runner.logs.length;

        const lines = [...runner.logs];
        const choices = runner.getAvailableChoices();
        if (choices.length > 0) {
            lines.push('\nAvailable Options:\n' + choices.map(c => `- ${c}`).join('\n'));
        }
        setDisplayLines(lines);

    }, [executionStory, executionId]);

    useEffect(() => {
        scrollRef.current?.scrollIntoView({ behavior: 'smooth' });
    }, [displayLines]);

    const handleRestart = () => {
        choiceHistoryRef.current = [];
        prevTakenIdsRef.current = [];
        setDisplayLines([]);
        setResumeNotice(null);
        setExecutionId(prev => prev + 1);
    };

    const handleCommand = (e: React.FormEvent) => {
        e.preventDefault();
        const runner = runnerRef.current;
        if (!runner) return;

        const input = inputValue.trim();
        if (!input) return;

        const match = runner.getAvailableChoices().find(c => c.toLowerCase() === input.toLowerCase());

        if (match) {
            choiceHistoryRef.current = [...choiceHistoryRef.current, match];
            runner.handleChoice(match);
            prevTakenIdsRef.current = [...runner.takenTransitionIds];

            const newLines: string[] = [
                `> ${input}`,
                ...runner.logs.slice(prevLogLengthRef.current),
            ];
            prevLogLengthRef.current = runner.logs.length;

            const choices = runner.getAvailableChoices();
            if (choices.length > 0) {
                newLines.push('\nAvailable Options:\n' + choices.map(c => `- ${c}`).join('\n'));
            }
            setDisplayLines(prev => [...prev, ...newLines]);
        } else {
            setDisplayLines(prev => [...prev, `> ${input}`, `Error: Invalid input '${input}'.`]);
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
                {displayLines.map((line: string, i: number) => (
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