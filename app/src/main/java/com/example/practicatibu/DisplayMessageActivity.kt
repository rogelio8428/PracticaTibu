package com.example.practicatibu

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        val message = intent.getStringExtra("mensaje")
        val saludo = findViewById<TextView>(R.id.TVMuestra).apply {
            text = "Hola $message" }

    }
}