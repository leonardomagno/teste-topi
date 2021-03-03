package com.example.testetopi.di

import com.example.testetopi.di.repositorylist.RepositoryListModule
import com.example.testetopi.ui.repositorieslist.RepositoriesListActivity
import com.example.testetopi.ui.repositorieslist.RepositoriesListViewModel
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector (modules = [
        RepositoriesListViewModel::class,
        RepositoryListModule::class])
    abstract fun provideRepositoryActivity(): RepositoriesListActivity
}