package com.kaonsoft.simplemvvmex.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kaonsoft.simplemvvmex.data.api.ApiHelper
import com.kaonsoft.simplemvvmex.data.repository.MainRepository
import com.kaonsoft.simplemvvmex.ui.main.viewmodel.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalAccessException("Unknown class name")
    }
}