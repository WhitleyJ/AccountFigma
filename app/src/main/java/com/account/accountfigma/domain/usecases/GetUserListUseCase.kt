package com.account.accountfigma.domain.usecases

import com.account.accountfigma.domain.model.User
import com.account.accountfigma.domain.repository.UserRepository

class GetUserListUseCase(private val repository: UserRepository) {
    operator fun invoke(): List<User> {
        return repository.getUserList()
    }
}