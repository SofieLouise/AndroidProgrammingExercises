package com.example.threadsrandomtext

import com.google.gson.annotations.SerializedName

class Joke {
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("joke")
    var joke: String? = null
    @SerializedName("categories")
    var categories: Array<String>? = null
}

class JokeResponseModel {
    @SerializedName("type")
    var type: String = ""
    @SerializedName("value")
    var value: Joke? = null
}