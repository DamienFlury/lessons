const bubbleSort = (array: number[]) => {
    array = [...array];
    const history = [];
    for(var i = array.length - 1; i >= 0; i--) {
        for(var j = 0; j < i; j++) {
            if(array[j] > array[j + 1]) {
                [array[j], array[j + 1]] = [array[j + 1], array[j]];
                history.push([...array]);
            }
        }
    }

    return history;
};

export default bubbleSort;