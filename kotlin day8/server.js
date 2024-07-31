const express = require('express');
const app = express();
const port = process.env.PORT || 3000;
const bodyParser = require('body-parser');
const db = require('./db/db');

app.use(bodyParser.json());

app.get('/', (req, res) => res.send('Inventory Management System API'));

// Create Item
app.post('/items', async (req, res) => {
    const { name, quantity, price } = req.body;

    try {
        const newItem = await db.create({ name, quantity, price });
        res.status(201).json({ msg: 'Item created successfully', item: newItem });
    } catch (err) {
        res.status(500).json({ msg: 'Internal Server Error', error: err.message });
    }
});

// Read Items
app.get('/items', async (req, res) => {
    try {
        const items = await db.find();
        res.status(200).json(items);
    } catch (err) {
        res.status(500).json({ msg: 'Internal Server Error', error: err.message });
    }
});

// Update Item
app.put('/items/:id', async (req, res) => {
    const { id } = req.params;
    const { name, quantity, price } = req.body;

    try {
        const updatedItem = await db.findByIdAndUpdate(id, { name, quantity, price }, { new: true });
        if (updatedItem) {
            res.status(200).json({ msg: 'Item updated successfully', item: updatedItem });
        } else {
            res.status(404).json({ msg: 'Item not found' });
        }
    } catch (err) {
        res.status(500).json({ msg: 'Internal Server Error', error: err.message });
    }
});

// Delete Item
app.delete('/items/:id', async (req, res) => {
    const { id } = req.params;

    try {
        const deletedItem = await db.findByIdAndDelete(id);
        if (deletedItem) {
            res.status(200).json({ msg: 'Item deleted successfully' });
        } else {
            res.status(404).json({ msg: 'Item not found' });
        }
    } catch (err) {
        res.status(500).json({ msg: 'Internal Server Error', error: err.message });
    }
});

app.listen(port, () => console.log('App listening on port ${port}!'));