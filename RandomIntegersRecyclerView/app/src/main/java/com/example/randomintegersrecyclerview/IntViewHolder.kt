package com.example.randomintegersrecyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class IntViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val textView : TextView
    init {
        textView = view.findViewById(R.id.textView2)
    }
}