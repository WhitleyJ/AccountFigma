package com.account.accountfigma.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.account.accountfigma.domain.model.User
import com.account.accountfigma.domain.usecases.EditUserUseCase
import com.account.accountfigma.domain.usecases.GetUserListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val editUserUseCase: EditUserUseCase,
    private val getUserListUseCase: GetUserListUseCase,
) : ViewModel() {

    val userList = getUserListUseCase.getSubscribers()

    private var query = MutableLiveData<String>()

    fun setQuery(queryData: String) {
        query.value = queryData
    }

    fun getQuery(): LiveData<String> {
        return query
    }

    fun changeEnableState(user: User) {
        val newItem = user.copy(subscribed = !user.subscribed)
        editUserUseCase.editUsers(newItem)
    }
}

