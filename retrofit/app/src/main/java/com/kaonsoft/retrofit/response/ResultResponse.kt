package com.kaonsoft.mobidoo_sdk_test.response

internal data class ResultResponse(
                                    val hostData1: String,
                                    val hostData2: String,
                                    val serverTime: String,
                                    val sonicData: Long,
                                    val userData1: String,
                                    val userData2: String,
                                    val code: Int,
                                    val message: String)