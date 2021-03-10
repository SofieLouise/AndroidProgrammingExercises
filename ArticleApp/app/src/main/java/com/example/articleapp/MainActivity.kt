package com.example.articleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.articleapp.model.ArticleViewModel

class MainActivity : AppCompatActivity() {
    var articleViewModel = ArticleViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        articleViewModel.getArticle().observe(this, { article ->
            //Do something - set view components etc.
        })
    }
}