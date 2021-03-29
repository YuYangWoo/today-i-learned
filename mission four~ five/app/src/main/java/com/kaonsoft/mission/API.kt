package com.kaonsoft.mission

import retrofit2.Call
import retrofit2.http.*

interface API {

    @GET("/mission")
    fun get(name: String): Call<String>

    @POST("/info")
    fun infoRequest(@Body infoRequest: InformationRequest): Call<InformationResponse>

    @POST("/infoHash")
    fun infoHashRequest(@Body infoRequest: HashMap<String, Any>): Call<InformationResponse>

    @FormUrlEncoded
    @POST("/infoEncoded")
    fun infoUrlRequest(@FieldMap infoRequest: HashMap<String, Any>): Call<InformationResponse>

}