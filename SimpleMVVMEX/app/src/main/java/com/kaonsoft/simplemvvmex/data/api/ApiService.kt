package com.kaonsoft.simplemvvmex.data.api

import com.kaonsoft.simplemvvmex.data.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}