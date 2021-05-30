package com.example.bottomsheetpractice

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DummyAdapter(var array: Array<String>, val itemClick: (String) -> Unit) :
    RecyclerView.Adapter<DummyAdapter.DummyViewHolder>() {


    class DummyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textTV: TextView = itemView.findViewById(R.id.textView3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DummyViewHolder {
        return DummyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DummyViewHolder, position: Int) {
        val current = array[position]
        holder.textTV.text = current
        holder.itemView.setOnClickListener {
            Log.d("TAG", "onBindViewHolder: onCLick")
            itemClick(current)
        }
    }

    override fun getItemCount(): Int = array.size

}
