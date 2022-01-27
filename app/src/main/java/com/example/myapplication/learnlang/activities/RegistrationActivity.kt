package com.example.myapplication.learnlang.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.learnlang.R

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val sharedPref = this?.getSharedPreferences("Counter", MODE_PRIVATE)

        if (sharedPref.getBoolean("firstEntered", true)) {
            Toast.makeText(
                this,
                "Value: ${sharedPref.getBoolean("firstEntered", true)}",
                Toast.LENGTH_SHORT
            ).show()
            val myCount = sharedPref.edit()
            myCount.putBoolean("firstEntered", false)
            myCount.apply()
            // приложение открыто впервые

            var button: Button = findViewById(R.id.button)
            button.setOnClickListener {
                Toast.makeText(
                    this,
                    "Error: ${sharedPref.getBoolean("firstEntered", true)}",
                    Toast.LENGTH_SHORT
                ).show()
                // приложение было открыто несколько раз..
                val intent: Intent = Intent(this, AuthorizationActivity::class.java)
                startActivity(intent)
            }

        } else {
            Toast.makeText(
                this,
                "Error: ${sharedPref.getBoolean("firstEntered", true)}",
                Toast.LENGTH_SHORT
            ).show()
            // приложение было открыто несколько раз..
            val intent: Intent = Intent(this, AuthorizationActivity::class.java)
            startActivity(intent)
        }
    }
}