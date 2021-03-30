package com.example.boot

data class Account(
        var success: String,
        var name: String,
        var age: Int,
        var school: String
) {
    constructor() : this("", "", 0, "")
}
