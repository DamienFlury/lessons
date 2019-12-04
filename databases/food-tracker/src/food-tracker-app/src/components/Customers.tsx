import React, { useState, useEffect } from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import Customer from '../models/Customer';
import List from '../styled-components/List';
import ListItem from '../styled-components/ListItem';

const Wrapper = styled.div`
  margin: 20px;
`;

const Customers: React.FC = () => {
  const [customers, setCustomers] = useState<Customer[]>([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchCustomers = async () => {
      try {
        setLoading(true);
        const response = await fetch('http://localhost:8080/customers');
        const data = await response.json();
        setCustomers(data);
      } catch (err) {
        setError(err);
      }
      setLoading(false);
    };
    fetchCustomers();
  }, []);

  return (
    <Wrapper>
      <h1>Customers</h1>
      {loading ? <p>loading</p> : error ? <p>Error</p> : (
        <List>
          {customers.map((customer) => (
            <ListItem key={customer.id}>
              <Link to={`/customers/${customer.id}`}>
                {customer.firstName}
                {' '}
                {customer.lastName}
              </Link>
            </ListItem>
          ))}
        </List>
      )}
    </Wrapper>
  );
};

export default Customers;
