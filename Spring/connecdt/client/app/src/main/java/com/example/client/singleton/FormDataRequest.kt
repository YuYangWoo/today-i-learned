package com.example.client.singleton

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLConnection


object FormDataRequest {
    var boundary = "^-----^"
    var LINE_FEED: String = "\r\n"
    var charset: String = "UTF-8"
    var outputStream: OutputStream? = null
    var writer: PrintWriter? = null
    fun test() = runBlocking {
        var file = File("android.resource://com.example.client/drawable/icon")
        var job = CoroutineScope(Dispatchers.IO).launch {
            var url = URL("http://10.0.2.2:8080/form")
            var conn = (url.openConnection() as HttpURLConnection).apply {
                requestMethod = "POST"
                setRequestProperty(
                    "Content-Type",
                    "multipart/form-data; charset=utf-8; boundary=$boundary"
                )
                doInput = true
                doOutput = true
                useCaches = false
                setRequestProperty("Connection", "keep-alive")
            }

            outputStream = conn.outputStream
            writer = PrintWriter(OutputStreamWriter(outputStream, charset), true)
            writer!!.append("--$boundary").append(LINE_FEED);
            writer!!.append("Content-Disposition: form-data; name=\"name\"").append(LINE_FEED);
            writer!!.append("Content-Type: text/plain; charset=$charset").append(LINE_FEED);
            writer!!.append(LINE_FEED);
            writer!!.append("유양우").append(LINE_FEED);
            writer!!.flush();

//            /** 파일 데이터를 넣는 부분**/
//            writer!!.append("--$boundary").append(LINE_FEED);
//            writer!!.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + file.name + "\"").append(
//                LINE_FEED
//            );
//            writer!!.append("Content-Type: " + URLConnection.guessContentTypeFromName(file.name)).append(
//                LINE_FEED
//            );
//            writer!!.append("Content-Transfer-Encoding: binary").append(LINE_FEED);
//            writer!!.append(LINE_FEED);
//            writer!!.flush();
//
//            val inputStream = FileInputStream(file)
//            val buffer = ByteArray(
//                file.length().toInt()
//            )
//            var bytesRead = -1
//            while (inputStream.read(buffer).also { bytesRead = it } != -1) {
//            outputStream!!.write(buffer, 0, bytesRead)
//        }

            outputStream!!.flush();
            writer!!.append(LINE_FEED);
            writer!!.flush();
            writer!!.append(
                "--$boundary--"
            ).append(LINE_FEED);
            writer!!.close();
            if (conn.responseCode == HttpURLConnection.HTTP_OK) {
               Log.d("Test", "연결성공공")
            }
        }
        job.join()
    }
}