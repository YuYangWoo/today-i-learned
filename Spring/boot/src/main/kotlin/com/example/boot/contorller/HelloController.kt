package com.example.boot.contorller

import com.example.boot.Account
import com.example.boot.model.MakeAccount
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest


@RestController
public class HelloController {

    @GetMapping("/without")
    fun withoutType(): String? {
        return "{\"name\":\"yangwoo\"}"
    }

    // 이걸로 받아서 가공할께. 이런말.
    @RequestMapping(value = ["/with"], name = "Account", method = [RequestMethod.POST], produces = ["application/json; charset=UTF8"])
    fun jsonType(@RequestParam user_id: String, user_password: String, req: HttpServletRequest): Account { //Content-Type에 대한 정의를 추가.
        var params = req.getParameter("user_id")

        return (MakeAccount(user_id, user_password).json())
    }




}