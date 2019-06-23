package com.github.skyfe79.materialtablayout

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(
    private val itemList: List<String>
): RecyclerView.Adapter<DemoViewHolder>() {

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DemoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return DemoViewHolder(view)
    }

    override fun onBindViewHolder(holder: DemoViewHolder, position: Int) {
        holder.cardTitle.text = itemList[position]
    }
}