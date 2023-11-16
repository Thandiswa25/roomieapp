package com.example.roomie

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.roomie.LocalDB.LocationsDB
import java.util.*

class location : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
        val areaSpinner = findViewById<Spinner>(R.id.area_spinner)

        val locationSpinner = findViewById<Spinner>(R.id.location_spinner)
        var data = listOf("Joburg", "PTA", "CPT")
        var selectedLocation = ""
        var selectedArea = "";
        var selectedBuildingName = "";
        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        locationSpinner.adapter = adapter

        locationSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedLocation = parent?.getItemAtPosition(position).toString()

                data = LocationsDB.getArea(selectedLocation)
                adapter =
                    ArrayAdapter(this@location, android.R.layout.simple_spinner_item, data)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                areaSpinner.adapter = adapter

                areaSpinner.onItemSelectedListener =
                    object : AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                        ) {
                            selectedArea = parent?.getItemAtPosition(position).toString()
                            // Handle the selected item here
                        }
                        override fun onNothingSelected(parent: AdapterView<*>?) {
                            // Handle the case when nothing is selected
                        }
                    }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle the case when nothing is selected
            }
        }

        data = LocationsDB.getArea("Joburg")
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        areaSpinner.adapter = adapter
        areaSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedArea = parent?.getItemAtPosition(position).toString()
                // Handle the selected item here
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle the case when nothing is selected
            }
        }

        val date = findViewById<TextView>(R.id.date_field)
        // perform click event on edit text
        date?.setOnClickListener {
            // calender class's instance and get current date, month, and year from the calendar
            val c = Calendar.getInstance()
            val mYear = c.get(Calendar.YEAR) // current year
            val mMonth = c.get(Calendar.MONTH) // current month
            val mDay = c.get(Calendar.DAY_OF_MONTH) // current day

            // date picker dialog
            val datePickerDialog = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    // set day of month, month, and year value in the edit text
                    date?.setText("$dayOfMonth/${monthOfYear + 1}/$year")
                }, mYear, mMonth, mDay)

            datePickerDialog?.show()
        }

        val minPriceSpinner = findViewById<Spinner>(R.id.min_price_spinner)
        data = listOf("1 500", "2 000", "2 5000", "3 000")
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        minPriceSpinner.adapter = adapter

        minPriceSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                // Handle the selected item here
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle the case when nothing is selected
            }
        }

        val maxPriceSpinner = findViewById<Spinner>(R.id.max_price_spinner)
        data = listOf("2 000", "2 5000", "3 000", "5 000")
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        maxPriceSpinner.adapter = adapter

        maxPriceSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                // Handle the selected item here
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle the case when nothing is selected
            }
        }

        val buildingName = findViewById<Spinner>(R.id.building_spinner)
        data = listOf("Central", "North", "West", "EAST")
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        buildingName.adapter = adapter

        buildingName.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedBuildingName = parent?.getItemAtPosition(position).toString()
                // Handle the selected item here
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle the case when nothing is selected
            }
        }

        val bedrooms = findViewById<Spinner>(R.id.bedroom_spinner)
        data = listOf("1", "2", "3", "4")
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        bedrooms.adapter = adapter

        bedrooms.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                // Handle the selected item here
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle the case when nothing is selected
            }
        }

        val parkingGroup = findViewById<RadioGroup>(R.id.parking_radio_group)
        val parking = when (parkingGroup.checkedRadioButtonId) {
            R.id.radioButton5 -> "Yes"
            R.id.radioButton6 -> "No"
            else -> "No"
        }

        val nextButton = findViewById<Button>(R.id.location_next_btn)
        nextButton.setOnClickListener {
            LocationsDB.addUserLocation("Location: "+ selectedLocation +"\nArea: "+selectedArea+"\nBuilding name: " + selectedBuildingName)
            startActivity(Intent(this, personal_details::class.java))
            finish()
        }

    }
}