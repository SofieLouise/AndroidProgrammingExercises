package com.example.randomintegersrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar


class IntAdapter(private val dataSet: MutableList<Int>) : RecyclerView.Adapter<IntViewHolder>(){
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): IntViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item, viewGroup, false)
        return IntViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: IntViewHolder, position: Int) {
        viewHolder.textView.text = dataSet[position].toString()
        viewHolder.textView.setOnClickListener{deleteItem(position, viewHolder.itemView)}
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    private fun deleteItem(index: Int, view: View){
        val temp = dataSet[index]
        val removeMessage = String.format("Removing item %s at index %s", temp, index)
        val snack = Snackbar.make(view, removeMessage, Snackbar.LENGTH_LONG)
        snack.setAction("Undo") {
            dataSet.add(index, temp)
            notifyDataSetChanged()
        }
        snack.show()
        dataSet.removeAt(index)
        notifyDataSetChanged()
    }

}