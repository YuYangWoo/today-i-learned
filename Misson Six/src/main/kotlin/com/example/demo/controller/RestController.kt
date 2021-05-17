package com.example.demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

// ResponseBody O
@RestController
class RestController {
    /**
     * Hash 사용
     * 요청 : QueryString id=yuyw0712&pw=12345
     * 결과 : id=yuyw0712&pw=12345
     */
    @GetMapping(path = ["/1"])
    fun httpServletRequestGetHash(request: HttpServletRequest) {
        var response = HashMap<String, Any>()
        println(request.queryString)
        response["id"] = request.getParameter("id")
        response["pw"] = request.getParameter("pw")
        println(response)
    }

    /**
     * VO 클래스 사용
     * 요청 : QueryString id=yuyw0712&pw=12345
     * 결과 : id=yuyw0712&pw=12345
     */
    @GetMapping(path = ["/2"])
    fun httpServletRequestGetVO(request: HttpServletRequest) {
        var response = Info()
        println(request.queryString)
        response.id = request.getParameter("id")
        response.pw = request.getParameter("pw")
        println(response)
    }

    /**
     * Hash 사용
     * 요청 : QueryString id=yuyw0712&pw=12345
     * 결과 : id=yuyw0712&pw=12345
     */
    @PostMapping(path = ["/5"])
    fun httpServletRequestPostHash(request: HttpServletRequest) {
        var response = HashMap<String, Any>()
        response["id"] = request.getParameter("id")
        response["pw"] = request.getParameter("pw")
        println(response)
    }

    /**
     * VO사용
     * 요청 : QueryString id=yuyw0712&pw=12345
     * 결과 : id=yuyw0712&pw=12345
     */
    @PostMapping(path = ["/6"])
    fun httpServletRequestPostVO(request: HttpServletRequest) {
        var response = Info()
        response.id = request.getParameter("id")
        response.pw = request.getParameter("pw")
        println(response)
    }

    // Hash
    @GetMapping(path = ["/9"])
    fun formDataGetHash(request: HttpServletRequest) {


    }

    // VO
    @GetMapping(path = ["/10"])
    fun formDataGetVO(request: HttpServletRequest) {


    }

    // Hash
    @PostMapping(path = ["/13"])
    fun formDataPostHash(request: HttpServletRequest) {


    }

    // VO
    @PostMapping(path = ["/14"])
    fun formDataPostVO(request: HttpServletRequest) {


    }

    // Hash
    @GetMapping(path = ["/17"])
    fun urlEncodedGetHash(request: HttpServletRequest) {


    }

    // VO
    @GetMapping(path = ["/18"])
    fun urlEncodedGetVO(request: HttpServletRequest) {


    }

    // Hash
    @PostMapping(path = ["/21"])
    fun urlEncodedPostHash(request: HttpServletRequest) {

    }

    // VO
    @PostMapping(path = ["/22"])
    fun urlEncodedPostVO(request: HttpServletRequest) {

    }

    // Hash
    @GetMapping(path = ["/25"])
    fun jsonGetHash(request: HttpServletRequest) {

    }

    // VO
    @GetMapping(path = ["/26"])
    fun jsonGetVO(request: HttpServletRequest) {

    }

    // Hash
    @PostMapping(path = ["/29"])
    fun jsonPostHash(request: HttpServletRequest) {

    }

    // VO
    @PostMapping(path = ["/30"])
    fun jsonPostVO(request: HttpServletRequest) {

    }
}