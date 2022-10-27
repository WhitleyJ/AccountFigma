package com.account.accountfigma.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.account.accountfigma.databinding.ItemPhoto2Binding

class MomentsAdapter : RecyclerView.Adapter<MomentsAdapter.MomentViewHolder>() {

    private var listMoments = listOf(1, 2, 3, 4, 5, 6)

    class MomentViewHolder(binding: ItemPhoto2Binding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MomentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemPhoto2Binding.inflate(layoutInflater, parent, false)
        return MomentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MomentViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return listMoments.size
    }
}