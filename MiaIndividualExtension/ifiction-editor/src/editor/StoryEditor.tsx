import React, { useState, useCallback } from 'react';
import { ReactFlow, type Background, type Controls } from  '@xyflow/react'
import type { StoryData } from '../types'
import '@xyflow/react/dist/style.css'

interface Props {
    story: StoryData,
    onStoryChange: (story: StoryData) => void;
}

export const StoryEditor: React.FC<Props> = ({story, onStoryChange}) => {

    const nodes = Object.values(story.nodes).map(node => ({

        id: node.id,
        type: node.type,
        position: node.position,
        data: { label: node.data.label }

    }));

    const edges: any[] = []

    return (
        <div style= {{width: '100%', height: '100%'}}>
            <ReactFlow
                nodes = {nodes}
                edges = {edges}
                colorMode='dark'
            >
                <Background color="#333" gap={20} />
                <Controls />
            </ReactFlow>
        </div>
    )

}