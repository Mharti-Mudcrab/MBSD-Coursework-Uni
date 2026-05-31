import { Handle, Position } from '@xyflow/react';

export const AndNode = ({ data }: any) => {
    const { isSelected } = data;

    return (
        <div
            style={{
                padding: '8px 12px',
                background: isSelected ? '#2a4a3a' : '#1a3a2a',
                border: `2px solid ${isSelected ? '#6ac06a' : '#666'}`,
                borderRadius: 4,
                fontSize: 11,
                color: '#ddd',
                minWidth: 60,
                textAlign: 'center',
            }}
        >
            <Handle id="conditionA" type="target" position={Position.Left} style={{ top: '25%', background: '#d4a574' }} />
            <div style={{ fontWeight: 'bold' }}>AND</div>
            <Handle id="conditionB" type="target" position={Position.Left} style={{ top: '75%', background: '#d4a574' }} />
            <Handle id="output" type="source" position={Position.Right} style={{ background: '#d4a574' }} />
        </div>
    );
};
