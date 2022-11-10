package com.account.accountfigma.di.hilt

import com.account.accountfigma.data.UserListRepositoryImpl
import com.account.accountfigma.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @Singleton
    @Binds
    fun bindRepository(impl: UserListRepositoryImpl): UserRepository
}