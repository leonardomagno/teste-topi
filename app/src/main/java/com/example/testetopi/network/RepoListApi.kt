package com.example.testetopi.network

import com.example.testetopi.models.DataResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RepoListApi {
    @GET("repositories")
    fun getRepoList(
        @Query("q") q: String, // language:Java
        @Query("sort") sort: String, // stars
        @Query("page") page: String // 1
    ): retrofit2.Call<DataResponse>
}