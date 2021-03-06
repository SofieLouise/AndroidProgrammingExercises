package com.programming.adnroid.sdu.activities_exercise_1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.programming.adnroid.sdu.activities_exercise_1.models.User
import org.w3c.dom.Text

class NameActivity : AppCompatActivity() {


    private var etYourName: EditText? = null
    private lateinit var etYourNameLateinit: EditText
    private var btn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        etYourName = findViewById<View>(R.id.etYourName) as EditText
        etYourNameLateinit = findViewById<View>(R.id.etYourName) as EditText

        val userDao = AppDatabase.getAppDatabase(this)?.userDao()
        val user = userDao?.user
        findViewById<TextView>(R.id.etYourName).apply {
            text = user?.name
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(Constants.TAG, "NameActivity onSaveInstanceState ")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i(Constants.TAG, "NameActivity onRestoreInstanceState ")
    }

    override fun onStart() {
        super.onStart()
        Log.i(Constants.TAG, "NameActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(Constants.TAG, "NameActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(Constants.TAG, "NameActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(Constants.TAG, "NameActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        this.apply {  }
        Log.i(Constants.TAG, "NameActivity onDestroy")
    }

    fun redirectToNextActivity(view: View) {
        if (!TextUtils.isEmpty(etYourName!!.text)) {
            val intent = Intent(this, AddressActivity::class.java)
            intent.putExtra(Constants.NAME_KEY, etYourName!!.text.toString())
            startActivity(intent)
        }
    }

    private fun finishActivity() {
        finish()
    }
}