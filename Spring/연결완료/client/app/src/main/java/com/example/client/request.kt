package com.example.client

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.net.HttpURLConnection
import java.io.*
import java.net.*

object request {
    fun requestHttp() = runBlocking {

        var job = CoroutineScope(Dispatchers.IO).launch {
            try {
                Log.d("test", "시도하기.")
                val url = URL("http://10.0.2.2:8080/with")
                var conn = (url.openConnection() as HttpURLConnection).apply {
                    requestMethod = "POST"
                    setRequestProperty("Content_Type", "application/x-www-form-urlencoded")
                    setRequestProperty("charset", "utf-8")
                    setRequestProperty("Connection", "keep-alive")
                    setRequestProperty("Accept-Encoding", "gzip, deflate, br")
                }
                Log.d("test", "데이터쓰기")
                val osw = OutputStreamWriter(conn.outputStream)
                var sendMsg = "user_id=yuyw0712&user_password=qwe123"
                osw.write(sendMsg)
                osw.flush()

                if(conn.responseCode == HttpURLConnection.HTTP_OK) {
                    Log.d("test","연결 성공")
                }

            } catch (e: Exception) {
                Log.d("test",e.toString())
                Log.d("test", "연결 실패 !!")
            }
        }

        job.join()

    }
}