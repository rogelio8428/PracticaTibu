package com.example.practicatibu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.practicatibu.ListaNombreAdapter.ItemAdapter

class ViewListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_list)

        initViews()
    }

    fun initViews() {
        val myDatasource = Datasource().loadList()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDatasource)
        recyclerView.setHasFixedSize(true)
    }
}