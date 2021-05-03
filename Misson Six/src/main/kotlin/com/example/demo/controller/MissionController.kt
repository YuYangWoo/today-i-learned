package com.example.demo.controller

import org.springframework.http.MediaType
import org.springframework.ui.Model
import org.springframework.util.MultiValueMap
import org.springframework.util.StreamUtils
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.MultipartHttpServletRequest
import org.springframework.web.multipart.MultipartRequest
import javax.servlet.http.HttpServletRequest
import java.io.IOException
import java.nio.charset.StandardCharsets
import javax.servlet.annotation.WebServlet
import kotlin.collections.HashMap

@RestController
class MissionController {

    // Get방식 QueryString으로 데이터를 보낼 때
    // Get은 request packet에 http body가 존재하지 않음
    // 헤더와 바디가 어떻게 들어가는지 볼 수 있음.
    @GetMapping(path = ["/ab"])
    fun resultGetUrlEncoded(request: HttpServletRequest): String {
        var oHeader = request.headerNames
        while (oHeader.hasMoreElements()) {
            var strName = oHeader.nextElement()
            var strValue = request.getHeader(strName)
            println("$strName : $strValue\n")
        }
        val string =
            "Request QueryString -> ${request.queryString} \nRequest getParameter -> ${request.getParameter("id")}  ${
                request.getParameter("pw")
            }"
        println(
            "Request QueryString -> ${request.queryString} \nRequest getParameter -> ${
                request.getParameter(
                    "id"
                )
            }  ${request.getParameter("pw")}"
        )
        return string
    }

    // vo객체로 받아 데이터를 담아 view로 보내는 객체
    // map으로도 가공이 가능하고 servletRequest로 데이터도 다 가공할 수 있음.
    @GetMapping(path = ["/abcdef"])
    @Throws(IOException::class)
    fun createAbcdef(info: Info, model: Model, req: HttpServletRequest) {
        println("Url -> ${req.requestURL}\nQuery String -> ${req.queryString} ")
        model.addAttribute("info", info)
        println("Info는 $info")
        var infoMap: HashMap<String, Any> = model.asMap() as HashMap<String, Any>
        print(infoMap["info"])
    }

    // Get으로 query String을 날리는 경우에는 getParameter로 가져오기가 가능하고 아니면 inputStream이나 reader로 가져와야한다.
    // body에 데이터를 넣어서 가져올 때 reader와 inputStream으로 가져올 수 있는데 reader를 사용한 경우
    // ex) x-www-urlencoded, json을 reader로 읽음 body를 알 수 있음
    // Model객체는 view로 데이터 전달하는 역할을 함.
    // reader를 사용하는 경우 abcd랑 동일
    @PostMapping(path = ["/abc"])
    @Throws(IOException::class)
    fun createAbc(request: HttpServletRequest): String? {
        // 헤더 정보 얻기
        var oHeader = request.headerNames
        while (oHeader.hasMoreElements()) {
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
    // InputStream을 사용하는경우
    @PostMapping(path = ["/abcd"])
    @Throws(IOException::class)
    fun createAbcdef(request: HttpServletRequest): String {
        // 헤더 정보 얻기
        var oHeader = request.headerNames
        while (oHeader.hasMoreElements()) {
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
//        var inputStream = request.inputStream
//        var messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8)
        return stringBuilder.toString()
    }

    // @requestbody를 사용한 class 매핑
    @PostMapping(path = ["/abcde"])
    @Throws(IOException::class)
    fun createAbcde(@RequestBody info: Info, request: HttpServletRequest): Info {
        println(info)
        return info
    }

    // @RequestParam multipartFile로 가져올 수 있음
    // content-disposition body에 컨텐츠 기질/성향
    @RequestMapping(path = ["/form-data"])
    fun confirmAccount(request: HttpServletRequest, model: Model) {

        var inputStream = request.inputStream
        var messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8)
        // 헤더 정보 얻기
        var oHeader = request.headerNames
        while (oHeader.hasMoreElements()) {
            var strName = oHeader.nextElement()
            var strValue = request.getHeader(strName)
            println("$strName : $strValue\n")
        }

        // 바디 정보 얻기
        val mServletInputStream = request.inputStream
        val httpInData = ByteArray(request.contentLength)
        var retVal = -1
        val stringBuilder = StringBuilder()

        while (mServletInputStream.read(httpInData).also {
                retVal = it
        } != -1) {
            for (i in 0 until retVal) {
                println(httpInData[i].toChar().toString())
                stringBuilder.append(httpInData[i].toChar().toString())
            }
        }
        println(stringBuilder)
        println(request.getParameter("id") + "\n" + request.getParameter("pw") + "\n" + request.getParameter("name"))

    }


}