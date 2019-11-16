import React, { useEffect, useState } from 'react';
import Food from '../models/Food';
import List from '../styled-components/List';
import ListItem from '../styled-components/ListItem';


const Foods: React.FC = () => {
  const [foods, setFoods] = useState<Food[]>([]);
  useEffect(() => {
    const fetchFoods = async () => {
      const response = await fetch('http://localhost:8080/foods');
      const data = await response.json();
      setFoods(data);
    };
    fetchFoods();
  });

  return (
    <>
      <h1>Foods</h1>
      <List>
        {foods.map((food) => (
          <ListItem key={food.id}>
            {food.name}
:
            {' '}
            {food.price}
          </ListItem>
        ))}
      </List>
    </>
  );
};

export default Foods;
