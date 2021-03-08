package com.example.boot.contorller

import com.example.boot.Account
import com.example.boot.model.MakeAccount
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest

@RestController
public class HelloController {

    // 이걸로 받아서 가공할께. 이런말.
    @RequestMapping(
        value = ["/urlen"],
        name = "urlen",
        method = [RequestMethod.POST],
        produces = ["application/json; charset=UTF8"]
    )
    fun urlenType(
        @RequestParam user_id: String,
        user_password: String,
        req: HttpServletRequest
    ): Account { //Content-Type에 대한 정의를 추가.
        var params = req.getParameter("user_id")

        return (MakeAccount(user_id, user_password).json())
    }

    // 이걸로 받아서 가공할께. 이런말.
    @RequestMapping(
        value = ["/form"],
        name = "form",
        method = [RequestMethod.POST],
        produces = ["application/json; charset=UTF8"]
    )
    fun formType(
        @RequestParam user_id: String,
        user_password: String,
        req: HttpServletRequest
    ): Account { //Content-Type에 대한 정의를 추가.
        var params = req.getParameter("user_id")

        return (MakeAccount(user_id, user_password).json())
    }

    // 이걸로 받아서 가공할께. 이런말.
    @RequestMapping(
        value = ["/json"],
        name = "json",
        method = [RequestMethod.POST],
        produces = ["application/json; charset=UTF8"]
    )
    fun jsonType(@RequestBody user: Map<String, String>): Account { // Content-Type에 대한 정의를 추가.
        return (MakeAccount(user["user_id"].toString(), user["user_password"].toString()).json())
    }

}