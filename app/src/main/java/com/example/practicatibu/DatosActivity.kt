package com.example.practicatibu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_datos.*

class DatosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos)

      var userBoolean = intent.hasExtra(PARAM_USER)
        if (userBoolean) {
        var user = intent.getSerializableExtra(PARAM_USER) as Usuario

            tVNameUser.text = user.name
            tVSportUser.text = user.sport
            tVDateUser.text = user.date

            if (user.sex){
                tVSexualityUser.text = getString(R.string.man)
            }else{
                tVSexualityUser.text = getString(R.string.woman)
            }

        }

    }
}