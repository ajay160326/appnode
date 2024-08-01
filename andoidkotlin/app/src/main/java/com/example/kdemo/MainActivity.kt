package com.example.kdemo

import com.google.android.material.snackbar.Snackbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.kdemo.databinding.ActivityMainBinding

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonWelcome: Button = findViewById(R.id.buttonWelcome)

        buttonWelcome.setOnClickListener {
            Toast.makeText(this, "Hello, Welcome ajay", Toast.LENGTH_SHORT).show()
        }
    }
}