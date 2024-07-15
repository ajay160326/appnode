
const mongoose = require('mongoose');

mongoose
    .connect('mongodb://127.0.0.1:27017/authtest')
    .then(() => console.log("Connected"))
    .catch((err) => console.log("Error", err));

// Auth schema
const authSchema = new mongoose.Schema({
    email: {
        type: String,
        required: true,
        unique: true
    },
    pass: {
        type: String,
        required: true
    }
});

const Auth = mongoose.model('Auth', authSchema, 'creds'); // collection

// Claim schema
const claimSchema = new mongoose.Schema({
    userId: {
        type: mongoose.Schema.Types.ObjectId,
        required: true,
        ref: 'Auth'
    },
    description: {
        type: String,
        required: true
    },
    photoUrl: {
        type: String,
        required: true
    },
    status: {
        type: String,
        enum: ['Pending', 'In Progress', 'Approved', 'Rejected'],
        default: 'Pending'
    }
});

const Claim = mongoose.model('Claim', claimSchema);

module.exports = { Auth, Claim };

