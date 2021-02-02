package org.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import java.lang.Exception

fun main() = runBlocking {
    try {
        withTimeout(1300L) {
            repeat(1000) { i ->
                println("I'm sleeping $i...")
                delay(500L)
            }
        }
    }
    catch (e:Exception) {
        println("끝났다.")
    }
}
/*
Cancel() 할 수 있다. 코루틴에서 협조적인 방법을 제공해줘야함.
방법은 2개
suspend function사용과 isActive를 체크해서 캔슬해준다.
Timeout withTimeout과 withTimeoutOrNull 
 */