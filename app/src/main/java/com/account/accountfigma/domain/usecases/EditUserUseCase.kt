package com.account.accountfigma.domain.usecases

import com.account.accountfigma.domain.model.User
import com.account.accountfigma.domain.repository.UserRepository
import javax.inject.Inject

class EditUserUseCase @Inject constructor(private val repository: UserRepository) {

    operator fun invoke(user: User) {
        repository.editUser(user)
    }
}