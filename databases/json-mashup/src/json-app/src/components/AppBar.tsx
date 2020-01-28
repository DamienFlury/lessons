import React from 'react';
import styled from 'styled-components';

const StyledNav = styled.nav`
  background: #ff5588;
  color: white;
  padding: 1px;
  position: sticky;
  top: 0;
`;

const Title = styled.div`
  font-size: 1.4rem;
  margin: 20px;
`;

const AppBar: React.FC = () => (
  <StyledNav>
    <Title>Json Mashup</Title>
  </StyledNav>
);

export default AppBar;
