package com.example.boot

data class UserVO(
    var user_id: String,
    var user_password: String
){
    constructor(): this("","")
}
