package com.juliasd.tinytravel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.juliasd.tinytravel.databinding.ItemTinyhouseBinding
import com.juliasd.tinytravel.databinding.ListItemBinding
import com.squareup.picasso.Picasso

class TinyAdapter(val tinyhouse:List<TinyHouse>):RecyclerView.Adapter<TinyAdapter.TinyHolder>() {



    class TinyHolder(private val itemBinding: ItemTinyhouseBinding):RecyclerView.ViewHolder(itemBinding.root) {

        fun render(tinyhouse:TinyHouse) {
            itemBinding.tvCity.text = tinyhouse.city
            itemBinding.tvDescription.text = tinyhouse.description
            itemBinding.tvPriceDay.text = tinyhouse.priceDay
            Picasso.get().load(tinyhouse.image).into(itemBinding.ivTinyHouse)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TinyHolder {

        val itemBinding = ItemTinyhouseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TinyHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: TinyHolder, position: Int) {
        holder.render(tinyhouse[position])
    }

    override fun getItemCount(): Int = tinyhouse.size

}