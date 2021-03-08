package com.example.client

import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

object FormDataRequest {
    private var a: String =""
    fun requestHttp(txt: TextView) = runBlocking {

        var job = CoroutineScope(Dispatchers.IO).launch {
            try {
                Log.d("test", "시도하기.")
                val url = URL("http://10.0.2.2:8080/form")
                var conn = (url.openConnection() as HttpURLConnection).apply {
                    requestMethod = "POST"
                    setRequestProperty("Content_Type", "application/form")
                    setRequestProperty("charset", "utf-8")
                    setRequestProperty("Connection", "keep-alive")
                    setRequestProperty("Accept-Encoding", "gzip, deflate, br")
                }
                val osw = OutputStreamWriter(conn.outputStream)
                // urlencoded
                var urlen = "user_id=yuyw0712&user_password=qwe123"
                osw.write(urlen)
                osw.flush()

                if(conn.responseCode == HttpURLConnection.HTTP_OK) {
                    Log.d("test","연결 성공")
                    val streamReader = InputStreamReader(conn.inputStream)
                    val buffered = BufferedReader(streamReader)

                    val content = StringBuilder()
                    while (true) {
                        val line = buffered.readLine() ?: break
                        content.append(line)
                    }

                    for(i in content) {
                        if(i == ',') {
                            a += (i+"\n")
                        }
                        else {
                            a += i
                        }
                    }
                    Log.d("test", "값:$a")
                    txt.text = a
                }

            } catch (e: Exception) {
                Log.d("test",e.toString())
                Log.d("test", "연결 실패 !!")
            }
        }

        job.join()

    }
}