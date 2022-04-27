package com.example.fcm

import com.fasterxml.jackson.databind.util.JSONPObject
import okhttp3.*
import org.json.JSONObject
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.io.IOException

@RestController
class PushController {
    private val apiKey =
        "AAAAZr4sD3w:APA91bGhDERGCh5B_GsoKPTrtXEY9rZWU7f18LLqDan4wpqTr5Kg9cuuFo1xl6lM9AM6A29eLHuZ-9iOnruLdEKcMKz0eWDO7ba8TaK9FPGG8f_aZKnfSbgrGnOMxWxd6bMi3sinHKG1"
    private val senderId = "441277222780"

    @GetMapping("/push")
    private fun pushTransfer() {
        val firebaseCloudMessageService = FirebaseCloudMessageService()
        firebaseCloudMessageService.sendMessageTo("d3bf5lSoQ22vFUjfiDc-s9:APA91bGMkqaJwL9xJo2Ku7aUxIyyoyQl6Lt_EJ8GO1VvlWbGJy3rhHEpb2_hFUTsXJNDrysHdzcn0ocG1Lq0cTamf0LInRmQeXNs90-dr90kqW3UVTF7FOQVAG-a5K6FCPd5bFLND6e7","제목", "내용" )

    }
}