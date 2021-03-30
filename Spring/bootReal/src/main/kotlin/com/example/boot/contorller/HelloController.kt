package com.example.boot.contorller

import com.example.boot.model.Classify
import com.kaonsoft.mission.InformationRequest
import com.kaonsoft.mission.InformationResponse
import org.springframework.web.bind.annotation.*

@RestController
public class HelloController {

    private var list = ArrayList<InformationRequest>()
//    // Receive x-www-urlencoded
//    @RequestMapping(
//        value = ["/urlen"],
//        name = "urlen",
//        method = [RequestMethod.POST],
//        produces = ["application/json; charset=UTF8"]
//    )
//    fun urlenType(
//        @RequestParam user_id: String,
//        user_password: String,
//        req: HttpServletRequest
//    ): Account {
//        var params = req.getParameter("user_id")
//
//        return (MakeAccount(user_id, user_password).json())
//    }
//
//    // Receive form-data
//    @RequestMapping(
//        value = ["/form"],
//        name = "form",
//        method = [RequestMethod.POST]
//    )
//    @ResponseBody
//    fun formType(
//        @RequestParam name: String,
//        @RequestParam file: MultipartFile
//    ): String {
//        println("연결성공! : $name 이고 파일전송 성공: $file")
//        return name
//    }
//
//    // Receive Json
//    @RequestMapping(
//        value = ["/json"],
//        name = "json",
//        method = [RequestMethod.POST],
//        produces = ["application/json; charset=UTF8"]
//    )
//    fun jsonType(@RequestBody user: Map<String, String>): Account {
//        return (MakeAccount(user["user_id"].toString(), user["user_password"].toString()).json())
//    }
//
//    // Receive x-www-urlencoded
//    @RequestMapping(
//        value = ["/login"],
//        name = "login",
//        method = [RequestMethod.POST],
//        produces = ["application/json; charset=UTF8"]
//    )
//    fun login(
//        @RequestParam user_id: String,
//        user_password: String
//    ): Account {
//
//        return (MakeAccount(user_id, user_password).json())
//    }

    // DTO를 활용해 request들어오고 dto를 활용해 받는경우
    @RequestMapping(
        value = ["/info"],
        name = "info",
        method = [RequestMethod.POST]
    )
    fun info(@RequestBody infoRequest: InformationRequest): InformationResponse {
        list.add(infoRequest)
        println(infoRequest.toString())

        return Classify().admin(infoRequest)
    }

    // hashmap으로 request 들어와 hashmap으로 받는경우
    @RequestMapping(
        value = ["/infoHash"],
        name = "infoHash",
        method = [RequestMethod.POST]
    )
    fun infoHash(@RequestBody infoRequest: HashMap<String, Any>): InformationResponse {
        println(infoRequest.toString())
        return InformationResponse(result = true, admin = false)
    }

    // form-urlencoded로 request들어와 map으로 받는 경우
    @RequestMapping(
        value = ["/infoEncoded"],
        name = "info",
        method = [RequestMethod.POST]
    )
    @ResponseBody
    fun infoEncoded(@RequestParam infoRequest: HashMap<String, Any>): InformationResponse {
        println(infoRequest.toString())
        return Classify().urlAdmin(infoRequest)
    }

    @GetMapping("/mission")
    fun mission(infoRequest: InformationRequest): InformationResponse {
        return if(infoRequest.name == "유양우") {
            InformationResponse(true,true)
        } else {
            InformationResponse(true, false)
        }
    }
}