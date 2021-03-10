package com.example.randomintegersrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager
        val adapter = IntAdapter(getRandomNumbers(1000))
        recyclerView.adapter = adapter
    }

    private fun getRandomNumbers(n : Int) : MutableList<Int> {
        var numbers: MutableList<Int> = ArrayList()
        for (i in 0..n) {
            numbers.add(Random.nextInt(10000))
        }
        return numbers
    }
}