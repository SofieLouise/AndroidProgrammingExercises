package com.example.wizardapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val name = intent.getStringExtra(EXTRA_NAME)
        val nameTextView = findViewById<TextView>(R.id.detailName).apply {
            text = name
        }
        val address = intent.getStringExtra(EXTRA_ADDRESS)
        val addressTextView = findViewById<TextView>(R.id.detailAddress).apply {
            text = address
        }
        val birthdate = intent.getStringExtra(EXTRA_BIRTHDATE)
        val birthdateTextView = findViewById<TextView>(R.id.detailBirthday).apply {
            text = birthdate
        }
    }
}