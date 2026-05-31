import type { Transition } from '../../types';
import { Handle, Position } from '@xyflow/react';
import { isConditionStructurallyValid } from '../../model/conditionUtils';

interface TransitionBlockProps {
    data: {
        transitionId: string;
        transition: Transition;
        parentNodeId: string | null;
        isSelected: boolean;
        onSelect: () => void;
    };
}

export const TransitionBlock: React.FC<TransitionBlockProps> = ({ data }) => {
    if (!data?.transition) {
        return <div style={{ color: 'red' }}>Error: No transition data</div>;
    }

    return (
        <div
            onClick={data?.onSelect}
            style={{
                padding: '8px 12px',
                background: data?.isSelected ? '#444' : '#222',
                border: `2px solid ${data.transition.condition && !isConditionStructurallyValid(data.transition.condition) ? '#c06a6a' : data?.isSelected ? '#4ec9b0' : '#555'}`,
                borderRadius: 4,
                cursor: 'pointer',
                fontSize: 12,
                color: '#ddd',
            }}
        >
            <Handle id="input" type="target" position={Position.Left} style={{ top: '25%' }} />
            <div>→ {data.transition.targetNodeId}</div>
            {data.transition.priority !== undefined && (
                <div style={{ fontSize: 10, color: '#888' }}>
                    Priority: {data.transition.priority}
                </div>
            )}
            {data.transition.condition && (
                <div style={{ fontSize: 9, color: '#aaa', marginTop: 4 }}>
                    ⊕ Condition
                </div>
            )}
            <Handle id="condition" type="target" position={Position.Left} style={{ top: '75%', background: '#d4a574' }} />
            <Handle id="output" type="source" position={Position.Right} />
        </div>
    );
};
