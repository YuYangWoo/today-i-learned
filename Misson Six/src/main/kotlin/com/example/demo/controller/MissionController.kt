package com.example.demo.controller

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest
import java.io.BufferedReader

import java.io.IOException

import org.springframework.web.bind.annotation.PostMapping
import kotlin.collections.HashMap
import javax.servlet.ServletInputStream




@RestController
class MissionController {

    // Get방식 QueryString으로 데이터를 보낼 때
    @GetMapping(path = ["/ab"])
    fun resultGetUrlEncoded(request: HttpServletRequest) {
        var oHeader = request.headerNames
        while(oHeader.hasMoreElements()) {
            var strName = oHeader.nextElement()
            var strValue = request.getHeader(strName)
            println("$strName : $strValue\n")
        }

        println("Request body QueryString ${request.queryString} \nRequest Body getParameter ${request.getParameter("id")}  ${request.getParameter("pw")}")
    }

    // Get으로 query String을 날리는 경우에는 getParameter로 가져오기가 가능하고 아니면 inputStream이나 reader로 가져와야한다.
    // body에 데이터를 넣어서 가져올 때 reader와 inputStream으로 가져올 수 있는데 reader를 사용한 경우
    // ex) x-www-urlencoded, json을 reader로 읽음 body를 알 수 있음
    // Model객체는 view로 데이터 전달하는 역할을 함.
    @PostMapping(path = ["/abc"])
    @Throws(IOException::class)
    fun createAbc(request: HttpServletRequest): String? {
        // 헤더 정보 얻기
        var oHeader = request.headerNames
        while(oHeader.hasMoreElements()) {
            var strName = oHeader.nextElement()
            var strValue = request.getHeader(strName)
            println("$strName : $strValue\n")
        }

        // reader를 사용한 경우
        val builder = StringBuilder()
        request.reader.use { `in` ->
            val buf = CharArray(4096)
            var len: Int
            while (`in`.read(buf).also { len = it } > 0) {
                builder.append(buf, 0, len)
            }
        }
        val requestBody = builder.toString()
        println("Request body: $requestBody")

        return requestBody
    }

    // Get으로 query String을 날리는 경우에는 getParameter로 가져오기가 가능하고 아니면 inputStream이나 reader로 가져와야한다.
    // body에 데이터를 넣어서 가져올 때 reader와 inputStream으로 가져올 수 있는데 inputStream을 사용한 경우
    // ex) x-www-urlencoded, json을 reader로 읽음 body를 알 수 있음
    // Model객체는 view로 데이터 전달하는 역할을 함.
    @PostMapping(path = ["/abcdef"])
    @Throws(IOException::class)
    fun createAbcdef(request: HttpServletRequest) : String{
        // 헤더 정보 얻기
        var oHeader = request.headerNames
        while(oHeader.hasMoreElements()) {
            var strName = oHeader.nextElement()
            var strValue = request.getHeader(strName)
            println("$strName : $strValue\n")
        }

        // 바디 정보 얻기
        val mServletInputStream = request.inputStream
        val httpInData = ByteArray(request.contentLength)
        var retVal = -1
        val stringBuilder = StringBuilder()

        while (mServletInputStream.read(httpInData).also { retVal = it } != -1) {
            for (i in 0 until retVal) {
                stringBuilder.append(httpInData[i].toChar().toString())
            }
        }
        println("Request Body : $stringBuilder")
        return stringBuilder.toString()
    }

    @GetMapping(path = ["/abcde"])
    @Throws(IOException::class)
    fun createAbcde(model: Model, map: HashMap<String, Any>, req: HttpServletRequest): String? {
        var oHeader = req.headerNames
        while(oHeader.hasMoreElements()) {
            var strName = oHeader.nextElement()
            var strValue = req.getHeader(strName)
            println("$strName 는 밸류는$strValue\n")
        }
        println(req.getParameter("id") + req.getParameter("pw") )
        return "abc"
    }

}