package com.example.dayvi_uas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ResepAdapter(
private  val context : Context,
private  val resep : List<DataResep>,
private val listener : (DataResep) -> Unit)
: RecyclerView.Adapter<ResepAdapter.ResepViewHolder>() {

    class ResepViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image = view.findViewById<ImageView>(R.id. v_img)
        private val name = view.findViewById<TextView>(R.id.v_title)


        fun bindView(resep: DataResep, listener: (DataResep) -> Unit) {
            image.setImageResource(resep.img)
            name.text = resep.title
            itemView.setOnClickListener { listener(resep) }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResepViewHolder =
        ResepViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

    override fun getItemCount(): Int = resep.size

    override fun onBindViewHolder(holder: ResepViewHolder, position: Int) {
        holder.bindView(resep[position], listener)
    }
}

