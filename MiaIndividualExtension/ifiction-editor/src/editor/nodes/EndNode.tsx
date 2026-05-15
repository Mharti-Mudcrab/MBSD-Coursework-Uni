import { Handle, Position } from '@xyflow/react';

export const EndNode = ({ data }: any) => {
    return (
        <div style={{ 
            visibility: 'visible',
            background: '#1e1e1e', 
            color: '#f44747', 
            padding: '10px 20px', 
            borderRadius: '20px', // Rounded to distinguish as terminal node
            border: '2px solid #f44747',
            minWidth: '100px',
            textAlign: 'center',
            fontWeight: 'bold'
        }}>
            {/* Only a target (input) for End nodes */}
            <Handle type="target" position={Position.Left} style={{ background: '#f44747' }} />
            <div>{data.label || 'END'}</div>
            <div>{ data.displayText || '' }</div>
        </div>
    );
};