package com.example.boot.contorller

import com.example.boot.Account
import com.example.boot.model.MakeAccount
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest

@RestController
public class HelloController {

    // Receive x-www-urlencoded
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
    ): Account {
        var params = req.getParameter("user_id")

        return (MakeAccount(user_id, user_password).json())
    }

    // Receive form-data
    @RequestMapping(
        value = ["/form"],
        name = "form",
        method = [RequestMethod.POST]
    )
    @ResponseBody
    fun formType(
    @RequestParam name: String,
//    @RequestParam("file") file: MultipartFile
    ) {
        print(name)
    }

    // Receive Json
    @RequestMapping(
        value = ["/json"],
        name = "json",
        method = [RequestMethod.POST],
        produces = ["application/json; charset=UTF8"]
    )
    fun jsonType(@RequestBody user: Map<String, String>): Account {
        return (MakeAccount(user["user_id"].toString(), user["user_password"].toString()).json())
    }

}