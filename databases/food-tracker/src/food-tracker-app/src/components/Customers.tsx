import React, { useState, useEffect } from 'react';
import Customer from '../models/Customer';
import List from '../styled-components/List';
import ListItem from '../styled-components/ListItem';

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
        console.log(data);
        setCustomers(data);
      } catch (err) {
        setError(err);
      }
      setLoading(false);
    };
    fetchCustomers();
  }, []);

  return (
    <>
      <h1>Customers</h1>
      {loading ? <p>loading</p> : error ? <p>Error</p> : (
        <List>
          {customers.map((customer) => (
            <ListItem key={customer.id}>
              {customer.firstName}
              {' '}
              {customer.lastName}
            </ListItem>
          ))}
        </List>
      )}
    </>
  );
};

export default Customers;
