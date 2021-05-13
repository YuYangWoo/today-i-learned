package com.example.fcm

import okhttp3.*
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
        var deviceToken = "f_eo53zCQh-Ndbd6AdzGRm:APA91bHCHZGhOGrve8QDre1wguBJ3oS_sd-zOmSSfl3eJ-zoX0BLzuA7Rt-U66WW8WrfhZ-eh1Lyng66gCpdJ_XukkOmFmq08kLo6D9HgzD-EzRcaSOZsINx472AQhhjaZzTjWo-qlPf"
        var client = OkHttpClient.Builder().build()
        var body = FormBody.Builder()
            .add("to", deviceToken)
            .add("project_id", senderId)
            .add("notification", "")
            .build()
        var request = Request.Builder()
            .url("https://fcm.googleapis.com/fcm/send")
            .addHeader("Authorization", "key=$apiKey")
            .post(body)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                print(e.toString() + "에러나땅 ㅠ")
            }

            override fun onResponse(call: Call, response: Response) {
                if(response.isSuccessful) {
                    print(  "$response.code 성공해땅!")
                }
                else {
                    print(response.body.toString())
                }
            }

        })
    }
}