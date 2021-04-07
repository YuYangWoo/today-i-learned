package com.kaonsoft.simple_mvvm_ex1.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BaseRetro {
    fun getClient(baseUrl: String): Retrofit {
        return Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .client(OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}