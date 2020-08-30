package com.example.practicatibu

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

const val PARAM_MESSAGE ="name"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun enviarMensaje(view: View){
        val message = editTextTextPersonName.text.toString()

        if (!message.isNullOrEmpty()) {

            val intent = Intent(this, DisplayMessageActivity::class.java).apply {
                putExtra(PARAM_MESSAGE, message)
            }
            startActivity(intent)
        }
    else {

            Toast.makeText(this, R.string.toast, Toast.LENGTH_LONG).show()
        }
    }

}