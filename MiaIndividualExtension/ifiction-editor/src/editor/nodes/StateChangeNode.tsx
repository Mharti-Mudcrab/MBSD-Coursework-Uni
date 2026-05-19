import { Handle, Position } from '@xyflow/react';

export const StateChangeNode = ({ data }: any) => {
    return (
        <div
            style={{
                background: '#3a4a2a',
                color: '#ddd',
                padding: '12px 16px',
                border: '2px solid #6ac06a',
                borderRadius: 6,
                minWidth: '130px',
                fontSize: 12,
            }}
        >
            <Handle id="target" type="target" position={Position.Left} style={{ top: '25%' }} />
            <Handle id="var" type="target" position={Position.Left} style={{ top: '75%', background: '#6ac06a' }} />
            <div style={{ fontWeight: 'bold', marginBottom: 4 }}>
                {data?.label || 'State Change'}
            </div>
            <div style={{ fontSize: 11, color: '#aaa', maxWidth: 150, overflow: 'hidden', textOverflow: 'ellipsis', whiteSpace: 'nowrap' }}>
                {data?.displayText || '(no text)'}
            </div>
            <Handle id="source" type="source" position={Position.Right} />
        </div>
    );
};
