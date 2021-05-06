package com.mi.googleassitantsample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mi.googleassitantsample.databinding.ItemRecyclerTripBinding

class MyTripsAdapter constructor(private var items: MutableList<TripModal>) :
    RecyclerView.Adapter<MyTripsAdapter.MyTripsViewHolder>() {
    inner class MyTripsViewHolder(private val binding: ItemRecyclerTripBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(pos: Int) {
            val trip = items[pos]
            binding.tvTripName.text = trip.tripAddress
            binding.tvTripDate.text = trip.tripDate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyTripsViewHolder {
        return MyTripsViewHolder(
            ItemRecyclerTripBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyTripsViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(data: MutableList<TripModal>) {
        items = data
        notifyDataSetChanged()
    }
}