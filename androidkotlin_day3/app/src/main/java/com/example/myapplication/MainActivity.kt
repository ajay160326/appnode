package com.example.myapplication

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import android.widget.ProgressBar
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var engineHealthBar: ProgressBar
    private lateinit var oilLevelBar: ProgressBar
    private lateinit var tirePressureBar: ProgressBar
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        engineHealthBar = findViewById(R.id.engineHealthBar)
        oilLevelBar = findViewById(R.id.oilLevelBar)
        tirePressureBar = findViewById(R.id.tirePressureBar)

        // Start the simulation
        simulateDataUpdates()
    }

    private fun simulateDataUpdates() {
        handler.postDelayed(object : Runnable {
            override fun run() {
                // Generate random values for the metrics
                val engineHealth = Random.nextInt(0, 100)
                val oilLevel = Random.nextInt(0, 100)
                val tirePressure = Random.nextInt(0, 100)

                // Update the UI with the new values
                updateVehicleHealthMetrics(engineHealth, oilLevel, tirePressure)

                // Schedule the next update
                handler.postDelayed(this, 2000) // 2000 milliseconds = 2 seconds
            }
        }, 2000)
    }

    private fun updateVehicleHealthMetrics(engineHealth: Int, oilLevel: Int, tirePressure: Int) {
        engineHealthBar.progress = engineHealth
        oilLevelBar.progress = oilLevel
        tirePressureBar.progress = tirePressure
    }

    override fun onDestroy() {
        super.onDestroy()
        // Remove callbacks to avoid memory leaks
        handler.removeCallbacksAndMessages(null)
    }
}
