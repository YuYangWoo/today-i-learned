package com.kaonsoft.simple_mvvm_ex1.data.repository

import androidx.lifecycle.MutableLiveData
import com.kaonsoft.simple_mvvm_ex1.data.api.RetroInstance
import com.kaonsoft.simple_mvvm_ex1.data.model.Information

class LoginRepository {
    private val loginClient = RetroInstance.client

    suspend fun login(data: HashMap<String, Any>) = loginClient.requestLogin(data)
}