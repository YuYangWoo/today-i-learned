package com.kaonsoft.mvvmex.service

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    var api: KakaoSearchService
    init {
        var retrofit = Retrofit.Builder().baseUrl("https://dapi.kakao.com")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).build()
        api = retrofit.create(KakaoSearchService::class.java)
    }
}