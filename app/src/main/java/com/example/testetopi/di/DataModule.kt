package com.example.testetopi.di

import com.example.testetopi.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    fun provideLocalDataSource(): Repository = Repository()
}