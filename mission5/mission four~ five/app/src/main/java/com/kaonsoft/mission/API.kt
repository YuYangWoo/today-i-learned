package com.kaonsoft.mission

import retrofit2.Call
import retrofit2.http.*

interface API {
    @POST("/info")
    fun infoRequest(@Body infoRequest: InformationRequest): Call<InformationResponse>

    @POST("/infoHash")
    fun infoHashRequest(@Body infoRequest: HashMap<String, Any>): Call<InformationResponse>

    @FormUrlEncoded
    @POST("/infoEncoded")
    fun infoUrlRequest(@FieldMap infoRequest: HashMap<String, Any>): Call<InformationResponse>

    @GET("/mission")
    fun get(@QueryMap infoRequest: HashMap<String, Any>): Call<InformationResponse>
}