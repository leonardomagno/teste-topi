package com.example.testetopi.di

import com.example.testetopi.repository.Repository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RepositoryModule {

    @Provides
    fun provideLocalDataSource(retrofit: Retrofit): Repository = Repository(retrofit)
}