package com.account.accountfigma

import android.app.Application
import com.account.accountfigma.di.DaggerAppComponent

class App : Application(){
    val component by lazy{
        DaggerAppComponent.builder().build()
    }
}