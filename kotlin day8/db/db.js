const mongoose = require('mongoose');
const mongo_uri = process.env.mongo_uri || 'mongodb://127.0.0.1:27017/inventory';

mongoose
    .connect(mongo_uri, { useNewUrlParser: true, useUnifiedTopology: true })
    .then(() => console.log('Connected to MongoDB'))
    .catch((err) => console.error('Error connecting to MongoDB:', err.message));

// Item schema
const itemSchema = new mongoose.Schema({
    name: {
        type: String,
        required: true,
    },
    quantity: {
        type: Number,
        required: true,
    },
    price: {
        type: Number,
        required: true,
    },
});

const Item = mongoose.model('Item', itemSchema);

module.exports = Item;