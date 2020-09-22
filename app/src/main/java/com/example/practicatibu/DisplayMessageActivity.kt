package com.example.practicatibu

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_display_message.*

class DisplayMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        val nameTitle = intent.getStringExtra(PARAM_MESSAGE)
        tV_name_title.text = "$nameTitle"
    }

    fun imageClickeable(view: View) {
        val isViewVisibility = when (tV_description_image.visibility) {
            View.VISIBLE -> View.INVISIBLE
            View.INVISIBLE -> View.VISIBLE
            else -> View.VISIBLE
        }
        tV_description_image.visibility = isViewVisibility
    }
}