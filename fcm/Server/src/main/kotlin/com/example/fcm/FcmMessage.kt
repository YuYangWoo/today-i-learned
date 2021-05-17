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
        var notification: Notification? = null,
        var token: String? = null
    )

    @Builder
    @AllArgsConstructor
    @Getter
    data class Notification(
        var title: String,
        var body: String,
        var image: String
    ): Serializable {
        constructor(): this("", "", "")
    }
}
