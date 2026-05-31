import { Handle, Position } from '@xyflow/react';

export const ComparisonBlock = ({ data }: any) => {
    const { operator, variable, value, isSelected } = data;

    return (
        <div
            style={{
                padding: '8px 12px',
                background: isSelected ? '#5a4a2a' : '#3a3a2a',
                border: `2px solid ${isSelected ? '#d4a574' : '#888'}`,
                borderRadius: 4,
                fontSize: 11,
                color: '#ddd',
                minWidth: 100,
            }}
        >
            <div style={{ fontWeight: 'bold', marginBottom: 2 }}>
                {operator}
            </div>
            <div style={{ fontSize: 9, color: '#aaa' }}>
                {variable} {operator} {value}
            </div>
            <Handle id="output" type="source" position={Position.Right} style={{ background: '#d4a574' }} />
        </div>
    );
};
