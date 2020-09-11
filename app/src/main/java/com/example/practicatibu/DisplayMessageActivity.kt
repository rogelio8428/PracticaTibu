package com.example.practicatibu

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_display_message.*

class DisplayMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        val message = intent.getStringExtra(PARAM_MESSAGE)
        TVMuestra.text = "$message"
    }

    fun imageClickeable(view: View){
     val visibility = when(descripcionImagen.visibility){
         View.VISIBLE -> View.INVISIBLE
         View.INVISIBLE -> View.VISIBLE
         else -> View.VISIBLE
     }
        descripcionImagen.visibility = visibility
    }
}