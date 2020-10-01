package com.example.practicatibu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicatibu.ListaNombreAdapter.ItemAdapter
import com.example.practicatibu.model.Usuario
import kotlinx.android.synthetic.main.activity_view_list.*

class ViewListActivity : AppCompatActivity(), ItemAdapter.OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_list)

        initViews()
    }

    private fun initViews() {
        val myData = Datasource().loadList()
        rv_list_user.layoutManager = LinearLayoutManager(this)
        rv_list_user.adapter = ItemAdapter(this, myData, this)
    }

    override fun onItemClick(name: String?, sport: String?, date: String?, sex: Boolean) {
        val user = Usuario(name, sport, date, sex)
        val intentDatosActivity = Intent(this, DatosActivity::class.java).apply {
            putExtra(PARAM_USER, user)
        }
        startActivity(intentDatosActivity)
    }
}