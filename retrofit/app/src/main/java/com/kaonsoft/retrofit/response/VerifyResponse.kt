package com.kaonsoft.mobidoo_sdk_test.response

data class VerifyResponse(var hostData1: String,
                          var hostData2: String,
                          var serverTime: String,
                          var sonicData: Long,
                          var userData1: String,
                          var userData2: String,
                          var code: Int,
                          var message: String)