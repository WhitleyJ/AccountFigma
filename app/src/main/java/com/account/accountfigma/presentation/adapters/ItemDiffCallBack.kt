package com.account.accountfigma.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.account.accountfigma.domain.model.User

class ItemDiffCallBack : DiffUtil.ItemCallback<User>() {

    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}