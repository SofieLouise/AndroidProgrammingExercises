package com.example.localizedapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    val imageResources : IntArray = intArrayOf(
            R.drawable.pexels_photo,
            R.drawable.pexels_photo_210723,
            R.drawable.pexels_photo_462353,
            R.drawable.pexels_photo_62592)
    var counter : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun forward(view: View) {
        Log.d("forward", "f")
        val imageView = findViewById<ImageView>(R.id.imageView)
        counter = Math.floorMod((counter + 1), imageResources.size);
        imageView.setImageResource(imageResources[counter])
    }

    fun back(view: View) {
        Log.d("back", "b")
        val imageView = findViewById<ImageView>(R.id.imageView)
        counter = Math.floorMod((counter - 1), imageResources.size);
        imageView.setImageResource(imageResources[counter])
    }
}