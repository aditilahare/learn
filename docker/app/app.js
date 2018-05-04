const app = require('express')();
const PORT=process.env.PORT||8000;
app.get("/",(req,res)=>res.send("hello"));
app.listen(PORT,()=>console.log("listening at "+PORT));
