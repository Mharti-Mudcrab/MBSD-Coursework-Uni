import { Handle, Position } from '@xyflow/react';

export const EndNode = ({ data }: any) => {
    return (
        <div style={{
            background: data?.isSelected ? '#4a1a1a' : '#3a1a1a',
            color: '#ddd',
            padding: '12px 16px',
            border: `2px solid ${data?.isSelected ? '#ff6767' : '#f44747'}`,
            borderRadius: 6,
            minWidth: '120px',
            fontSize: 12,
        }}>
            <Handle id="input" type="target" position={Position.Left} />
            <div style={{ fontWeight: 'bold', marginBottom: 4 }}>
                {data?.label || 'End'}
            </div>
            {data?.displayText && (
                <div style={{ fontSize: 11, color: '#aaa', maxWidth: 150, overflow: 'hidden', textOverflow: 'ellipsis', whiteSpace: 'nowrap' }}>
                    {data.displayText}
                </div>
            )}
        </div>
    );
};