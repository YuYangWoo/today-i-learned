package com.kaonsoft.simple_koin_ex1

import androidx.lifecycle.ViewModel

class MainViewModel(private val repo: MainRepository) : ViewModel() {
    fun sayHello() = "${repo.emitData()} from $this"
}