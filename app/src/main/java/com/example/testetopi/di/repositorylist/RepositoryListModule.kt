package com.example.testetopi.di.repositorylist

import com.example.testetopi.repository.api.RepoApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RepositoryListModule {

    @RepositoriesListScope
    @Provides
    fun provideRepoApi(retrofit: Retrofit): RepoApi? {
        return retrofit.create(RepoApi::class.java)
    }
}