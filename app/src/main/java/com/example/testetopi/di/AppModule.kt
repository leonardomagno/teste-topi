package com.example.testetopi.di

import com.example.testetopi.base.Constants
import com.example.testetopi.repository.Repository
import dagger.Module
import dagger.Provides
import io.reactivex.internal.schedulers.RxThreadFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Esse módulo contem as dependências básicas do app e que sempre serão utilizadas
 */
@Module
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit? {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideLocalDataSource(): Repository = Repository()
}