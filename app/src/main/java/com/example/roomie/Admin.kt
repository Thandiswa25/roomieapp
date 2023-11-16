package com.example.roomie

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Admin : AppCompatActivity() {

    private  lateinit var database : Button

    private  lateinit var  click : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        database = findViewById(R.id.btn_database)
        click = findViewById(R.id.btn_click)

        database.setOnClickListener(){

            var  intent = Intent(Intent.ACTION_VIEW,Uri.parse("https://console.firebase.google.com/u/0/project/roomie-e8c6c/overview"))
            startActivity(intent)
        }
        click.setOnClickListener(){

            intent = Intent(this,findRoomie::class.java)
            startActivity(intent)
            finish()
        }
    }
}