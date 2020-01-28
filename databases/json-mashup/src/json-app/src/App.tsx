import React from 'react';
import './App.css';
import { createGlobalStyle } from 'styled-components';
import NasaImage from './components/NasaImage';
import AppBar from './components/AppBar';
import CuriosityPhoto from './components/CuriosityPhoto';

const GlobalStyle = createGlobalStyle`
  @import url('https://fonts.googleapis.com/css?family=Roboto&display=swap');
  body {
    font-family: 'Roboto', sans-serif;
  }
`;

const App: React.FC = () => (
  <div>
    <AppBar />
    <GlobalStyle />
    <NasaImage />
    <CuriosityPhoto />
  </div>
);

export default App;
