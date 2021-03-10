package com.example.jokeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var jokeViewModel = JokeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        jokeViewModel.getJoke().observe(this, { joke ->
            findViewById<TextView>(R.id.joke).apply {
                text = joke.joke
            }
        })

    }

    fun randomJoke(view: View) {
        jokeViewModel.randomJoke()
    }
}