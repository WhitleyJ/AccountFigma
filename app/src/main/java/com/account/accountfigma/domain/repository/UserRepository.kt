package com.account.accountfigma.domain.repository

import androidx.lifecycle.LiveData
import com.account.accountfigma.domain.model.User

interface UserRepository {

    fun getUserList(): LiveData<List<User>>

    fun getUser(userId: Int): User

    fun editUser(user: User)
}