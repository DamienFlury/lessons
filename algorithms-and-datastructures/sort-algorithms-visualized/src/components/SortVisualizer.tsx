import React, { useState, useEffect } from 'react';
import bubbleSort from '../bubble-sort';
import List from '../styled-components/List';
import ListItem from '../styled-components/ListItem';

interface Props {
    history: number[][]
}

const SortVisualizer: React.FC<Props> = ({ history }) => {
    const largestItem = Math.max(...history[0]);
    const [index, setIndex] = useState(0);

    const currentArrayState = history[index];

    useEffect(() => {
        if(index >= history.length - 1) {
            return;
        }
        console.log(index);
        const timeout = setTimeout(() => {
            setIndex(prev => prev + 1);
        }, 1000);

        return () => {
            clearTimeout(timeout);
        }
    });

    return (
        <div>
            <List>
                {currentArrayState.map(item => <ListItem key={item} width={item / largestItem * 100}>{item}</ListItem>)}
            </List>
        </div>
    )
};

export default SortVisualizer;