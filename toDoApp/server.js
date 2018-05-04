const http = require('http');
const fs = require('fs');

const requestHandler = function(req,res){
  if(req.url=='/'){
    res.write(fs.readFileSync('./home.html'));
    res.end();
  }
}


const server = http.createServer(requestHandler);
server.listen(5000);
console.log("server listening at 5000");
