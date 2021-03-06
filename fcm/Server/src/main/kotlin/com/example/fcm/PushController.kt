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
        var deviceToken = "fvp6fFW6SfOhZAMqnkHHlG:APA91bHrJu5vmmpO0KM_EgkrxJIPMSQB-h1WbfsadcLof0VeLB2rXKdigmYrM5uG9eHunwLigm2PXFkbMCf1l_NcitOuqGpcnP9FnwK0V_0c5uhipz-Swrs6_q6NWritoi_wlwxs7Ixv"
        var client = OkHttpClient.Builder().build()
        val notification = JSONObject()
        notification.put("body", "반납 15분 전입니다")
        notification.put("title", "반납알림")


        var body = FormBody.Builder()
            .add("to", deviceToken)
            .add("project_id", senderId)
            .add("notification", notification.toString())
            .build()
        println("formBody는 ${body.toString()}")
        var request = Request.Builder()
            .url("https://fcm.googleapis.com/fcm/send")
            .addHeader("Authorization", "key=$apiKey")
            .post(body)
            .build()

        println(request.toString())
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                print(e.toString() + "에러나땅 ㅠ")
            }

            override fun onResponse(call: Call, response: Response) {
                if(response.isSuccessful) {
                    print(  "$response.code 성공해땅! ")
                }
                else {
                    print(response.body.toString())
                }
            }

        })
    }
}