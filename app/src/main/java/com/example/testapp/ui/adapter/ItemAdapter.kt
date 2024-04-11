package com.example.testapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testapp.data.Country
import com.example.testapp.databinding.ItemBinding

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(), Filterable {

    private var items: List<Country> = listOf()
    var itemsFiltered: List<Country> = listOf()

    inner class ItemViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Country) {
            binding.tvCommon.text = item.name.common
            binding.tvOfficial.text = item.name.official
            Glide.with(binding.root)
                .load(item.flags.png)
                .into(binding.flag)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemsFiltered[position])
    }

    override fun getItemCount() = itemsFiltered.size

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString()
                itemsFiltered = if (charString.isEmpty()) {
                    items
                } else {
                    items.filter { it.name.common.toLowerCase().contains(charString.toLowerCase()) }
                }
                return FilterResults().apply { values = itemsFiltered }
            }

            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
                itemsFiltered = filterResults.values as List<Country>
                notifyDataSetChanged()
            }
        }
    }

    fun submitList(newItems: List<Country>) {
        items = newItems
        itemsFiltered = newItems
        notifyDataSetChanged()
    }
}