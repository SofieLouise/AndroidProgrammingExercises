package com.example.wizardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
const val EXTRA_BIRTHDATE = "com.example.wizardapp.BIRTHDATE"

class BirthDateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birth_date)
    }

    fun sendBirthdate(view: View){
        val text = findViewById<EditText>(R.id.editTextDate)
        val value = text.text.toString()
        val intent = Intent(this, DetailsActivity::class.java).apply {
            putExtra(EXTRA_BIRTHDATE, value)
            putExtra(EXTRA_NAME, intent.getStringExtra(EXTRA_NAME))
            putExtra(EXTRA_ADDRESS, intent.getStringExtra(EXTRA_ADDRESS))
        }
        startActivity(intent)
    }
}