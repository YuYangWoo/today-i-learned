package org.example

import kotlinx.coroutines.*
import java.lang.Exception

// isActive는 exception을 던지지 않는다.
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        try{
            var nextPrintTime = startTime
            var i = 0
            println("isActive $isActive")
            while(isActive) {
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++}...")
                    nextPrintTime += 500L
                }

            }
            println("isActive $isActive")

        }
        catch (e: Exception) {
            kotlin.io.println("Exception ${e}...")
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: Now I can quit.")
}