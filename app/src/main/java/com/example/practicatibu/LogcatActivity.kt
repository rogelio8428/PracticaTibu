package com.example.practicatibu

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_logcat.*
import java.util.*


class LogcatActivity : AppCompatActivity(){

    private val TAG = LogcatActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logcat)

        Log.i(TAG, R.string.create.toString())

        initView()
    }

    fun initView(){
        switch_es_hombre.setOnCheckedChangeListener { _ , isChecked ->
            if (isChecked) {
              tV_resultado_sexualidad.setText(R.string.man)
            } else {
                tV_resultado_sexualidad.setText(R.string.woman)
            }
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

    fun calendario(view: View){

        val calend = Calendar.getInstance()
        val year = calend.get(Calendar.YEAR)
        val month = calend.get(Calendar.MONTH)
        val day = calend.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog( this, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                eT_date.setText("$mDay/$mMonth/$mYear")
            }, year, month, day)
            dpd.show()
    }

}
