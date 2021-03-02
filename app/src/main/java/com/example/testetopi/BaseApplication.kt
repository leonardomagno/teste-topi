package com.example.testetopi

import android.app.Application
import com.example.testetopi.di.ApplicationComponent
import com.example.testetopi.di.DaggerApplicationComponent

class BaseApplication: Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerApplicationComponent.factory().create(this)
    }
}