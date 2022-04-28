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
        firebaseCloudMessageService.sendMessageTo("f__lnzsNQTq1cuhVeuFNCC:APA91bHtUOgEskfn2ag4XRB7kh8zjoYLz72RSscqfJpDvEzDzvl-63GueoVCd8r0EFY3aqV2_YunTBrheHtPEuSf6w2gakAkWP83p2pnTGr4qWrzTmW0ZS3jBf5-qljhDBu1_qKQcBQK","제목", "내용" )

    }
}