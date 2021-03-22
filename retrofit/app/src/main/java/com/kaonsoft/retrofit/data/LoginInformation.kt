package com.kaonsoft.retrofit.data

data class LoginInformation(
        var id: String,
        var password: String,
        var type: String,
        var name: String,
        var studentId: String,
        var department: String,
        var college: String
){
    constructor():this("","","","","","", "")
}