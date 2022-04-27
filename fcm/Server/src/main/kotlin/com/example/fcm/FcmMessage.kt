package com.example.fcm

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Getter
import org.apache.logging.log4j.message.Message
import java.io.Serializable
import javax.management.Notification

@Builder
@AllArgsConstructor
@Getter
data class FcmMessage(
    var validate_only: Boolean,
    var message: Message
) : Serializable {
    constructor() : this(false, Message())

    @Builder
    @AllArgsConstructor
    @Getter
    data class Message(
//        var notification: Notification? = null,
        var data: Data?= null,
        var token: String? = null
    )

    @Builder
    @AllArgsConstructor
    @Getter
    data class Data(
        var title: String,
        var body: String,
        var image: String
    ): Serializable {
        constructor(): this("", "", "")
    }

    /**
     * Notification + Data를 보내는 것이 아닌 Data로만 보내면 Foreground, Background, Killed 상태일 때 모두 헤드업 알람을 볼 수 있다.
     */
//    @Builder
//    @AllArgsConstructor
//    @Getter
//    data class Notification(
//        var title: String,
//        var body: String,
//        var image: String
//    ): Serializable {
//        constructor(): this("", "", "")
//    }
}
