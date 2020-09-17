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
import com.example.practicatibu.LogcatActivity as LogcatActivity1

const val PARAM_USER = "datauser"
class LogcatActivity : AppCompatActivity(){

    private val TAG = LogcatActivity1::class.java.simpleName
    private var man = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logcat)

        Log.i(TAG, R.string.create.toString())

        initView()
    }

    fun initView(){
        switchDeterminaSexualidad()
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
            if (isChecked) {
                tV_resultado_sexualidad.setText(R.string.man)
                man = true
            } else {
                tV_resultado_sexualidad.setText(R.string.woman)
                man = false
            }
        }
    }

    fun botonSiguienteActivity(view: View) {

        val nombre = eT_entry_name.text.toString()
        val sport = eT_entry_sport.text.toString()
        val fecha = eT_date.text.toString()
        val sex = man

       if (nombre.isNullOrEmpty() || sport.isNullOrEmpty()) {
            when (nombre.isNullOrEmpty() || sport.isNullOrEmpty()) {
                nombre.isNullOrEmpty() && !sport.isNullOrEmpty() -> nombreVacio()
                !nombre.isNullOrEmpty() && sport.isNullOrEmpty() -> deporteVacio()
                else -> nombreYDeporteVacios()
            }
        } else {
            val user = Usuario(nombre, sport, fecha, sex)
            val inte =Intent(this, DatosActivity::class.java).apply {
                putExtra(PARAM_USER,user)
            }
            startActivity(inte)
        }
    }

    fun nombreYDeporteVacios(){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.alert_title_sin_dos_campo)
        builder.setMessage(R.string.alert_no_name_sport)
        builder.setPositiveButton(R.string.acept, null);
        builder.show()
    }
    fun nombreVacio(){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.alert_title_sin_un_campo)
        builder.setMessage(R.string.alert_no_name)
        builder.setPositiveButton(R.string.acept, null);
        builder.show()
    }
    fun deporteVacio(){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.alert_title_sin_un_campo)
        builder.setMessage(R.string.alert_no_sport)
        builder.setPositiveButton(R.string.acept, null);
        builder.show()
    }
}
