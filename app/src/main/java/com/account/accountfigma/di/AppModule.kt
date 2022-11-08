package com.account.accountfigma.di

import com.account.accountfigma.data.UserListRepositoryImpl
import com.account.accountfigma.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun bindRepository(impl: UserListRepositoryImpl): UserRepository {
        return impl
    }


}