package com.feriariyani.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.feriariyani.recyclerview.databinding.ListItemPemainBinding
import com.feriariyani.recyclerview.model.Pemain

class AdapterTeamBola(private val context: Context,
                      private var data : List<Pemain>?,
                      private val ItemClick : OnClickListener)
                    : RecyclerView.Adapter<AdapterTeamBola.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemPemainBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)
        holder.foto.setImageResource(item?.foto ?:0)
        holder.nama.text = item?.nama

        holder.itemView.setOnClickListener {
            ItemClick.detailData(item)
        }
    }

    override fun getItemCount(): Int = data?.size ?: 0

    inner class ViewHolder(val binding: ListItemPemainBinding) : RecyclerView.ViewHolder(binding.root) {
        var foto = binding.image
        var nama = binding.txtnama

    }

    interface OnClickListener {
        fun detailData(item : Pemain?)
    }

}