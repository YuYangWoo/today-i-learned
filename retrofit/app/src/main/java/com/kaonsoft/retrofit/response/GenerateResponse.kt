package com.kaonsoft.mobidoo_sdk_test.response

data class GenerateResponse(
    var serverTime: String,
    var sonicData: Long,
    var type: String,
    var sonicWave: String,
    var sonicMp3: String,
    var expire: String,
    var code: Int,
    var message: String
)