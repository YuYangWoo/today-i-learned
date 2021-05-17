package com.example.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.io.IOException
import javax.servlet.http.HttpServletRequest

// ResponseBody X
@Controller
class Controller {

    /**
     * Hash 사용
     * 요청 : QueryString id=yuyw0712&pw=12345
     * 결과 : 500 ServletException
     */
    @GetMapping(path = ["/3"])
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
     * 결과 : 500 ServletException
     */
    @GetMapping(path = ["/4"])
    fun httpServletRequestGetVO(request: HttpServletRequest){
        var response = Info()
        println(request.queryString)
        response.id = request.getParameter("id")
        response.pw = request.getParameter("pw")
        println(response)
    }

    /**
     * Hash 사용
     * 요청 : QueryString id=yuyw0712&pw=12345
     * 결과 : 500 ServletException
     */
    @PostMapping(path = ["/7"])
    fun httpServletRequestPostHash(request: HttpServletRequest){
        var response = HashMap<String, Any>()
        response["id"] = request.getParameter("id")
        response["pw"] = request.getParameter("pw")
        println(response)
    }

    /**
     * VO 클래스 사용
     * 요청 : QueryString id=yuyw0712&pw=12345
     * 결과 : 500 ServletException
     */
    @PostMapping(path = ["/8"])
    fun httpServletRequestPostVO(request: HttpServletRequest){
        var response = Info()
        response.id = request.getParameter("id")
        response.pw = request.getParameter("pw")
        println(response)
    }

    /**
     * Hash 사용
     * 요청 : form-data id=yuyw0712 pw=12345
     * 결과 : 405 Error
     */
    @GetMapping(path = ["/11"])
    @Throws(IOException::class)
    fun formDataGetHash(request: HttpServletRequest){
        var response = HashMap<String, Any>()
        response["id"] = request.getParameter("id")
        response["pw"] = request.getParameter("pw")
        println(response)
    }

    /**
     * VO 사용
     * 요청 : form-data id=yuyw0712 pw=12345
     * 결과 : 500 Error
     */
    @GetMapping(path = ["/12"])
    @Throws(IOException::class)
    fun formDataGetVO(request: HttpServletRequest){
        var response = Info()
        response.id = request.getParameter("id")
        response.pw = request.getParameter("pw")
        println(response)
    }

    /**
     * Hash 사용
     * 요청 : form-data id=yuyw0712 pw=12345
     * 결과 : 500 Error
     */
    @PostMapping(path = ["/15"])
    fun formDataPostHash(id: String, pw: String){
        var response = HashMap<String, Any>()
        response["id"] = id
        response["pw"] = pw
        println(response)
    }

    /**
     * VO 사용
     * 요청 : form-data id=yuyw0712 pw=12345
     * 결과 : 500 Error
     */
    @PostMapping(path = ["/16"])
    fun formDataPostVO(id: String, pw: String){
        var response = Info()
        response.id = id
        response.pw = pw
        println(response)
    }

    /**
     * Hash 사용
     * 요청 : form-data id=yuyw0712 pw=12345
     * 결과 : 400 Error
     */
    @GetMapping(path = ["/19"])
    fun urlEncodedGetHash(@RequestParam id: String, @RequestParam pw: String){
        var response = HashMap<String, Any>()
        response["id"] = id
        response["pw"] = pw
        println(response)
    }

    /**
     * VO 사용
     * 요청 : form-data id=yuyw0712 pw=12345
     * 결과 : 400 Error
     */
    @GetMapping(path = ["/20"])
    fun urlEncodedGetVO(@RequestParam id: String, @RequestParam pw: String){
        var response = Info()
        response.id = id
        response.pw = pw
        println(response)
    }

    /**
     * Hash 사용
     * 요청 : form-data id=yuyw0712 pw=12345
     * 결과 : 400 Error
     */
    @PostMapping(path = ["/23"])
    fun urlEncodedPostHash(@RequestParam id: String, @RequestParam pw: String) {
        var response = HashMap<String, Any>()
        response["id"] = id
        response["pw"] = pw
        println(response)
    }

    /**
     * VO 사용
     * 요청 : form-data id=yuyw0712 pw=12345
     * 결과 : 400 Error
     */
    @PostMapping(path = ["/24"])
    fun urlEncodedPostVO(@RequestParam id: String, @RequestParam pw: String) {
        var response = Info()
        response.id = id
        response.pw = pw
        println(response)
    }

    /**
     * Hash 사용
     * 요청 : json id=yuyw0712 pw=12345
     * 결과 : 500 Error
     */
    @GetMapping(path = ["/27"])
    fun jsonGetHash(@RequestBody info: Info){
        println(info)
    }

    /**
     * VO 사용
     * 요청 : json id=yuyw0712 pw=12345
     * 결과 : 500 Error
     */
    @GetMapping(path = ["/28"])
    fun jsonGetVO(@RequestBody info: Info){
        println(info)
    }

    /**
     * Hash 사용
     * 요청 : json id=yuyw0712 pw=12345
     * 결과 : 400 Error
     */
    @PostMapping(path = ["/31"])
    fun jsonPostHash(@RequestBody info: Info){
        var response = HashMap<String, Any>()
        response["id"] = info.id
        response["pw"] = info.pw
        println(response)
    }

    /**
     * VO 사용
     * 요청 : json id=yuyw0712 pw=12345
     * 결과 : 400 Error
     */
    @PostMapping(path = ["/32"])
    fun jsonPostVO(@RequestBody info: Info){
        println(info)
    }
}