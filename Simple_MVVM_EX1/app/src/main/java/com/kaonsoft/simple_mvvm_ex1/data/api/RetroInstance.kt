package com.kaonsoft.simple_mvvm_ex1.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroInstance {
        val baseUrl = "http://3.34.174.56:8080"

        fun getRetroInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
        }
}