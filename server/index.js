const express = require('express');
const app = express();
const db = require('./db/db');
const bodyParser = require('body-parser');
const port = process.env.PORT || 3000;

app.use(bodyParser.json());

app.get('/', (req, res) => res.send('Hello World!'));

// Login
app.post("/login", async (req, res) => {
    const { email, pass } = req.body;
    const result = await db.Auth.find({ email, pass });
    if (result.length === 1) {
        res.json({ msg: "Login successful", status: 200 });
    } else {
        res.json({ msg: "Login Failed", status: 400 });
    }
});

// Register
app.post("/register", async (req, res) => {
    const body = req.body;
    try {
        const result = await db.Auth.create(body);
        res.status(201).json({ msg: "User registered successfully" });
    } catch (error) {
        res.status(400).json({ msg: "User registration failed", error });
    }
});

// File a Claim
app.post("/file-claim", async (req, res) => {
    const claimData = req.body;
    try {
        const result = await db.Claim.create(claimData);
        res.status(201).json({ msg: "Claim filed successfully", claimId: result._id });
    } catch (error) {
        res.status(400).json({ msg: "Claim filing failed", error });
    }
});

// Get Claim Status
app.get("/claim-status/:claimId", async (req, res) => {
    const { claimId } = req.params;
    try {
        const claim = await db.Claim.findById(claimId);
        if (claim) {
            res.json({ status: claim.status });
        } else {
            res.status(404).json({ msg: "Claim not found" });
        }
    } catch (error) {
        res.status(400).json({ msg: "Error fetching claim status", error });
    }
});

app.listen(port, () => console.log(`App listening on port ${port}!`));

