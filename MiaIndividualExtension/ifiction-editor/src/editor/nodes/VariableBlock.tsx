import { Handle, Position } from '@xyflow/react';

interface VariableBlockProps {
    data: {
        changeId: string;
        change: { variable: string; operator: string; value: number };
        parentNodeId: string;
        index: number;
        isSelected: boolean;
        onSelect: () => void;
    };
}

export const VariableBlock: React.FC<VariableBlockProps> = ({ data }) => {
    if (!data?.change) return <div style={{ color: 'red' }}>No change</div>;

    return (
        <div
            onClick={data?.onSelect}
            style={{
                padding: '8px 12px',
                background: data?.isSelected ? '#223322' : '#162016',
                border: `2px solid ${data?.isSelected ? '#6ac06a' : '#234423'}`,
                borderRadius: 6,
                cursor: 'pointer',
                fontSize: 12,
                color: '#ddd',
                minWidth: 140,
            }}
        >
            <div style={{ fontSize: 11, color: '#aaa' }}>{data.change.variable}</div>
            <div style={{ fontSize: 12, fontWeight: 'bold', marginTop: 2 }}>{data.change.operator} {data.change.value}</div>
            <Handle id="source" type="source" position={Position.Right} />
        </div>
    );
};
