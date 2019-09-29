import React from 'react';
import bubbleSort from './bubble-sort';
import SortVisualizer from './components/SortVisualizer';

const App: React.FC = () => {
  const arr = [5, 2, 7, 6, 3, 10, 100, 55, 45, 24, 43, 32, 99, 57, 87, 78, 15, 63, 69];
  const h = bubbleSort(arr);
  console.log(arr);
  console.log(h);
  return (
    <div>
      <SortVisualizer history={bubbleSort(arr)} />
    </div>
  );
}

export default App;
