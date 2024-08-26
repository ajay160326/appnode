package com.example.myapplication

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.RatingBar
import android.widget.SeekBar
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Use the XML layout

        val seek = findViewById<SeekBar>(R.id.myseek)
        seek?.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    // Custom code
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {
                    // On seek touch
                }

                override fun onStopTrackingTouch(s: SeekBar?) {
                    val output = "Progress is ${s?.progress}%"
                    Toast.makeText(this@MainActivity, output, Toast.LENGTH_LONG).show()
                }
            }
        )
    }
}
