package com.kaonsoft.simple_koin_ex1

import java.io.Serializable

data class Information(
    var account: Account,
    var result: Boolean,
    var response: String
) : Serializable {
    constructor() : this(Account(), false, "")
    data class Account(
        var type: String,
        var id: String,
        var password: String,
        var studentName: String,
        var studentId: String,
        var college: String,
        var department: String,
    ): Serializable {
        constructor(): this("","","","","","","")
    }
}
