package com.example.practicatibu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicatibu.ListaNombreAdapter.ItemAdapter
import kotlinx.android.synthetic.main.activity_view_list.*

class ViewListActivity : AppCompatActivity(), ItemAdapter.OnItemClickListener {

    private val myData = Datasource().loadList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_list)

        initViews()
    }

    private fun initViews() {
        rv_list_user.layoutManager = LinearLayoutManager(this)
        rv_list_user.adapter = ItemAdapter(this, myData, this)
    }

    override fun onItemClick(position: Int) {
        val intentDatosActivity = Intent(this, DatosActivity::class.java).apply {
            putExtra(PARAM_USER, myData[position])
        }
        startActivity(intentDatosActivity)
    }
}