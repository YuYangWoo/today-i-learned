package com.kaonsoft.simple_mvvm_ex1.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kaonsoft.simple_mvvm_ex1.data.model.RoomsData

class ViewModelFactory(private val rooms: RoomsData) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel() as T
        }
        throw IllegalAccessException("Unknown")
    }
}