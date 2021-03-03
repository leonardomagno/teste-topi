package com.example.testetopi.di

import com.example.testetopi.ui.repositorieslist.RepositoriesListActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun provideRepositoryActivity(): RepositoriesListActivity
}