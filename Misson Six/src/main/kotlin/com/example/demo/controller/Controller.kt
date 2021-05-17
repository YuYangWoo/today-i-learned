package com.example.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
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
        var response = HashMap<String, Any>()
        response["id"] = request.getParameter("id")
        response["pw"] = request.getParameter("pw")
        println(response)
    }

    // Hash
    @GetMapping(path = ["/11"])
    fun formDataGetHash(request: HttpServletRequest){

    }

    // VO
    @GetMapping(path = ["/12"])
    fun formDataGetVO(request: HttpServletRequest){

    }

    // Hash
    @PostMapping(path = ["/15"])
    fun formDataPostHash(request: HttpServletRequest){

    }

    // VO
    @PostMapping(path = ["/16"])
    fun formDataPostVO(request: HttpServletRequest){

    }

    // Hash
    @GetMapping(path = ["/19"])
    fun urlEncodedGetHash(request: HttpServletRequest){

    }

    // VO
    @GetMapping(path = ["/20"])
    fun urlEncodedGetVO(request: HttpServletRequest){

    }

    // Hash
    @PostMapping(path = ["/23"])
    fun urlEncodedPostHash(request: HttpServletRequest){

    }

    // VO
    @PostMapping(path = ["/24"])
    fun urlEncodedPostVO(request: HttpServletRequest){

    }

    // Hash
    @GetMapping(path = ["/27"])
    fun jsonGetHash(request: HttpServletRequest){

    }

    // VO
    @GetMapping(path = ["/28"])
    fun jsonGetVO(request: HttpServletRequest){

    }

    // Hash
    @PostMapping(path = ["/31"])
    fun jsonPostHash(request: HttpServletRequest){

    }

    // VO
    @PostMapping(path = ["/32"])
    fun jsonPostVO(request: HttpServletRequest){

    }
}