package com.example.testetopi.di

import com.example.testetopi.repository.Repository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DataModule {

    @Singleton
    @Binds
    abstract fun provideLocalDataSource(repository: Repository): Repository
}