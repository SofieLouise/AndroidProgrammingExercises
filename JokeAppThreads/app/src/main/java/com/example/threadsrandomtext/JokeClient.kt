package com.example.threadsrandomtext

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

public interface JokeClient {
    @GET("jokes/random")
    fun getJoke() : Call<JokeResponseModel>

    @GET("jokes/random")
    fun randomJoke(): Response<JokeResponseModel>

}