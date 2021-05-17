package com.example.demo.controller

import org.springframework.web.bind.annotation.*
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
     * 결과 : {pw=12345, id=yuyw0712}
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
     * 결과 : Info(id=yuyw0712, pw=12345)
     */
    @PostMapping(path = ["/6"])
    fun httpServletRequestPostVO(request: HttpServletRequest) {
        var response = Info()
        response.id = request.getParameter("id")
        response.pw = request.getParameter("pw")
        println(response)
    }

    /**
     * Hash 사용
     * 요청 : form-data id=yuyw0712 pw=12345
     * 결과 : id=yuyw0712&pw=12345
     */
    @GetMapping(path = ["/9"])
    fun formDataGetHash(request: HttpServletRequest) {
        var response = HashMap<String, Any>()
        response["id"] = request.getParameter("id")
        response["pw"] = request.getParameter("pw")
        println(response)
    }

    /**
     * VO사용
     * 요청 : form-data id=yuyw0712 pw=12345
     * 결과 : id=yuyw0712&pw=12345
     */
    @GetMapping(path = ["/10"])
    fun formDataGetVO(request: HttpServletRequest) {
        var response = Info()
        response.id = request.getParameter("id")
        response.pw = request.getParameter("pw")
        println(response)
    }

    /**
     * Hash 사용
     * 요청 : form-data id=yuyw0712 pw=12345
     * 결과 : id=yuyw0712&pw=12345
     */
    @PostMapping(path = ["/13"])
    fun formDataPostHash(id: String, pw: String) {
        var response = HashMap<String, Any>()
        response["id"] = id
        response["pw"] = pw
        println(response)
    }

    /**
     * VO사용
     * 요청 : form-data id=yuyw0712 pw=12345
     * 결과 : id=yuyw0712&pw=12345
     */
    @PostMapping(path = ["/14"])
    fun formDataPostVO(id: String, pw: String) {
        var response = Info()
        response.id = id
        response.pw = pw
        println(response)
    }

    /**
     * Hash 사용
     * 요청 : url-encoded id=yuyw0712 pw=12345
     * 결과 : 500 Error
     */
    @GetMapping(path = ["/17"])
    fun urlEncodedGetHash(@RequestParam id: String, @RequestParam pw: String) {
        var response = HashMap<String, Any>()
        response["id"] = id
        response["pw"] = pw
        println(response)
    }

    /**
     * VO사용
     * 요청 : form-data id=yuyw0712 pw=12345
     * 결과 : 500 Error
     */
    @GetMapping(path = ["/18"])
    fun urlEncodedGetVO(request: HttpServletRequest) {
        var response = Info()
        response.id = request.getParameter("id")
        response.pw = request.getParameter("pw")
        println(response)
    }

    /**
     * Hash 사용
     * 요청 : url-encoded id=yuyw0712 pw=12345
     * 결과 : {pw=12345, id=yuyw0712}
     */
    @PostMapping(path = ["/21"])
    fun urlEncodedPostHash(@RequestParam id: String, @RequestParam pw: String) {
        var response = HashMap<String, Any>()
        response["id"] = id
        response["pw"] = pw
        println(response)
    }

    /**
     * VO사용
     * 요청 : form-data id=yuyw0712 pw=12345
     * 결과 : Info(id=yuyw0712, pw=qw123)
     */
    @PostMapping(path = ["/22"])
    fun urlEncodedPostVO(@RequestParam id: String, @RequestParam pw: String) {
        var response = Info()
        response.id = id
        response.pw = pw
        println(response)
    }

    /**
     * Hash 사용
     * 요청 : json id=yuyw0712 pw=12345
     * 결과 : {pw=12345, id=yuyw0712}
     */
    @GetMapping(path = ["/25"])
    fun jsonGetHash(@RequestBody info: Info) {
        var response = HashMap<String, Any>()
        response["id"] = info.id
        response["pw"] = info.pw
        println(response)
    }

    /**
     * VO사용
     * 요청 : json id=yuyw0712 pw=12345
     * 결과 : Info(id=yuyw0712, pw=12345)
     */
    @GetMapping(path = ["/26"])
    fun jsonGetVO(@RequestBody info: Info) {
        println(info)
    }

    /**
     * Hash 사용
     * 요청 : json id=yuyw0712 pw=12345
     * 결과 : {pw=12345, id=yuyw0712}
     */
    @PostMapping(path = ["/29"])
    fun jsonPostHash(@RequestBody info: Info) {
        var response = HashMap<String, Any>()
        response["id"] = info.id
        response["pw"] = info.pw
        println(response)
    }

    /**
     * VO사용
     * 요청 : json id=yuyw0712 pw=12345
     * 결과 : Info(id=yuyw0712, pw=12345)
     */
    @PostMapping(path = ["/30"])
    fun jsonPostVO(@RequestBody info: Info) {
        println(info)
    }
}