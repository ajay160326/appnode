const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const cors = require('cors');
const itemRoutes = require('./routes/items');

const app = express();
const port = process.env.PORT || 3000;

mongoose.connect('mongodb://localhost:27017/inventory', {
    useNewUrlParser: true,
    useUnifiedTopology: true
});

app.use(cors());
app.use(bodyParser.json());
app.use('/api/items', itemRoutes);

app.listen(port, () => {
    console.log('Server running on port ${port}');
});