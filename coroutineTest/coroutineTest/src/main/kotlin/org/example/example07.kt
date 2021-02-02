//package org.example
//
//import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.runBlocking
//
//fun main() = runBlocking {
//    GlobalScope.launch {
//        repeat(1000) { i ->
//            println("I'm sleepping $i ...")
//            delay(500L)
//        }
//    }
//
//    delay(1300L)
//}
///*
//정리
//Coroutine builder - launch, runBlocking
//Scope -
//Suspend function
//Structured concurrency
// */