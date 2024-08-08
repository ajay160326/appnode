const express = require('express');
const colors = require('colors');
const morgan = require('morgan');
const dotenv = require('dotenv');
const connectDB = require('./config/db');

const app = express();


//app.use((req,res,next) => {
    //console.log("middleware ran");
    //req.title = "pradhan";
  //  next();
//});

app.use(morgan('dev'));

dotenv.config({
    path: './config/config.env'
});

connectDB();

app.use(express.json({}));
app.use(express.json({
  extende: true
}))

//app.get('/todo',(req,res)=>{
  //  res.status(200).json({
    //    "name":"ajay"
    //    "title":req.title
    //});
//})

https://localhost:3000/api/todo/auth/register


app.use('/api/todo/auth',require('./routes/user'));

const PORT = process.env.PORT || 3000;

app.listen(PORT,
    console.log(`Server running on port: $(PORT)`.red.underline.bold)

    );
