package com.example.practicatibu

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class LogcatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logcat)

        Log.i("MainActivity", R.string.create.toString())
    }
    override fun onStart(){
        super.onStart()
        Log.i("MainActivity", R.string.start.toString())
    }

    override fun onPause(){
        super.onPause()
        Log.i("MainActivity", R.string.pause.toString())
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MainActivity", R.string.restart.toString())
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", R.string.resume.toString())
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", R.string.stop.toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", R.string.destroy.toString())
    }
}
