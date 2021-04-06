package com.example.boot.contorller

import com.example.boot.model.Classify
import com.kaonsoft.mission.InformationRequest
import com.kaonsoft.mission.InformationResponse
import org.springframework.web.bind.annotation.*

@RestController
public class MissionController {

    // DTO를 활용해 request들어오고 dto를 활용해 받는경우
    // Controller
    @RequestMapping(
        value = ["/info"],
        name = "info",
        method = [RequestMethod.POST]
    )
    fun info(@RequestBody infoRequest: InformationRequest): InformationResponse {
        println("DTOPost (Json)\n아이디는 ${infoRequest.id} 비밀번호는 ${infoRequest.pw} 이름은 ${infoRequest.name} 나이는 ${infoRequest.age} 학교는 ${infoRequest.school} ")
        return Classify().admin(infoRequest)
    }

    // hashmap으로 request 들어와 hashmap으로 받는경우
    @RequestMapping(
        value = ["/infoHash"],
        name = "infoHash",
        method = [RequestMethod.POST]
    )
    fun infoHash(@RequestBody infoRequest: HashMap<String, Any>): InformationResponse {
        println("HashMapPOST (Json)\n아이디는 ${infoRequest["id"]} 비밀번호는 ${infoRequest["pw"]} 이름은 ${infoRequest["name"]} 나이는 ${infoRequest["age"]} 학교는 ${infoRequest["school"]} ")
        return Classify().hashAdmin(infoRequest)
    }

    // form-urlencoded로 request들어와 map으로 받는 경우
    @RequestMapping(
        value = ["/infoEncoded"],
        name = "info",
        method = [RequestMethod.POST]
    )
    @ResponseBody
    fun infoEncoded(@RequestParam infoRequest: HashMap<String, Any>): InformationResponse {
        println("HashMapPOST (UrlEncoded)\n아이디는 ${infoRequest["id"]} 비밀번호는 ${infoRequest["pw"]} 이름은 ${infoRequest["name"]} 나이는 ${infoRequest["age"]} 학교는 ${infoRequest["school"]} ")
        return Classify().urlAdmin(infoRequest)
    }

    // HashMap으로 GetMapping
    @GetMapping("/infoGet")
    fun mission(infoRequest: InformationRequest): InformationResponse {
        println("HashMap (Get)\n아이디는 ${infoRequest.id} 비밀번호는 ${infoRequest.pw} 이름은 ${infoRequest.name} 나이는 ${infoRequest.age} 학교는 ${infoRequest.school} ")
        return if(infoRequest.name == "유양우") {
             InformationResponse(result = true, admin = true)
        } else {
            InformationResponse(result = true, admin = false)
        }
    }
}