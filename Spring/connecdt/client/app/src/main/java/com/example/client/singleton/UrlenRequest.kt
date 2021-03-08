package com.example.client.singleton

import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.net.HttpURLConnection
import java.io.*
import java.net.*

object UrlenRequest {
    private var a: String = ""
    fun requestHttp(txt: TextView) = runBlocking {

        var job = CoroutineScope(Dispatchers.IO).launch {
            try {
                Log.d("test", "시도하기.")
                val url = URL("http://10.0.2.2:8080/urlen")
                var conn = (url.openConnection() as HttpURLConnection).apply {
                    requestMethod = "POST"
                    setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
                    setRequestProperty("charset", "utf-8")
                    setRequestProperty("Connection", "keep-alive")
                    setRequestProperty("Accept-Encoding", "gzip, deflate, br")
                }

                // urlencoded
                var urlen = "user_id=yuyw0712&user_password=qwe123"
                val osw = OutputStreamWriter(conn.outputStream).apply {
                    write(urlen)
                    flush()
                    close()
                }

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
                    txt.text = a
                }
            } catch (e: Exception) {
                Log.d("test", e.toString())
                Log.d("test", "연결 실패 !!")
            }
        }

        job.join()

    }
}