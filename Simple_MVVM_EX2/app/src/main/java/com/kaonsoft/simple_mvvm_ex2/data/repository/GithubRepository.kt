package com.kaonsoft.simple_mvvm_ex2.data.repository

import com.kaonsoft.simple_mvvm_ex2.data.api.GithubService

class GithubRepository {
    private val githubclient = GithubService.client

    suspend fun getRepositories(query: String) = githubclient.getRepositories(query)
}