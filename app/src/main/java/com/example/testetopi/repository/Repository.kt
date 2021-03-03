package com.example.testetopi.repository

import com.example.testetopi.models.DataResponse
import com.example.testetopi.models.RepositoryVO
import com.example.testetopi.repository.api.RepoApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository() {

    private val API_URL = "https://api.github.com/search/"
    val repoAPI: RepoApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        repoAPI = retrofit.create(RepoApi::class.java)
    }

    fun getRepositorieslList(
        q: String,
        sort: String,
        page: String,
        onSucess: (RepositoriesList: List<RepositoryVO>) -> Unit,
        onError: () -> Unit
    ){
        repoAPI.getRepoList(q, sort, page)
            .enqueue(object : Callback<DataResponse> {
                override fun onResponse(
                    call: Call<DataResponse>,
                    response: Response<DataResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            onSucess.invoke(responseBody.repositoriesList)
                        } else {
                            onError()
                        }
                    } else {
                        onError()
                    }
                }
                override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                    onError()
                }
            })
    }
}