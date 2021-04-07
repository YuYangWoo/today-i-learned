package com.kaonsoft.simple_mvvm_ex1.util

sealed class Output<out T : Any> {
    data class Success<out T : Any>(val output : T) : Output<T>()
    data class Error(val exception: Exception) : Output<Nothing>()
}

