package com.kaonsoft.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    var counter: MutableLiveData<Int> = MutableLiveData()

    init {
        counter.value = 0
    }

    fun increase() {
        counter.value = counter.value!! + 1
    }

    fun decrease() {
        counter.value = counter.value!! - 1
    }
}