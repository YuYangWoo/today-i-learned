package org.example

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        repeat(1000) { i ->
            println("job: I'm sleeping $i ...")
            delay(500L)
        }
    }

    delay(1300L)
    println("main: I'm tired of waiting!")

   // cancle은 코루틴이 취소된다.
    job.cancel()
    job.join()

    println("main: Now i can quit.")
}

