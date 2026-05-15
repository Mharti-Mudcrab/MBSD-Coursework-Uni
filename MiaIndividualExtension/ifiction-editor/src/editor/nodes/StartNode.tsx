import { Handle, Position } from '@xyflow/react';

export const StartNode = ({ data }: any) => {
    return (
        <div style={{ 
            visibility: 'visible',
            background: '#fff', 
            color: '#000', 
            padding: '40px', // Big padding
            border: '2px solid green', 
            display: 'block', // Ensure it's not collapsed
            minWidth: '100px'
        }}>
            <strong>{data?.label || 'DEBUG START'}</strong>
            <Handle type="source" position={Position.Right} />
        </div>
    );
};