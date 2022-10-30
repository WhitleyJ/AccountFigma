package com.account.accountfigma.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.account.accountfigma.data.UserListRepositoryImpl
import com.account.accountfigma.domain.model.User
import com.account.accountfigma.domain.usecases.GetUserListUseCase

class ListViewModel : ViewModel() {
    private val repository = UserListRepositoryImpl()
    private val getUsers = GetUserListUseCase(repository)

    var userList: MutableLiveData<List<User>> = MutableLiveData()

    fun getUserList() {
        userList.value = getUsers()
    }
    // не меняется состояние
    fun changeEnableState(user: User){
        val newUser = user.copy(enabled = !user.enabled)
        repository.editUser(newUser)
    }
}