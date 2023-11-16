package com.example.roomie

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.roomie.LocalDB.User
import com.example.roomie.LocalDB.UserDB
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class personal_details : AppCompatActivity() {
    lateinit var database: FirebaseDatabase
    private lateinit var refernce : DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_details)

        database = FirebaseDatabase.getInstance()
        refernce =database.getReference().child("Roomie")
        val titleEditText = findViewById<EditText>(R.id.title_)
        val nameEditText = findViewById<EditText>(R.id.name)
        val surnameEditText = findViewById<EditText>(R.id.surname)
        val ageEditText = findViewById<EditText>(R.id.age)
        val idNumberEditText = findViewById<EditText>(R.id.id_number)
        val telNumberEditText = findViewById<EditText>(R.id.tel_number)
        val emailEditText = findViewById<EditText>(R.id.email)
        val genderRadioGroup = findViewById<RadioGroup>(R.id.gender_group)
        val occupationRadioGroup = findViewById<RadioGroup>(R.id.occupation_group)
        val aboutMeEditText = findViewById<EditText>(R.id.about_me)
        val nextButton = findViewById<Button>(R.id.details_next_btn)

        nextButton.setOnClickListener {
            val title = titleEditText.text.toString().trim()
            val name = nameEditText.text.toString().trim()
            val surname = surnameEditText.text.toString().trim()
            val age = ageEditText.text.toString().trim()
            val idNumber = idNumberEditText.text.toString().trim()
            val telNumber = telNumberEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val gender = when (genderRadioGroup.checkedRadioButtonId) {
                R.id.radioButton -> "Male"
                R.id.radioButton2 -> "Female"
                else -> ""
            }
            val occupation = when (occupationRadioGroup.checkedRadioButtonId) {
                R.id.radioButton3 -> "Student"
                R.id.radioButton4 -> "Worker"
                else -> ""
            }
            val aboutMe = aboutMeEditText.text.toString().trim()

            // Perform validation
            if (title.isEmpty() || name.isEmpty() || surname.isEmpty() || age.isEmpty() ||
                idNumber.isEmpty() || telNumber.isEmpty() || email.isEmpty() ||
                gender.isEmpty() || occupation.isEmpty() || aboutMe.isEmpty()) {
                // Display an error message or handle the validation error
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                UserDB.addUser(
                    User(
                        name,
                        surname,
                        title,
                        age,
                        idNumber,
                        telNumber,
                        email,
                        gender,
                        occupation,
                        aboutMe
                    )
                )
                val Coll_ID = refernce.get().isSuccessful.toString()

                val RoomieDB =User(name ,surname ,title ,age ,idNumber ,telNumber ,email ,gender ,occupation ,aboutMe)

                refernce.child(Coll_ID).setValue(RoomieDB).addOnCompleteListener()
                {
                    Toast.makeText(this ,"Data has been saved successfully" ,Toast.LENGTH_LONG).show()
                }.addOnFailureListener()
                {
                    Toast.makeText(this,"error ",Toast.LENGTH_LONG).show()
                }

                startActivity(Intent(this, findRoomie::class.java))
                finish()
            }
        }
    }

}