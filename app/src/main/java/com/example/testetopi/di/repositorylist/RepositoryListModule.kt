package com.example.testetopi.di.repositorylist

import com.example.testetopi.network.RepoListApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RepositoryListModule {

    @RepositoriesListScope
    @Provides
    fun provideAuthApi(retrofit: Retrofit): RepoListApi? {
        return retrofit.create(RepoListApi::class.java)
    }
}