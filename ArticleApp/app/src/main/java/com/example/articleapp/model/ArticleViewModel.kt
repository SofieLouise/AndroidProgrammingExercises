package com.example.articleapp.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.articleapp.repository.ArticleRepository

class ArticleViewModel : ViewModel(){
    private val article = MutableLiveData<Article>()
    private val articleRepository: ArticleRepository = ArticleRepository()

    public fun getArticle(): MutableLiveData<Article> {
        return article
    }
    public fun getArticle(index: Int) {
        article.value = articleRepository.getArticles()[index]
    }
}