package com.account.accountfigma.presentation.adapters.people

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.account.accountfigma.R
import com.account.accountfigma.databinding.UserItemBinding
import com.account.accountfigma.domain.model.User
import com.bumptech.glide.Glide
import java.util.*

class PeopleAdapter : ListAdapter<User, PeopleAdapter.PeopleViewHolder>(ItemDiffCallBack()) {

    var onClick: ((User) -> Unit)? = null


    private var unfilteredlist = listOf<User>()

    class PeopleViewHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PeopleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val item = getItem(position)

        with(holder.binding) {

            Glide.with(imageUser.context).load(item.image).centerCrop()
                .placeholder(R.drawable.img_1)
                .into(imageUser)
            textName.text = item.name
            changeState(item)
            subscribesBtn.setOnClickListener {
                onClick?.invoke(item)
            }
            changeState(item)
        }
    }

    private fun UserItemBinding.changeState(user: User) {
        if (user.subscribed) {
            subscribesBtn.text = SUBSCRIBE
            subscribesBtn.setTextColor(ContextCompat.getColor(root.context, R.color.violet))
        } else {
            subscribesBtn.text = UNSUBSCRIBE
            subscribesBtn.setTextColor(ContextCompat.getColor(root.context, R.color.color_share))
        }
    }

    fun modifyList(list: List<User>) {
        unfilteredlist = list
        submitList(list)
    }

    //работает
    fun filter(query: CharSequence?) {
        val list = mutableListOf<User>()

        if (!query.isNullOrEmpty()) {
            list.addAll(unfilteredlist.filter {
                it.name.toLowerCase(Locale.getDefault()).contains(query.toString().toLowerCase(Locale.getDefault())) ||
                        it.name.toLowerCase(Locale.getDefault()).contains(query.toString().toLowerCase(Locale.getDefault())) })
        } else {
            list.addAll(unfilteredlist)
        }
        submitList(list)
    }

    companion object {
        private const val SUBSCRIBE = "Subscribe"
        private const val UNSUBSCRIBE = "Unsubscribe"
    }

}






