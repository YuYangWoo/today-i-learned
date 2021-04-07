package com.kaonsoft.simple_mvvm_ex1.data.repository

import com.kaonsoft.simple_mvvm_ex1.data.api.RetroInstance
import com.kaonsoft.simple_mvvm_ex1.data.api.RetroService
import com.kaonsoft.simple_mvvm_ex1.data.model.RoomsData
import retrofit2.Response

class Repository(private val college: HashMap<String, Any>) {

    fun getRooms(): Response<RoomsData> {

        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        return retroInstance.getRooms(college)
    }
}