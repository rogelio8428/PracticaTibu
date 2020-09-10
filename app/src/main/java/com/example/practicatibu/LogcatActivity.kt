package com.example.practicatibu

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class LogcatActivity : AppCompatActivity() {

    private val TAG = LogcatActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logcat)

        Log.i(TAG, R.string.create.toString())
    }
    override fun onStart(){
        super.onStart()
        Log.i(TAG, R.string.start.toString())
    }

    override fun onPause(){
        super.onPause()
        Log.i(TAG, R.string.pause.toString())
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, R.string.restart.toString())
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, R.string.resume.toString())
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, R.string.stop.toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, R.string.destroy.toString())
    }
}
