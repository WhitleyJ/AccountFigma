package com.account.accountfigma.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.account.accountfigma.domain.usecases.EditUserUseCase
import com.account.accountfigma.domain.usecases.GetUserListUseCase
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val editUserUseCase: EditUserUseCase,
    private val getUserListUseCase: GetUserListUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass == ListViewModel::class.java){
            return ListViewModel(editUserUseCase,getUserListUseCase) as T
        }
        throw RuntimeException("viewModel with $modelClass not found")
    }
}