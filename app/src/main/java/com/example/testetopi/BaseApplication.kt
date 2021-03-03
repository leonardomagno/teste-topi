package com.example.testetopi

import android.app.Application
import com.example.testetopi.di.ApplicationComponent
import com.example.testetopi.di.DaggerApplicationComponent
import dagger.android.AndroidInjection.inject
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApplication: DaggerApplication() {

    lateinit var appComponent: ApplicationComponent

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