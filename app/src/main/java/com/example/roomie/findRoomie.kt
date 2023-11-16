package com.example.roomie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.example.roomie.LocalDB.UserDB

class findRoomie : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_roomie)



        val listView = findViewById<ListView>(R.id.roomiesList)
        val dataList = ArrayList<String>()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,dataList)
        listView.adapter = adapter



        for (count in 0 until UserDB.getUsers().size) {
            //Add user to display list
            val value = UserDB.getUsers()[count].name  +" "+  UserDB.getUsers()[count].surname + " " + UserDB.getUsers()[count].gender +" "+ UserDB.getUsers()[count].age
            dataList.add(value)
            adapter.notifyDataSetChanged()
        }

        listView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, display_roomie::class.java)
            intent.putExtra("userID", position.toString())
            startActivity(intent)
        }


    }
}