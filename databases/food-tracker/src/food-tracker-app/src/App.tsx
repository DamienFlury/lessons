import React from 'react';
import styled from 'styled-components';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import Foods from './components/Foods';
import AppBar from './styled-components/AppBar';
import NavLink from './styled-components/NavLink';
import Customers from './components/Customers';

const Title = styled.div`
  font-size: 2rem;
  margin: 0 20px;
`;

const App: React.FC = () => (
  <>
    <BrowserRouter>
      <AppBar>
        <Title>Food Tracker</Title>
        <NavLink to="/">Foods</NavLink>
        <NavLink to="/customers">Customers</NavLink>
      </AppBar>
      <Switch>
        <Route path="/customers">
          <Customers />
        </Route>
        <Route path="/">
          <Foods />
        </Route>
      </Switch>
    </BrowserRouter>
  </>
);

export default App;
