const express = require('express');
const cookieParser =require('cookie-parser');
const submitDataHandler = require('./handler.js').submitDataHandler;

const getLogin = function (req,res) {
  res.redirect('/index.html');
}

let app = express();
app.use(express.static('public'))
app.use(express.urlencoded({extended:false}));
app.use(cookieParser());
app.get('/login',getLogin);
app.post('/login',submitDataHandler);

module.exports=app;
