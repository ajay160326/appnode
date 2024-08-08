const express = require('express');
const router = express.Router();
const User = require('../models/User');
const bcryptjs = require('bcryptjs');




router.post('/register',(req, res, next)=>{
    //console.log(req,body);
    //const body = req.body;
    // Now you can use `body` to access the properties sent in the request body
    //res.json(body);
    const (username, email, password) = req.body;
});

module.exports = router;
