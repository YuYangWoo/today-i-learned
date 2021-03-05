package com.example.boot.model

import com.example.boot.Account

class MakeAccount(id: String, pw: String) {
    private var id = id
    private var pw = pw
    fun json(): Account {
        return if(id == "yuyw0712" && pw == "qwe123") {
            Account("SUCCESS","유양우", 25, "가천대학교")
        } else {
            Account("Fail", "", 0, "")
        }
    }
}