import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import styled from 'styled-components';
import Customer from '../models/Customer';
import Paper from '../styled-components/Paper';
import List from '../styled-components/List';
import ListItem from '../styled-components/ListItem';
import FoodForm from './FoodForm';
import Food from '../models/Food';

const StyledPaper = styled(Paper)`
    padding: 20px;
    margin: 20px;
`;

const CustomerDetail: React.FC = () => {
  const [customer, setCustomer] = useState<Customer | null>(null);
  const { id } = useParams();

  const handleSubmit = async ({ name, price, foodTypes }: Food) => {
    const food: Food = {
      customer: customer || undefined,
      name,
      price,
      foodTypes,
    };
    console.log(food);
    const response = await fetch('http://localhost:8080/foods', {
      method: 'post',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(food),
    });
    const data = await response.json();
    console.log(data);
  };

  useEffect(() => {
    const fetchCustomer = async () => {
      const response = await fetch(`http://localhost:8080/customers/${id}`);
      const data = await response.json();
      setCustomer(data);
    };
    fetchCustomer();
  }, [id]);

  if (!customer) {
    return (
      <div>
        Loading
      </div>
    );
  }

  return (
    <StyledPaper>
      <h3>
        {customer.firstName}
        {' '}
        {customer.lastName}
      </h3>
      <FoodForm onSubmit={handleSubmit} />
    </StyledPaper>
  );
};

export default CustomerDetail;
