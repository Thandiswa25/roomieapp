package com.example.roomie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AdminLogin : AppCompatActivity() {

    private  lateinit var user:EditText
    private  lateinit var pass:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)

        val loginButton = findViewById<Button>(R.id.login_btn2)
        val usernameEditText = findViewById<EditText>(R.id.username_login2)
        val passwordEditText = findViewById<EditText>(R.id.password_login2)



     //   user.setText("mtho@gmail.com").toString()
     //   pass.setText("mmm10")

        loginButton.setOnClickListener {

            val users = usernameEditText.text.toString();
            val passs = passwordEditText.text.toString();

           if (users == "admin02@gmail.com" && passs == "mmmm10" ) {

                val intent = Intent(this@AdminLogin, Admin::class.java)
                intent.flags
                startActivity(intent)
                finish()

            }

       }

    }



}



