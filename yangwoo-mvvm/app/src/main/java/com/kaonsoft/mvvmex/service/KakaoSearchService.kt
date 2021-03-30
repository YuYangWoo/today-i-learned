package com.kaonsoft.mvvmex.service

import com.kaonsoft.mvvmex.data.ImageSearchResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface KakaoSearchService {
    interface KakaoSearchService {
        @GET("/v2/search/image")
        fun searchImage(
            @Header("Authorization") auth:String,
            @Query("query") query:String,
            @Query("sort") sort:String,
            @Query("page") page:Int,
            @Query("size") size:Int
        ): Single<ImageSearchResponse>
    }
}