package com.kaonsoft.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitTwoBuilder {
    var api: API

    init {
        var retrofit = Retrofit
            .Builder()
            .baseUrl("http://vpn.mobidoo.co.kr:20071")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(API::class.java)
    }
}