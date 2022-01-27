package com.example.myapplication.learnlang.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.learnlang.R

class AuthorizationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)

        var button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener{
            val intent: Intent = Intent(this, BottomNavigationActivity::class.java)
            startActivity(intent)
        }

    }
}