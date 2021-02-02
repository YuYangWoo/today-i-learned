package org.example

import kotlinx.coroutines.*
import java.lang.Exception

// 코루틴이 취소되려면 협조적이여야한다.
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        try{
            var nextPrintTime = startTime
            var i = 0
            while(i < 5) {
                if (System.currentTimeMillis() >= nextPrintTime) {
//                delay(1L)
                    yield() // exception을 던져서 종료시킨다.
                    println("job: I'm sleeping ${i++}...")
                    nextPrintTime += 500L
        }

            }
        }
        catch (e:Exception) {
            kotlin.io.println("Exception ${e}...")
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: Now I can quit.")
}