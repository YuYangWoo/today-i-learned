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
        firebaseCloudMessageService.sendMessageTo("eS3FCiteRjKhIzm81e0RPo:APA91bHgjhZ81HxUhrNq8pLwDExc5dc6uovhCm9Nn-2ph7fA7f7Mi4m7TOUSzyCR92VeScerNp2IZAf7YZGcA6XjTXXjXNuzXGdnm3I5UgaW5JeNLXgg-QIMCB38ryPnH-Ct9hAWvlzC","제목", "내용" )
//        var deviceToken = "eS3FCiteRjKhIzm81e0RPo:APA91bHgjhZ81HxUhrNq8pLwDExc5dc6uovhCm9Nn-2ph7fA7f7Mi4m7TOUSzyCR92VeScerNp2IZAf7YZGcA6XjTXXjXNuzXGdnm3I5UgaW5JeNLXgg-QIMCB38ryPnH-Ct9hAWvlzC"
//        var client = OkHttpClient.Builder().build()
//        val notification = JSONObject()
//        notification.put("body", "반납 15분 전입니다")
//        notification.put("title", "반납알림")
//
//
//        var body = FormBody.Builder()
//            .add("to", deviceToken)
//            .add("project_id", senderId)
//            .add("notification", notification.toString())
//            .build()
//        println("formBody는 ${body.toString()}")
//        var request = Request.Builder()
//            .url("https://fcm.googleapis.com/fcm/send")
//            .addHeader("Authorization", "key=$apiKey")
//            .post(body)
//            .build()
//
//        println(request.toString())
//        client.newCall(request).enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                print(e.toString() + "에러나땅 ㅠ")
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                if(response.isSuccessful) {
//                    print(  "$response.code 성공해땅! ")
//                }
//                else {
//                    print(response.body.toString())
//                }
//            }
//
//        })
    }
}