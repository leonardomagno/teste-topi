package com.example.testetopi.di

import com.example.testetopi.ui.repositorieslist.RepositoriesListActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {

    @Provides
    fun provideRepositoryActivity() = RepositoriesListActivity()
}