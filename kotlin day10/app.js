const express = require('express');
const { MongoClient, ObjectId } = require('mongodb');
require('dotenv').config(); // Load environment variables

const app = express();
app.use(express.json());

// MongoDB connection setup
const url = process.env.MONGODB_URI || 'mongodb://localhost:27017/';
const dbName = 'mydatabase';
const client = new MongoClient(url, { useUnifiedTopology: true });

let db;
let collection;

async function connectDB() {
    try {
        await client.connect();
        db = client.db(dbName);
        collection = db.collection('mycollection');
        console.log('Connected to MongoDB');
    } catch (error) {
        console.error('Error connecting to MongoDB:', error);
        process.exit(1);
    }
}

connectDB();

// Create
app.post('/create', async (req, res) => {
    try {
        const result = await collection.insertOne(req.body);
        res.status(201).json({ insertedId: result.insertedId });
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

// Read
app.get('/read', async (req, res) => {
    try {
        const documents = await collection.find().toArray();
        res.status(200).json(documents);
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

// Update
app.put('/update/:id', async (req, res) => {
    try {
        const result = await collection.updateOne(
            { _id: ObjectId(req.params.id) },
            { $set: req.body }
        );
        res.status(200).json({ matchedCount: result.matchedCount, modifiedCount: result.modifiedCount });
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

// Delete
app.delete('/delete/:id', async (req, res) => {
    try {
        const result = await collection.deleteOne({ _id: ObjectId(req.params.id) });
        res.status(200).json({ deletedCount: result.deletedCount });
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

// Start the server
const port = 3000;
app.listen(port, () => {
    console.log(`Server is running on http://localhost:${port}`);
});
