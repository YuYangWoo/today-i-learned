package com.example.fcm

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.auth.oauth2.GoogleCredentials
import lombok.RequiredArgsConstructor
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import org.springframework.core.io.ClassPathResource
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component
import java.io.*
import java.net.*


@Component
@RequiredArgsConstructor
class FirebaseCloudMessageService {
    private val API_URL: String = "https://fcm.googleapis.com/v1/projects/gachonroom/messages:send"
    private var objectMapper: ObjectMapper? = null
    private fun getAccessToken(): String {
        var firebaseConfigPath = "firebase/firebase_service_key.json"
        val googleCredentials = GoogleCredentials.fromStream(ClassPathResource(firebaseConfigPath).inputStream)
            .createScoped(listOf("https://www.googleapis.com/auth/cloud-platform"))
        googleCredentials.refreshIfExpired()
        return googleCredentials.accessToken.tokenValue
    }

    @Throws(IOException::class)
    fun sendMessageTo(targetToken: String, title: String, body: String) {
        val message: String = makeMessage(targetToken, title, body)
        val client = OkHttpClient()
        val requestBody: RequestBody = message.toRequestBody("application/json; charset=utf-8".toMediaType())
        val request: Request = Request.Builder().url(API_URL).post(requestBody).addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + getAccessToken())
                .addHeader(HttpHeaders.CONTENT_TYPE, "application/json; UTF-8").build()
        val response: Response = client.newCall(request).execute()
        println(response.body!!.string())
    }

    @Throws(JsonProcessingException::class)
    private fun makeMessage(targetToken: String, title: String, body: String): String {
       val fcmMessage =  FcmMessage(false, FcmMessage.Message(FcmMessage.Notification(title, body, ""), targetToken)  )
        objectMapper = ObjectMapper()
        return objectMapper!!.writeValueAsString(fcmMessage)
    }
}