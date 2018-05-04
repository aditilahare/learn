const http = require('http');
const app = require('./app.js');
const PORT = 5000;

let server = http.createServer(app);
server.listen(PORT);
console.log(`server listening at ${PORT}`);
