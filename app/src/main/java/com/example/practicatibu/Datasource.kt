package com.example.practicatibu

import com.example.practicatibu.model.ListModel

class Datasource {
    fun loadList(): List<ListModel> {
        return listOf<ListModel>(
            ListModel(R.string.name1_list),
            ListModel(R.string.name2_list),
            ListModel(R.string.name3_list),
            ListModel(R.string.name4_list),
            ListModel(R.string.name5_list)
        )
    }
}