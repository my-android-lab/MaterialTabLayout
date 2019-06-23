package com.github.skyfe79.materialtablayout

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DemoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val cardTitle: TextView = itemView.findViewById(R.id.cardTitle)
}