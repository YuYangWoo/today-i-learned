package com.kaonsoft.mission

import java.io.Serializable


data class InformationRequest(
    var id: String,
    var pw: String,
    var name: String,
    var age: Int,
    var school: String
): Serializable{
    constructor(): this("","","",0,"")
}
