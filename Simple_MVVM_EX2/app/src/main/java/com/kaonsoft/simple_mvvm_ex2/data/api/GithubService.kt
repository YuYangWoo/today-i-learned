package com.kaonsoft.simple_mvvm_ex2.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GithubService {
    const val GITHUB_URL = "http://api.github.com"

    val client = BaseService.getClient(GITHUB_URL).create(GithubApi::class.java)
}