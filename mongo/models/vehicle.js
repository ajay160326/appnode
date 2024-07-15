const mongoose = require('mongoose');
const express = require('express');
const router = express.Router();

// Define Vehicle model
const vehicleSchema = new mongoose.Schema({
  user_id: { type: mongoose.Schema.Types.ObjectId, ref: 'User', required: true },
  vehicle_type: { type: String, required: true },
  model: { type: String, required: true },
  vehicle_name: { type: String, required: true },
  insurance_types: [
    {
      type: { type: String, required: true },
      details: { type: String, required: true }
    }
  ]
});

const Vehicle = mongoose.model('Vehicle', vehicleSchema);

// Controller functions
const createVehicle = async (req, res) => {
  const { user_id, vehicle_type, model, vehicle_name, insurance_types } = req.body;
  try {
    const newVehicle = new Vehicle({ user_id, vehicle_type, model, vehicle_name, insurance_types });
    await newVehicle.save();
    res.status(201).json({ message: 'Vehicle added successfully' });
  } catch (error) {
    res.status(500).json({ message: 'Error adding vehicle', error });
  }
};

const getVehiclesByUser = async (req, res) => {
  const { userId } = req.params;
  try {
    const vehicles = await Vehicle.find({ user_id: userId });
    res.status(200).json(vehicles);
  } catch (error) {
    res.status500().json({ message: 'Error fetching vehicles', error });
  }
};

// Routes
router.post('/', createVehicle);
router.get('/:userId', getVehiclesByUser);

module.exports = {
  Vehicle,
  vehicleRoutes: router
};