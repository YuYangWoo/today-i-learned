package com.kaonsoft.simplemvvmex.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.kaonsoft.simplemvvmex.data.repository.MainRepository
import com.kaonsoft.simplemvvmex.ui.utils.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))
        }
        catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error Occurred!"))
        }
    }
}