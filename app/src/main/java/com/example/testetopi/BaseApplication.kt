package com.example.testetopi

import com.example.testetopi.di.AppComponent
import com.example.testetopi.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApplication: DaggerApplication() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
            .apply {
                inject(this@BaseApplication)
            }


}