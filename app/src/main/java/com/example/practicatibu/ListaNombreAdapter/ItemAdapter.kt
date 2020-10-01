package com.example.practicatibu.ListaNombreAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicatibu.R
import com.example.practicatibu.base.BaseViewHolder
import com.example.practicatibu.model.Usuario
import kotlinx.android.synthetic.main.list_item.view.*

class ItemAdapter(
    private val context: Context,
    private val dataset: List<Usuario>,
    private val itemClickListener: ItemAdapter.OnItemClickListener,
) : RecyclerView.Adapter<ItemAdapter.ItemHolder>() {

    interface OnItemClickListener {
        fun onItemClick(name: String?, sport: String?, date: String?, sex: Boolean)
    }

    inner class ItemHolder(itemView: View) : BaseViewHolder<Usuario>(itemView) {
        override fun bind(item: Usuario, position: Int) {
            itemView.tv_name_user.text = item.name
            itemView.tv_sport.text = item.sport
            itemView.tv_date.text = item.date
            if (item.sex) {
                itemView.tv_sexuality.text = context.getString(R.string.man)
            } else {
                itemView.tv_sexuality.text = context.getString(R.string.woman)
            }
            itemView.setOnClickListener {
                itemClickListener.onItemClick(item.name, item.sport, item.date, item.sex)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        when (holder) {
            is ItemHolder -> holder.bind(dataset[position], position)
            else -> throw IllegalArgumentException("Se olvido de pasar el viewHolder en el bind")
        }
    }

    override fun getItemCount(): Int = dataset.size
}