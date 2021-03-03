package com.example.testetopi.repository.api

import com.example.testetopi.models.RepositoryVO
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface RepoApi {

    @GET("users/{q}/{sort}/{page}")
    fun getUser(
        @Path("q") q: String,
        @Path("sort") sort: String,
        @Path("page") page: String
    ): Flowable<RepositoryVO?>?
}