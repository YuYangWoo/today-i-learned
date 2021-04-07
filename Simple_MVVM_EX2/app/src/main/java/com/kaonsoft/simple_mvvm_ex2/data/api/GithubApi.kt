package com.kaonsoft.simple_mvvm_ex2.data.api

import com.kaonsoft.simple_mvvm_ex2.data.model.GithubRepositoriesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {
    @GET("search/repositories")
    suspend fun getRepositories(@Query("q") query: String ): Response<GithubRepositoriesModel>
}