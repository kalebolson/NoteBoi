package com.example.noteboi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import androidx.core.widget.addTextChangedListener
import java.util.*

class AddNote : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title="New Note"

        val noteTitle = findViewById<EditText>(R.id.noteTitle)
        val noteDetails = findViewById<EditText>(R.id.noteDetails)

        noteTitle.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length != 0) {
                    supportActionBar?.title = s
                }
            }

            override fun afterTextChanged(s: Editable?) {
                
            }
        })

        val todaysDate = ""+(Calendar.MONTH+1)+"/"+Calendar.DAY_OF_MONTH+"/"+Calendar.YEAR
        val currentTime = ""+pad(Calendar.HOUR)+":"+pad(Calendar.MINUTE)

        Log.d("calendar", "Date: $todaysDate | Time: $currentTime")
    }

    private fun pad(i: Int) : String {
        if(i<10){
            return "0"+i
        }
        else return ""+i
    }
}