package com.example.adi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class itemadapter(val tour: ArrayList<item>) : RecyclerView.Adapter<itemadapter.TourViewHolder>(){
    class TourViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tv_judul)
        val tvdesk: TextView = itemView.findViewById(R.id.tv_deskripsi)
        val imgview: ImageView = itemView.findViewById(R.id.img_gambar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemrowadapter, parent, false)
        return TourViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tour.size
    }

    override fun onBindViewHolder(holder: TourViewHolder, position: Int) {
        val (title, description, imageView) = tour[position]
        holder.tvTitle.text = title
        holder.tvdesk.text = description
        holder.imgview.setImageResource(imageView)
    }
}