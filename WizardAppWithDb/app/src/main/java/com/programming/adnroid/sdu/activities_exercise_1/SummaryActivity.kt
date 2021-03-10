package com.programming.adnroid.sdu.activities_exercise_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.programming.adnroid.sdu.activities_exercise_1.models.User

/**
 * Created by grzegorzbaczek on 18/02/2018.
 */
class SummaryActivity : AppCompatActivity() {

    lateinit var tvName: TextView
    lateinit var tvAddress: TextView
    lateinit var tvDate: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)
        tvName = findViewById(R.id.tvName)
        tvAddress = findViewById(R.id.tvAddress)
        tvDate = findViewById(R.id.tvDateOfBirth)
        val intent = intent

        val name = intent.getStringExtra(Constants.NAME_KEY)
        val address = intent.getStringExtra(Constants.ADDRESS_KEY)
        val birthday = intent.getStringExtra(Constants.DATE_OF_BIRTH_KEY)

        tvName.setText(name)
        tvAddress.setText(address)
        tvDate.setText(birthday)

        val userDao = AppDatabase.getAppDatabase(this)?.userDao()
        val userCount = userDao?.countUsers()
        if (userCount != null) {
            userDao.insert(User(userCount + 1, name, address, birthday))
        }
        Log.i("DATABASE", userDao?.countUsers().toString())

        Log.i(Constants.TAG, "SummaryActivity onCreate")
        (findViewById<View>(R.id.btnBack) as Button).setOnClickListener {
            finishActivity()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(Constants.TAG, "SummaryActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(Constants.TAG, "SummaryActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(Constants.TAG, "SummaryActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(Constants.TAG, "SummaryActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(Constants.TAG, "SummaryActivity onDestroy")
    }

    private fun finishActivity() {
        finish()
    }
}