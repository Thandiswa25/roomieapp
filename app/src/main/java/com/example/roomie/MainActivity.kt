package com.example.roomie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signUpBtn = findViewById<Button>(R.id.sign_up)
        val loginBtn = findViewById<Button>(R.id.login)
         val adminBtn = findViewById<Button>(R.id.btnAdmin)


        signUpBtn.setOnClickListener {
            val intent = Intent(this, register::class.java)
            startActivity(intent)
            finish()
        }

        loginBtn.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
            finish()
        }

        adminBtn.setOnClickListener {
            val intent = Intent(this, AdminLogin::class.java)
            startActivity(intent)
            finish()
        }


    }
}