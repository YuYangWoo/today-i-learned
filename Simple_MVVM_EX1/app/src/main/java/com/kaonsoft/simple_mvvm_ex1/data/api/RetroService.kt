package com.kaonsoft.simple_mvvm_ex1.data.api

import com.kaonsoft.simple_mvvm_ex1.data.model.Information
import com.kaonsoft.simple_mvvm_ex1.data.model.RoomsData
import retrofit2.Response
import retrofit2.http.*

interface RetroService {

    @FormUrlEncoded
    @POST("/rooms")
    suspend fun getRooms(@FieldMap college: HashMap<String, Any>): Response<RoomsData>

    @FormUrlEncoded
    @POST("/account/login")
    suspend fun requestLogin(@FieldMap info: HashMap<String, Any>): Response<Information>
}