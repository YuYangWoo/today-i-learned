package org.example

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

// Composing Suspending Functions
fun main() = runBlocking {
    val time = measureTimeMillis {
        // async를 사용하면 의존성이 없어지고 둘다 바로 시작.  그리고 await을 사용해 값을 반환한다.
        val one = async {
            doSomethingUsefulOne()
        }
        print("one")
//        val oneRes = one.await()

        val two = async {
            doSomethingUsefulTwo()
        }
        print("two")

        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}

// suspend fun doSomethingUsefulOne(): Int {
//    delay(1000L)
//    return 13
//}
//
// suspend fun doSomethingUsefulTwo(): Int {
//    delay(1000L)
//    return 29
//}

