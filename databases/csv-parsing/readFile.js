const fs = require('fs');

const readFile = fileName =>
  new Promise(
    (resolve, reject) => {
      fs.readFile(fileName, (err, content) => {
        if (content) {
          resolve(content);
        }
        if(err) {
          reject(err);
        }
      });
    },
  );

module.exports = readFile;