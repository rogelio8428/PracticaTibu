package com.example.practicatibu

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

const val PARAM_MESSAGE ="name"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun enviarMensaje(view: View){
        val mensaje = editTextTextPersonName.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(PARAM_MESSAGE, mensaje)
        }
        startActivity(intent)
    }
}