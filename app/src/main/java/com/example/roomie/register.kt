package com.example.roomie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class register : AppCompatActivity() {

    lateinit var database: FirebaseDatabase
    private lateinit var refernce : DatabaseReference




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val loginButton = findViewById<Button>(R.id.sign_up_btn)
        val usernameEditText = findViewById<EditText>(R.id.username_sign_up)
        val passwordEditText = findViewById<EditText>(R.id.password_sign_up)

        loginButton.setOnClickListener {
            when {
                TextUtils.isEmpty(usernameEditText.text.toString().trim() { it <= ' ' }) -> {
                    Toast.makeText(this@register, "Please enter username", Toast.LENGTH_LONG).show()
                    usernameEditText.text.clear()
                }
                TextUtils.isEmpty(passwordEditText.text.toString().trim() { it <= ' ' }) -> {
                    Toast.makeText(this@register, "Please enter password", Toast.LENGTH_LONG).show()
                    passwordEditText.text.clear()
                }

                else ->{
                    val usernames:String =usernameEditText.text.toString().trim{ it <= ' ' }
                    val passwords:String =passwordEditText.text.toString().trim{ it <= ' ' }
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(usernames ,passwords)
                        .addOnCompleteListener(
                            {task ->
                                if(task.isSuccessful){
                                    val firebaseUser: FirebaseUser =task.result!!.user!!
                                    Toast.makeText(this@register ,"You have successfully registered",
                                        Toast.LENGTH_LONG).show()
                                    val intent =Intent(this@register ,login::class.java)
                                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    intent.putExtra("user_id" ,firebaseUser.uid)
                                    intent.putExtra("username_id" ,usernames)
                                    intent.putExtra("password_id",passwords)
                                    startActivity(intent)
                                    finish()
                                }else
                                {
                                    Toast.makeText(this@register ,task.exception!!.message.toString(),
                                        Toast.LENGTH_LONG).show()}

                            }

                        )
                }
            }
        }

        val loginBtn = findViewById<TextView>(R.id.login_text_btn)

        loginBtn.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
            finish()
        }

    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}