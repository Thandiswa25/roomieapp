package com.example.roomie

import android.annotation.SuppressLint
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

class login : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val loginButton = findViewById<Button>(R.id.login_btn2)
        val usernameEditText = findViewById<EditText>(R.id.username_login2)
        val passwordEditText = findViewById<EditText>(R.id.password_login2)



            loginButton.setOnClickListener {
                when {
                    TextUtils.isEmpty(usernameEditText.text.toString().trim() { it <= ' ' }) -> {
                        Toast.makeText(this@login, "Please enter username", Toast.LENGTH_LONG)
                            .show()
                        usernameEditText.text.clear()
                    }

                    TextUtils.isEmpty(passwordEditText.text.toString().trim() { it <= ' ' }) -> {
                        Toast.makeText(this@login, "Please enter password", Toast.LENGTH_LONG)
                            .show()
                        passwordEditText.text.clear()
                    }

                    else -> {
                        val usernames: String = usernameEditText.text.toString().trim { it <= ' ' }
                        val passwords: String = passwordEditText.text.toString().trim { it <= ' ' }
                        FirebaseAuth.getInstance().signInWithEmailAndPassword(usernames, passwords)
                            .addOnCompleteListener(
                                { task ->
                                    if (task.isSuccessful) {
                                        val firebaseUser: FirebaseUser = task.result!!.user!!
                                        Toast.makeText(
                                            this@login, "You have successfully registered",
                                            Toast.LENGTH_LONG
                                        ).show()
                                        val intent = Intent(this@login, location::class.java)
                                        intent.flags =
                                            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                        intent.putExtra(
                                            "user_id",
                                            FirebaseAuth.getInstance().currentUser!!.uid
                                        )
                                        intent.putExtra("username_id", usernames)
                                        intent.putExtra("password_id", passwords)
                                        startActivity(intent)
                                        finish()
                                    } else {
                                        Toast.makeText(
                                            this@login, task.exception!!.message.toString(),
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }

                                }

                            )
                    }
                }
            }



        val createAccountTextView = findViewById<TextView>(R.id.create_account_btn)

        createAccountTextView.setOnClickListener {
            val intent = Intent(this, register::class.java)
            startActivity(intent)
            finish()
        }


    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}