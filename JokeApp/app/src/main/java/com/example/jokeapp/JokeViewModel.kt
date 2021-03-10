package com.example.jokeapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jokeapp.model.Joke

class JokeViewModel : ViewModel() {
    private val joke = MutableLiveData<Joke>()
    private val jokeRepository: JokeRepository = JokeRepository()

    public fun getJoke(): MutableLiveData<Joke> {
        return joke
    }

    public fun randomJoke() {
        joke.value = jokeRepository.fetchRandomJoke()
    }
}