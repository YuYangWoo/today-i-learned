package com.kaonsoft.simple_mvvm_ex1.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Information(
    @SerializedName("account")
    var account: Account,
    @SerializedName("result")
    var result: Boolean,
    @SerializedName("response")
    var response: String
) : Serializable {
    constructor() : this(Account(), false, "")
    data class Account(
        @SerializedName("type")
        var type: String,
        @SerializedName("id")
        var id: String,
        @SerializedName("password")
        var password: String,
        @SerializedName("studentName")
        var studentName: String,
        @SerializedName("studentId")
        var studentId: String,
        @SerializedName("college")
        var college: String,
        @SerializedName("department")
        var department: String,
    ): Serializable {
        constructor(): this("","","","","","","")
    }
}
