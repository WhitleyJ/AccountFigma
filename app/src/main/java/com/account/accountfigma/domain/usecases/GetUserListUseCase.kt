package com.account.accountfigma.domain.usecases

import androidx.lifecycle.LiveData
import com.account.accountfigma.domain.model.User
import com.account.accountfigma.domain.repository.UserRepository
import javax.inject.Inject

class GetUserListUseCase @Inject constructor(private val repository: UserRepository) {
    fun getSubscribers(): LiveData<List<User>> {
        return repository.getUserList()
    }
}