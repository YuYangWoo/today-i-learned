package com.example.boot.model

import com.kaonsoft.mission.InformationRequest
import com.kaonsoft.mission.InformationResponse

class Classify() {

    fun admin(info: InformationRequest): InformationResponse  {
        return if(info.name == "유양우") {
            InformationResponse(result = true, admin = true)
        } else {
            InformationResponse(result = true, admin = false)
        }
    }

    fun urlAdmin(info: HashMap<String, Any>): InformationResponse {
        return if(info["name"] == "유양우") {
            InformationResponse(result = true, admin = true)
        } else {
            InformationResponse(result = true, admin = false)
        }
    }

    fun hashAdmin(info: HashMap<String, Any>): InformationResponse {
        return if(info["name"] == "유양우") {
            InformationResponse(result = true, admin = true)
        }
        else {
            InformationResponse(result = true, admin = false)

        }
    }
}