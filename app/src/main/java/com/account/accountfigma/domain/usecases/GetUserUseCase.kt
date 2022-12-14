package com.account.accountfigma.domain.usecases

import com.account.accountfigma.domain.model.User
import com.account.accountfigma.domain.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val repository: UserRepository) {
    operator fun invoke(userId: Int): User {
        return repository.getUser(userId)
    }
}