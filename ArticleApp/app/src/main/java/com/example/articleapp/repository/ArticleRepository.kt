package com.example.articleapp.repository

import com.example.articleapp.model.Article

class ArticleRepository {
    private val articles: MutableList<Article> = ArrayList()
    init {
        if (articles.isEmpty()) {
            articles.add(Article("Gåture hitter, men det kan være en livsfarlig hobby", "Det er vigtigt at tjekke din sikkerhed, inden du begiver dig ud på din daglige gåtur i vintermørket. Uanset om det er mørkt eller lyst."))
        }
    }
    fun getArticles(): MutableList<Article> {
        return articles
    }

    fun fetchRandomArticle(): Article {
        return articles.random()
    }
}