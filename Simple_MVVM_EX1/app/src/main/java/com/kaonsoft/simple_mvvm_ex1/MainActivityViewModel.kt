package com.kaonsoft.simple_mvvm_ex1

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaonsoft.simple_mvvm_ex1.data.RoomsData
import com.kaonsoft.simple_mvvm_ex1.network.RetroInstance
import com.kaonsoft.simple_mvvm_ex1.network.RetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    var imageLiveData: MutableLiveData<Bitmap> = MutableLiveData()
    var roomsData: MutableLiveData<RoomsData> = MutableLiveData()

    fun getImageObserver():MutableLiveData<Bitmap> {
        return imageLiveData
    }

    fun makeApiCall(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
          val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
           val response = retroInstance.getImageFromUrl(query)
            val bytes = response.bytes()
            val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
            imageLiveData.postValue(bitmap)
        }
    }

    fun apiRooms(college: HashMap<String, Any>) {
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)

            val response = retroInstance.getRooms(college)
            Log.d("TAG", response.body().toString())
            roomsData.postValue(response.body())
        }
    }

    @JvmName("getRoomsData1")
    fun getRoomsData(): MutableLiveData<RoomsData> {
        return roomsData
    }
}