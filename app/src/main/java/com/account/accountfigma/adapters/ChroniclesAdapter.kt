package com.account.accountfigma.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.account.accountfigma.databinding.ItemChroniclesBinding

class ChroniclesAdapter : RecyclerView.Adapter<ChroniclesAdapter.ChroniclesViewHolder>() {
    private var listChronicles = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)

    class ChroniclesViewHolder(binding: ItemChroniclesBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChroniclesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemChroniclesBinding.inflate(layoutInflater, parent, false)
        return ChroniclesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChroniclesViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return listChronicles.size
    }
}