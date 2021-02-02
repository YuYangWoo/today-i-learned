package org.example
import kotlinx.coroutines.*

fun main(args: Array<String>) {

    // 코루틴 빌더 launch는 스코프가 있어야한다.
    // 프로그램 전체를 가진 lifeTime
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    println("Hello,")
    Thread.sleep(2000L)
}

