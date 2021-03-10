package com.example.threadsrandomtext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    var workerThread: Thread? = null
    var running = true
    var textView : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById<TextView>(R.id.textView)

        val workerThread = Thread {
            while (running) {
                getJoke()
                try {
                    Thread.sleep(5000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
        workerThread.start()
    }

    private fun getJoke() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.icndb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(JokeClient::class.java)
        val call = service.getJoke()

        // Option
        /*
        val jokeResponseModel = call.execute().body()
        textView?.post {
            textView?.text = jokeResponseModel?.value?.joke!!
        }
        */
        // Option using call enqueue
        call.enqueue(object : Callback<JokeResponseModel> {
            override fun onResponse(call: Call<JokeResponseModel>, response: Response<JokeResponseModel>) {
                if (response.isSuccessful) {
                    val jokeResponseModel : JokeResponseModel = response.body()!!
                    textView?.post {
                        textView?.text = jokeResponseModel.value?.joke!!
                    }
                }
            }

            override fun onFailure(call: Call<JokeResponseModel>, t: Throwable) {
                println("Failure")
            }
        })
    }

    override fun onDestroy() {
        running = false
        super.onDestroy()
        try {
            workerThread?.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}