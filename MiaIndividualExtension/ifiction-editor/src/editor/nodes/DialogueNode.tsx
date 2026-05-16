import { Handle, Position } from '@xyflow/react';

export const DialogueNode = ({ data }: any) => {
    return (
        <div
            style={{
                background: '#2a2a5a',
                color: '#ddd',
                padding: '12px 16px',
                border: '2px solid #6a6ac0',
                borderRadius: 6,
                minWidth: '120px',
                fontSize: 12,
            }}
        >
            <Handle id="target" type="target" position={Position.Left} />
            <div style={{ fontWeight: 'bold', marginBottom: 4 }}>
                {data?.label || 'Dialogue'}
            </div>
            <div style={{ fontSize: 11, color: '#aaa', maxWidth: 150, overflow: 'hidden', textOverflow: 'ellipsis', whiteSpace: 'nowrap' }}>
                {data?.displayText || '(no text)'}
            </div>
            <Handle id="source" type="source" position={Position.Right} />
        </div>
    );
};
