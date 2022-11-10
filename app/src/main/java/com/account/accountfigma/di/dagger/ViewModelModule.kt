package com.account.accountfigma.di.dagger

import androidx.lifecycle.ViewModel
import com.account.accountfigma.presentation.viewmodels.ListViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap

//@Module
//interface ViewModelModule {
//
//    @IntoMap
//    @ViewModelKey(ListViewModel::class)
//    @Binds
//    fun bindListViewModel(impl: ListViewModel): ViewModel
//}