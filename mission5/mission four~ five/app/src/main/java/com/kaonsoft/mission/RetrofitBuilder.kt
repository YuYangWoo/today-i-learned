package com.kaonsoft.mission

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitBuilder {
    var api: API
    init {
        var retrofit = Retrofit.Builder().baseUrl("http://192.168.1.58:8080").addConverterFactory(
            GsonConverterFactory.create()).build()
        api = retrofit.create(API::class.java)
    }
}