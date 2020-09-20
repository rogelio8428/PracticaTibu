package com.example.practicatibu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_datos.*

class DatosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos)

        if ( intent.hasExtra(PARAM_USER)) {
        val newUser = intent.getSerializableExtra(PARAM_USER) as Usuario
            tVNameUser.text = newUser.name
            tVSportUser.text = newUser.sport
            tVDateUser.text = newUser.date
            val manOrWoman = if (newUser.sex) {
                getString(R.string.man)
            }else {
                getString(R.string.woman)
            }
            tVSexualityUser.text = manOrWoman
        }
    }
}