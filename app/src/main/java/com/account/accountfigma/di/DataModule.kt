package com.account.accountfigma.di

import com.account.accountfigma.data.UserListRepositoryImpl
import com.account.accountfigma.domain.repository.UserRepository
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindRepository(impl: UserListRepositoryImpl): UserRepository
}