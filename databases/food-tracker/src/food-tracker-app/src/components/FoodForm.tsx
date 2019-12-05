import React, { useState } from 'react';
import styled from 'styled-components';
import Paper from '../styled-components/Paper';
import TextField from '../styled-components/TextField';
import Button from '../styled-components/Button';
import Food from '../models/Food';

const StyledPaper = styled(Paper)`
    padding: 20px;
    margin: 20px;
`;

type Props = {
    onSubmit: (food: Food) => void
}

const FoodForm: React.FC<Props> = ({ onSubmit }) => {
  const [name, setName] = useState('');
  const [price, setPrice] = useState(0);
  const [foodType, setFoodType] = useState('');

  return (
    <StyledPaper>
      <form onSubmit={(e) => {
        e.preventDefault();
        onSubmit({
          name,
          price,
          foodTypes: foodType
            .split(',')
            .map((f) => ({
              name: f,
            })),
        });
      }}
      >
        <TextField value={name} onChange={(e) => setName(e.target.value)} />
        <TextField
          value={price}
          onChange={(e) => setPrice(+e.target.value)}
          type="number"
          step="0.01"
        />
        <TextField
          value={foodType}
          onChange={(e) => setFoodType(e.target.value)}
        />
        <Button type="submit">Submit</Button>
      </form>
    </StyledPaper>
  );
};

export default FoodForm;
