package com.example.client.singleton

import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLConnection
import java.nio.file.Files


object FormDataRequest {
    private var a: String =""
    const val boundary = "*****"
    const val crlf = "\r\n"
    const val twoHyphens = "--"
    fun requestHttp(txt: TextView)  {

    }
}