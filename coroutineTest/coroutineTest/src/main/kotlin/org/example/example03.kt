//package org.example
//
//import kotlinx.coroutines.*
//
//fun main() =
//    runBlocking {
//        val way = GlobalScope.launch {
//            delay(3000L)
//            println("World!")
//        }
//        println("Hello,")
//        // join()메서드를 사용하면 위에 변수 job이 실행될때 까지 기다린다.
//        way.join()
//    }
