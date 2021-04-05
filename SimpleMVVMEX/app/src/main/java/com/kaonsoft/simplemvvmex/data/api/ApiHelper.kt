package com.kaonsoft.simplemvvmex.data.api

class ApiHelper(private val apiService: ApiService) {
    suspend fun getUsers() = apiService.getUsers()
}