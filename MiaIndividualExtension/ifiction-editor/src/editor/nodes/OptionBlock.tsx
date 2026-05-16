import type { ChoiceOption } from '../../types';
import { Handle, Position } from '@xyflow/react';

interface OptionBlockProps {
    data: {
        optionId: string;
        option: ChoiceOption;
        parentNodeId: string;
        optionIndex: number;
        isSelected: boolean;
        onSelect: () => void;
    };
}

export const OptionBlock: React.FC<OptionBlockProps> = ({ data }) => {
    if (!data?.option) {
        return <div style={{ color: 'red' }}>Error: No option data</div>;
    }

    return (
        <div
            onClick={data?.onSelect}
            style={{
                padding: '8px 12px',
                background: data?.isSelected ? '#5a4a2a' : '#3a3a2a',
                border: `2px solid ${data?.isSelected ? '#d4a574' : '#666'}`,
                borderRadius: 4,
                cursor: 'pointer',
                fontSize: 12,
                color: '#ddd',
                maxWidth: 180,
            }}
        >
            <Handle id="target" type="target" position={Position.Left} />
            <div style={{ 
                fontSize: 11, 
                color: '#aaa', 
                overflow: 'hidden', 
                textOverflow: 'ellipsis', 
                whiteSpace: 'nowrap' 
            }}>
                ◆ {data.option.displayText}
            </div>
            <div style={{ fontSize: 9, color: '#777', marginTop: 2 }}>
                {data.option.transitions?.length || 0} transitions
            </div>
            <Handle id="source" type="source" position={Position.Right} />
        </div>
    );
};
