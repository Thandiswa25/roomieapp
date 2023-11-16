package com.example.roomie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.roomie.LocalDB.UserDB

class display_roomie : AppCompatActivity() {

    private  lateinit var  email : EditText
    private  lateinit var  message : EditText
    private  lateinit var  send : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_roomie)

        email = findViewById(R.id.edt_email2)
        message = findViewById(R.id.edt_message)
        send = findViewById(R.id.button)


        send.setOnClickListener(){


            val emailmessage = email.text.toString()
            val emailsubject = message.text.toString()


            val intent =Intent(Intent.ACTION_SEND)

            intent.putExtra(Intent.EXTRA_EMAIL, arrayListOf(emailmessage))
            intent.putExtra(Intent.EXTRA_TEXT,emailsubject)

            intent.type = "message/rfc822"

            startActivity(Intent.createChooser(intent,"choose an email client "))


        }


        var textDetails = findViewById<TextView>(R.id.roomieDetails)
        val intent = intent
        val userID = intent.getStringExtra("userID").toString().toInt()

        val details = "Name: " + UserDB.getUsers()[userID].name +
                    "\nSurname: " + UserDB.getUsers()[userID].surname+
                    "\nGender: " +  UserDB.getUsers()[userID].gender +
                    "\nAge: "+ UserDB.getUsers()[userID].age +
                    "\nOccupation: " + UserDB.getUsers()[userID].occupation+
                    "\nEmail: " + UserDB.getUsers()[userID].email+
                    "\nAbout me: " + UserDB.getUsers()[userID].aboutMe

        textDetails.text = details

    }
}