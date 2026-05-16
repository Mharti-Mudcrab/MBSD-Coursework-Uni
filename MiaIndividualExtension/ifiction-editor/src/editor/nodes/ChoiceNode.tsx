import { Handle, Position } from '@xyflow/react';

export const ChoiceNode = ({ data }: any) => {
    return (
        <div
            style={{
                background: '#4a3a2a',
                color: '#ddd',
                padding: '12px 16px',
                border: '2px dashed #d4a574',
                borderRadius: 6,
                minWidth: '140px',
                fontSize: 12,
            }}
        >
            <Handle id="target" type="target" position={Position.Left} />
            <div style={{ fontWeight: 'bold', marginBottom: 4 }}>
                {data?.label || 'Choice'}
            </div>
            <div style={{ fontSize: 11, color: '#aaa', maxWidth: 150, overflow: 'hidden', textOverflow: 'ellipsis', whiteSpace: 'nowrap' }}>
                {data?.displayText || '(no text)'}
            </div>
            <div style={{ fontSize: 10, color: '#999', marginTop: 4 }}>
                {data?.choices?.length || 0} options
            </div>
            <Handle id="source" type="source" position={Position.Right} />
        </div>
    );
};
