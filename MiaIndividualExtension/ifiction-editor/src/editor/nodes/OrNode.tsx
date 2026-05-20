import { Handle, Position } from '@xyflow/react';

export const OrNode = ({ data }: any) => {
    const { isSelected } = data;

    return (
        <div
            style={{
                padding: '8px 12px',
                background: isSelected ? '#4a3a2a' : '#2a2a1a',
                border: `2px solid ${isSelected ? '#d4a574' : '#666'}`,
                borderRadius: 4,
                fontSize: 11,
                color: '#ddd',
                minWidth: 60,
                textAlign: 'center',
            }}
        >
            <Handle id="conditionA" type="target" position={Position.Left} style={{ top: '25%' }} />
            <div style={{ fontWeight: 'bold' }}>OR</div>
            <Handle id="conditionB" type="target" position={Position.Left} style={{ top: '75%' }} />
            <Handle id="output" type="source" position={Position.Right} />
        </div>
    );
};
