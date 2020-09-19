package com.example.practicatibu

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_logcat.*
import java.util.*

const val PARAM_USER = "datauser"
class LogcatActivity : AppCompatActivity(){

    private val TAG = LogcatActivity::class.java.simpleName
    private var isMan = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logcat)

        Log.i(TAG, R.string.create.toString())
        initViews()
    }

    private fun initViews() {
        switchDeterminaSexualidad()
    }

    override fun onStart(){
        super.onStart()
        Log.i(TAG, R.string.start.toString())
    }

    override fun onPause() {
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

    fun calendarioFechaNacimiento(view: View){
        val calend = Calendar.getInstance()
        val year = calend.get(Calendar.YEAR)
        val month = calend.get(Calendar.MONTH)
        val day = calend.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog( this, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                eT_date.setText("$mDay/$mMonth/$mYear")
            }, year, month, day)
        dpd.show()
    }

    fun switchDeterminaSexualidad(){
        switch_es_hombre.setOnCheckedChangeListener { _ , isChecked ->
            isMan = if (isChecked) {
                tV_resultado_sexualidad.setText(R.string.man)
                true
            } else {
                tV_resultado_sexualidad.setText(R.string.woman)
                false
            }
        }
    }

    fun botonSiguienteActivity(view: View) {
        val nombre = eT_entry_name.text.toString()
        val sport = eT_entry_sport.text.toString()
        val fecha = eT_date.text.toString()

       if (nombre.isNullOrEmpty() || sport.isNullOrEmpty()) {
            when (nombre.isNullOrEmpty() || sport.isNullOrEmpty()) {
                nombre.isNullOrEmpty() && !sport.isNullOrEmpty() -> emptyFieldAlert(emptyName())
                !nombre.isNullOrEmpty() && sport.isNullOrEmpty() -> emptyFieldAlert(emptySport())
                else -> emptyFieldAlert(emptyNameAndSport())
            }
        } else {
            val user = Usuario(nombre, sport, fecha, isMan)
            val inte =Intent(this, DatosActivity::class.java).apply {
                putExtra(PARAM_USER,user)
            }
            startActivity(inte)
        }
    }

    fun emptyFieldAlert( alert : String){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.alert_title_no_field)
        builder.setMessage(alert)
        builder.setPositiveButton(R.string.acept, null);
        builder.show()
    }

    fun emptyNameAndSport(): String {
        return getString(R.string.alert_no_name_sport)
    }

    fun emptyName(): String {
        return getString(R.string.alert_no_name)
    }

    fun emptySport(): String {
        return getString(R.string.alert_no_sport)
    }

}
