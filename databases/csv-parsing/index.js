const readFile = require('./readFile');

const parseCsv = async () => {
  try {
    const content = await readFile('realtime.csv');
    const lines = content.toString().split('\n');
    const parsed = lines.map(line => line.split(';'));
    console.log(parsed);
  } catch (err) {
    console.log('Error!', err);
  }
};

parseCsv();
