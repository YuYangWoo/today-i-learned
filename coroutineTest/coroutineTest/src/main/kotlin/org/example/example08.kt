package org.example

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
     runBlocking {

        launch {
            repeat(5) { i ->
                println("Coroutine A, $i")
            }
        }

        launch {
            repeat(5) { i ->
                println("Coroutine B, $i")
            }

        }
         println("coroutine outer")
    }

}

fun <T>println(msg: T) {
    kotlin.io.println("$msg [${Thread.currentThread().name}]")
}