package com.example.testetopi.repository.api

import com.example.testetopi.models.DataResponse
import com.example.testetopi.models.RepositoryVO
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RepoApi {

    @GET("repositories")
    fun getRepoList(
        @Query("q") q: String, // language:Java
        @Query("sort") sort: String, // stars
        @Query("page") page: String // 1
    ): retrofit2.Call<DataResponse>
}