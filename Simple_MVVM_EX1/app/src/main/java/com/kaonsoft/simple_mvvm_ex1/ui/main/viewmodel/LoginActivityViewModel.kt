package com.kaonsoft.simple_mvvm_ex1.ui.main.viewmodel

import android.app.ProgressDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaonsoft.simple_mvvm_ex1.data.model.Information
import com.kaonsoft.simple_mvvm_ex1.data.repository.LoginRepository
import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

class LoginActivityViewModel(private val loginRepository: LoginRepository) : ViewModel() {
    private val _loginData = MutableLiveData<Information>()
    val loginData = _loginData

    fun loginRepository(data: HashMap<String, Any>) {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            loginRepository.login(data).let {
                    _loginData.postValue(it)
            }
        }
    }

    private val coroutineExceptionHandler = CoroutineExceptionHandler{ _, t ->
        t.printStackTrace()


        Log.d("TAG", t.toString())
    }

}