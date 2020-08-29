package com.example.practicatibu

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun enviarMensaje(view: View){

        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
        val mensaje = editText.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra("mensaje", mensaje)
        }
        startActivity(intent)

    }
}