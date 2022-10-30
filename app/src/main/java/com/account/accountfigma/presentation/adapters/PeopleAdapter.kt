package com.account.accountfigma.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
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
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context
        ), parent, false)
        return PeopleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }


    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val item = listUser[position]
        with(holder.binding) {
            Glide.with(imageUser.context).load(item.image).centerCrop().placeholder(R.drawable.img)
                .into(imageUser)
            textName.text = item.name
            subscribesBtn.setOnClickListener {
                onClick?.invoke(item)
                subscribesBtn.text = if(item.enabled){
                    SUBSCRIBE.toString()
                }else{
                    UNSUBSCRIBE.toString()
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = listUser[position]
        return when (item.enabled){
            true->{SUBSCRIBE}
            false->{UNSUBSCRIBE}
        }
    }

    fun setData(newList: List<User>) {
        val callback = DiffCallback(listUser, newList)
        val result = DiffUtil.calculateDiff(callback)
        result.dispatchUpdatesTo(this)
        listUser = newList
    }

    companion object {
        private const val SUBSCRIBE = 1
        private const val UNSUBSCRIBE = 2
    }
}
