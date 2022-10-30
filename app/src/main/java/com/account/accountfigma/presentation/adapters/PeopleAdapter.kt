package com.account.accountfigma.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.account.accountfigma.R
import com.account.accountfigma.databinding.UserItemBinding
import com.account.accountfigma.domain.model.User
import com.bumptech.glide.Glide

class PeopleAdapter : RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>() {

    private var listUser = emptyList<User>()

    var onClick: ((User) -> Unit)? = null

    class PeopleViewHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PeopleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val item = listUser[position]
        with(holder.binding) {
            Glide.with(imageUser.context).load(item.image).centerCrop().placeholder(R.drawable.img)
                .into(imageUser)
            textName.text = item.name
            changeState(item)
            subscribesBtn.setOnClickListener {
                onClick?.invoke(item)
                changeState(item)
            }
        }
    }

    private fun UserItemBinding.changeState(item: User) {
        if (item.subscribed) {
            subscribesBtn.text = SUBSCRIBE
            subscribesBtn.setTextColor(ContextCompat.getColor(root.context, R.color.violet))
        } else {
            subscribesBtn.text = UNSUBSCRIBE
            subscribesBtn.setTextColor(ContextCompat.getColor(root.context, R.color.color_share))
        }
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    fun setData(newList: List<User>) {
        val callback = DiffCallback(listUser, newList)
        val result = DiffUtil.calculateDiff(callback)
        result.dispatchUpdatesTo(this)
        listUser = newList
    }

    companion object {
        private const val SUBSCRIBE = "Subscribe"
        private const val UNSUBSCRIBE = "Unsubscribe"
    }

}
