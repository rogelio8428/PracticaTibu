package com.example.practicatibu

import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_logcat.*
import java.util.*


class LogcatActivity : AppCompatActivity(){

    private val TAG = LogcatActivity::class.java.simpleName

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logcat)

        Log.i(TAG, R.string.create.toString())

        val calend = Calendar.getInstance()
        val year = calend.get(Calendar.YEAR)
        val month = calend.get(Calendar.MONTH)
        val day = calend.get(Calendar.DAY_OF_MONTH)

        button_date.setOnClickListener{
            val dpd = DatePickerDialog( this, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                date_editText.setText("" + mDay + "/" + mMonth + "/" + mYear)
            }, year, month, day)
            dpd.show()
        }



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
