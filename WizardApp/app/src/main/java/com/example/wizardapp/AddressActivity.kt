package com.example.wizardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

const val EXTRA_ADDRESS = "com.example.wizardapp.ADDRESS"

class AddressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)
    }

    fun sendAddress(view: View){
        val text = findViewById<EditText>(R.id.editTextTextPostalAddress)
        val value = text.text.toString()
        val intent = Intent(this, BirthDateActivity::class.java).apply {
            putExtra(EXTRA_ADDRESS, value)
            putExtra(EXTRA_NAME, intent.getStringExtra(EXTRA_NAME))
        }
        startActivity(intent)
    }
}