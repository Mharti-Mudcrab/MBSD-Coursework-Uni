import { Handle, Position } from '@xyflow/react';

export const StartNode = ({ data }: any) => {
    return (
        <div style={{
            background: data?.isSelected ? '#1a4a4a' : '#1a3a3a',
            color: '#ddd',
            padding: '12px 16px',
            border: `2px solid ${data?.isSelected ? '#70e0d0' : '#4ec9b0'}`,
            borderRadius: 6,
            minWidth: '120px',
            fontSize: 12,
        }}>
            <Handle id="target" type="target" position={Position.Left} />
            <div style={{ fontWeight: 'bold', marginBottom: 4 }}>
                {data?.label || 'Start'}
            </div>
            {data?.displayText && (
                <div style={{ fontSize: 11, color: '#aaa', maxWidth: 150, overflow: 'hidden', textOverflow: 'ellipsis', whiteSpace: 'nowrap' }}>
                    {data.displayText}
                </div>
            )}
            <Handle id="source" type="source" position={Position.Right} />
        </div>
    );
};