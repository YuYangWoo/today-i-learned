package com.kaonsoft.simple_mvvm_ex1.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroInstance {
    val baseUrl = "http://3.34.174.56:8080"
    val client = BaseRetro.getClient(baseUrl).create(RetroService::class.java)
}