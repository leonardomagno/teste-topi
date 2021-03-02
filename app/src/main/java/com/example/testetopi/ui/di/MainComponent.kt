package com.example.testetopi.ui.di

import com.example.testetopi.ui.repositorieslist.RepositoriesListActivity
import dagger.Subcomponent

@Subcomponent(modules = [MainModule::class])
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

    fun inject (repositoriesListActivity: RepositoriesListActivity)
}