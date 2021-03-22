package com.kaonsoft.retrofit

import com.cookandroid.gachon_study_room.data.room.Room
import com.cookandroid.gachon_study_room.data.room.RoomsData
import com.kaonsoft.mobidoo_sdk_test.response.InitializeResponse
import com.kaonsoft.retrofit.data.Account
import com.kaonsoft.retrofit.data.LoginInformation
import com.kaonsoft.retrofit.request.InitializeRequest
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*

interface API {
    @FormUrlEncoded
    @POST("/rooms")
    fun post(@FieldMap param: HashMap<String, String>): Call<RoomsData>


    @POST("/api/v1/init")
    fun initRequest(@Body initializeRequest: InitializeRequest): Call<InitializeResponse>

}