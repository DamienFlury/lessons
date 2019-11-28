import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import Food from '../models/Food';
import List from '../styled-components/List';
import ListItem from '../styled-components/ListItem';
import Paper from '../styled-components/Paper';

const StyledPaper = styled(Paper)`
    /* margin: 20px; */
`;

const Wrapper = styled.div`
    margin: 20px;
`;


const Foods: React.FC = () => {
  const [foods, setFoods] = useState<Food[]>([]);
  useEffect(() => {
    const fetchFoods = async () => {
      try {
        const response = await fetch('http://localhost:8080/foods');
        const data = await response.json();
        console.log(data);
        setFoods(data);
      } catch {
        console.log('error fetching foods');
      }
    };
    fetchFoods();
  }, []);

  return (
    <Wrapper>
      <h1>Foods</h1>
      <StyledPaper>
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
      </StyledPaper>
    </Wrapper>

  );
};

export default Foods;
