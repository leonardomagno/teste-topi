package com.example.testetopi.di

import com.example.testetopi.repository.Repository
import dagger.Module
import dagger.Provides

/**
 * Esse módulo contem as dependências básicas do app e que sempre serão utilizadas
 */
@Module
class AppModule {

    @Provides
    fun provideLocalDataSource(): Repository = Repository()
}