const pg = require('pg');

let connectingString = 'postgres://localhost:5432/';

let client = new pg.Client(connectingString);
client.connect();


const submitDataHandler = function(req,res){
  let username=req.body.name;
  let password=req.body.password;
  let userDetails={userName:username,password:password};
  client.query(`insert into interns_information values ($1,$2);`,[username, password],(err,result)=>{
    if (err) {
      return;
    }
    res.json(userDetails);
  });
}

exports.submitDataHandler = submitDataHandler;
