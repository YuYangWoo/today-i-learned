//package org.example
//
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.runBlocking
//
//fun main() = runBlocking {
//
//    launch {
//       myWorld()
//    }
//    println("Hello,")
//}
//// suspend function은 suspend fuction이나 코루틴 안에서만 호출될 수 있다.
//suspend fun myWorld() {
//    delay(1000L)
//    println("World!")
//}