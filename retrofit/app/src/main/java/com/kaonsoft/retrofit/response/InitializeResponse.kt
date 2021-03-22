package com.kaonsoft.mobidoo_sdk_test.response

data class InitializeResponse(
                                    var serverTime: String,
                                    var securityKey: String,
                                    var securityTag: String,
                                    var expire: String,
                                    var recommendPower: Double,
                                    var startFreq: Int,
                                    var interval: Int,
                                    var code: Int,
                                    var message: String)