package com.account.accountfigma.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.account.accountfigma.databinding.ItemPhotoBinding

class ProfileAdapter : RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {

    val listPhoto = listOf(1, 2, 3, 4)

    class ProfileViewHolder(binding: ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemPhotoBinding.inflate(layoutInflater, parent, false)
        return ProfileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return listPhoto.size
    }
}