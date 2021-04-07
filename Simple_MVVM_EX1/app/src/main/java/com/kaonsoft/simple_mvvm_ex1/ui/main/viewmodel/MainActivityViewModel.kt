package com.kaonsoft.simple_mvvm_ex1.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaonsoft.simple_mvvm_ex1.data.model.RoomsData
import com.kaonsoft.simple_mvvm_ex1.data.api.RetroInstance
import com.kaonsoft.simple_mvvm_ex1.data.api.RetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    var roomsData: MutableLiveData<RoomsData> = MutableLiveData()

    fun apiRooms(college: HashMap<String, Any>) {
        viewModelScope.launch(Dispatchers.IO) {
            val response =  RetroInstance.client.getRooms(college)
            roomsData.postValue(response.body())
        }
    }


}