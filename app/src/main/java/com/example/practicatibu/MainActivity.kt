package com.example.practicatibu

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

const val PARAM_MESSAGE = "name"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun sendNameForTitle(view: View) {
        val newName = eT_title_terms_and_conditions.text.toString()

        if (!newName.isNullOrEmpty()) {
            val intent = Intent(this, DisplayMessageActivity::class.java).apply {
                putExtra(PARAM_MESSAGE, newName)
            }
            startActivity(intent)
        } else {
            Toast.makeText(this, R.string.toast_name_validation, Toast.LENGTH_LONG).show()
        }
    }

    fun termsAndConditions(view: View) {
        startActivity(Intent(this, Terminos::class.java).apply {})
    }

    fun changeImplicit(view: View) {
        startActivity(Intent(this, ImplicitIntent::class.java).apply {})
    }

    fun newForm(view: View) {
        startActivity(Intent(this, LogcatActivity::class.java))
    }

}