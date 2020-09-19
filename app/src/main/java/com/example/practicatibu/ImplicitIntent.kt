package com.example.practicatibu

import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_implicit_intent.*

class ImplicitIntent : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent)

    }

    fun navigationWithLink(view: View) {
        //corroboro que tenga una app que pueda abrir el link
        val activities: List<ResolveInfo> =packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)
        val isIntentSafe: Boolean = activities.isNotEmpty()
        var editText_url:String = eT_url.text.toString()
        if (! editText_url.contains(getString(R.string.http))) {
            editText_url = "http://$ editText_url"
        }
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse( editText_url )

        if (isIntentSafe) {
        startActivity(i)
        }
    }
}