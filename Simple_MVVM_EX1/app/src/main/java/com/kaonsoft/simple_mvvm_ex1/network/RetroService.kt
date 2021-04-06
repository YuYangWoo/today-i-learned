package com.kaonsoft.simple_mvvm_ex1.network

import com.kaonsoft.simple_mvvm_ex1.data.RoomsData
import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface RetroService {

    @GET("33503405")
    suspend fun getImageFromUrl(@Query("v") query:String): ResponseBody

    @FormUrlEncoded
    @POST("/rooms")
    suspend fun getRooms(@FieldMap college: HashMap<String, Any>): Response<RoomsData>
}