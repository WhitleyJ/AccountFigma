package com.account.accountfigma.domain.repository

import com.account.accountfigma.domain.model.User

interface UserRepository {

    fun getUserList(): List<User>

    fun getUser(id: Int): User
}