package com.example.demo

import com.google.android.material.snackbar.Snackbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.demo.databinding.ActivityMainBinding

import android.os.Bundle
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val switchLights = findViewById<Switch>(R.id.switchLights)
        val switchThermostat = findViewById<Switch>(R.id.switchThermostat)

        switchLights.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Handle light switch ON
                Toast.makeText(this, "Lights ON", Toast.LENGTH_SHORT).show()
                // Add more logic here to control the lights
            } else {
                // Handle light switch OFF
                Toast.makeText(this, "Lights OFF", Toast.LENGTH_SHORT).show()
                // Add more logic here to control the lights
            }
        }

        switchThermostat.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Handle thermostat switch ON
                Toast.makeText(this, "Thermostat ON", Toast.LENGTH_SHORT).show()
                // Add more logic here to control the thermostat
            } else {
                // Handle thermostat switch OFF
                Toast.makeText(this, "Thermostat OFF", Toast.LENGTH_SHORT).show()
                // Add more logic here to control the thermostat
            }
        }
    }
}