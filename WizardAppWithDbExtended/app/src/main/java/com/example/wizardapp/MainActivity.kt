package com.example.wizardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

const val EXTRA_NAME = "com.example.wizardapp.NAME"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendName(view: View){
        val text = findViewById<EditText>(R.id.editTextTextPersonName)
        val value = text.text.toString()
        val intent = Intent(this, AddressActivity::class.java).apply {
            putExtra(EXTRA_NAME, value)
        }
        startActivity(intent)
    }
}