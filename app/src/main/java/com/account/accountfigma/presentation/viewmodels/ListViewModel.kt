package com.account.accountfigma.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.account.accountfigma.domain.model.User
import com.account.accountfigma.domain.usecases.EditUserUseCase
import com.account.accountfigma.domain.usecases.GetUserListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val editUserUseCase: EditUserUseCase,
    private val getUserListUseCase: GetUserListUseCase
) : ViewModel() {

    val userList = getUserListUseCase()

    fun changeEnableState(user: User) {
        val newItem = user.copy(subscribed = !user.subscribed)
        editUserUseCase.invoke(newItem)
    }
}