import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import Customer from '../models/Customer';
import Paper from '../styled-components/Paper';

const CustomerDetail: React.FC = () => {
  const [customer, setCustomer] = useState<Customer | null>(null);
  const { id } = useParams();

  useEffect(() => {
    const fetchCustomer = async () => {
      const response = await fetch(`http://localhost:8080/customers/${id}`);
      const data = await response.json();
      setCustomer(data);
    };
    fetchCustomer();
  }, [id]);

  return (
    <Paper>
      <div>
              Hey
      </div>
    </Paper>
  );
};

export default CustomerDetail;
