package com.example.practicatibu.ListaNombreAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicatibu.R
import com.example.practicatibu.model.Usuario
import kotlinx.android.synthetic.main.list_item.view.*

class ItemAdapter(private val context: Context, private val dataset: List<Usuario>) :
    RecyclerView.Adapter<ItemAdapter.ItemHolder>() {

    class ItemHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val nombre : TextView = view.tv_name_user
        val sport : TextView = view.tv_sport
        val date : TextView = view.tv_date
        val sex : TextView = view.tv_sexuality
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val layoutInflater = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        val itemHolder = ItemHolder(layoutInflater)
        itemHolder.view.setOnClickListener{
            //itemHolder.AdapterPosition
        }
        return itemHolder
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = dataset[position]
        holder.nombre.text = item.name
        holder.sport.text = item.sport
        holder.date.text = item.date
        if (item.sex) {
            holder.sex.text = context.getString(R.string.man)
        } else {
            holder.sex.text = context.getString(R.string.woman)
        }
    }

    override fun getItemCount(): Int = dataset.size

}