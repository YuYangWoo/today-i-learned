package com.kaonsoft.simplemvvmex.data.repository

import com.kaonsoft.simplemvvmex.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getUsers() = apiHelper.getUsers()
}