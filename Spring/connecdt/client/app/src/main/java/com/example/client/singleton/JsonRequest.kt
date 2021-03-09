package com.example.client.singleton

import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.*
import org.json.JSONObject
import java.io.*
import java.net.HttpURLConnection
import java.net.URL

object JsonRequest {
    private var a: String = ""
    fun requestHttp(txt: TextView) {

        CoroutineScope(Dispatchers.Main).launch {

            var job: Job = CoroutineScope(Dispatchers.IO).launch {
                try {
                    Log.d("test", "시도하기.")
                    val url = URL("http://10.0.2.2:8080/json")
                    var conn = (url.openConnection() as HttpURLConnection).apply {
                        requestMethod = "POST"
                        setRequestProperty("Content-Type", "application/json")
                        setRequestProperty("charset", "utf-8")
                        setRequestProperty("Connection", "keep-alive")
                        setRequestProperty("Accept", "application/json")
                    }

                    // Json Post
                    var json = JSONObject()
                    json.put("user_id", "yuyw0712")
                    json.put("user_password", "qwe123")

                    val osw = OutputStreamWriter(conn.outputStream)
                    osw.write(json.toString())
                    osw.flush()

                    if (conn.responseCode == HttpURLConnection.HTTP_OK) {
                        Log.d("test", "연결 성공")
                        val streamReader = InputStreamReader(conn.inputStream)
                        val buffered = BufferedReader(streamReader)

                        val content = StringBuilder()
                        while (true) {
                            val line = buffered.readLine() ?: break
                            content.append(line)
                        }

                        for (i in content.indices) {
                            if (content[i] == ',' || content[i] == '{' || content[i] == '}') {
                                a += (content[i] + "\n")
                            } else {
                                a += content[i]
                            }
                        }
                        Log.d("test", "값:$a")
                    }

                } catch (e: Exception) {
                    Log.d("test", e.toString())
                    Log.d("test", "연결 실패 !!")
                }
            }

            job.join()

            txt.text = a
        }
    }
}