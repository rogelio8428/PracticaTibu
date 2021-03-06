package com.example.practicatibu

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.practicatibu.interfaces.ModelValidationListener
import com.example.practicatibu.model.Usuario
import kotlinx.android.synthetic.main.activity_logcat.*
import java.util.*

const val PARAM_USER = "datauser"

class LogcatActivity : AppCompatActivity() {

    private val TAG = LogcatActivity::class.java.simpleName
    private var isMan = false
    private lateinit var user: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logcat)

        Log.i(TAG, R.string.create.toString())
        initViews()
        initUser()
    }

    private fun initUser() {
        user = Usuario()
        user.setModelValidationListener(object : ModelValidationListener {
            override fun isOldEnough(isOlder: Boolean) {
                if (isOlder) {
                    button_next.isEnabled = true
                    tV_validation_age.visibility = View.INVISIBLE
                } else {
                    button_next.isEnabled = false
                    tV_validation_age.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun initViews() {
        switchDeterminaSexualidad()
    }

    override fun onStart() {
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

    fun calendarioFechaNacimiento(view: View) {
        val calend = Calendar.getInstance()
        val year = calend.get(Calendar.YEAR)
        val month = calend.get(Calendar.MONTH)
        val day = calend.get(Calendar.DAY_OF_MONTH)
        val dpd =
            DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                eT_date.setText("$mDay/$mMonth/$mYear")
                user.ageValidation(mYear, mMonth, mDay)
                user.date = eT_date.text.toString()
            }, year, month, day)
        dpd.show()
    }

    fun switchDeterminaSexualidad() {
        switch_es_hombre.setOnCheckedChangeListener { _, isChecked ->
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
        user.name = eT_entry_name.text.toString()
        user.sport = eT_entry_sport.text.toString()
        if (user.name.isNullOrEmpty() || user.sport.isNullOrEmpty()) {
            when (user.name.isNullOrEmpty() || user.sport.isNullOrEmpty()) {
                user.name.isNullOrEmpty() && !user.sport.isNullOrEmpty() -> emptyFieldAlert(
                    emptyName())
                !user.name.isNullOrEmpty() && user.sport.isNullOrEmpty() -> emptyFieldAlert(
                    emptySport())
                else -> emptyFieldAlert(emptyNameAndSport())
            }
        } else {
            val user = Usuario(user.name, user.sport, user.date, isMan)
            val intentDatosActivity = Intent(this, DatosActivity::class.java).apply {
                putExtra(PARAM_USER, user)
            }
            startActivity(intentDatosActivity)
        }
    }

    fun emptyFieldAlert(alert: String) {
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
