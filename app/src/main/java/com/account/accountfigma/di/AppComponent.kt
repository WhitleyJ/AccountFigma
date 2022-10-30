package com.account.accountfigma.di

import com.account.accountfigma.presentation.fragments.AccountFragment
import com.account.accountfigma.presentation.fragments.PeopleFragment
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class])
interface AppComponent {

    fun inject(fragment: PeopleFragment)

    @Component.Builder
    interface Factory {
        fun build(
        ): AppComponent
    }
}