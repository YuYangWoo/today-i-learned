package com.example.demo.controller

import java.io.Serializable

data class Info(
    var id: String,
    var pw: String
): Serializable {
    constructor(): this("","")
}
