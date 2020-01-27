const fetch = require('node-fetch');
const express = require('express');
const app = express();
const port = 3100;

app.get('/wiki/:query', async (req, res) => {
  const wikiResponse = await fetch(`https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles=${req.params.query}`).then(data => data.json());

  res.send(Object.values(wikiResponse.query.pages)[0]);
});

app.listen(port, () => console.log(`Listening on port ${port}`));