package com.kaonsoft.retrofit.request

import com.google.gson.annotations.SerializedName

data class InitializeRequest(
    var apiKey: String,
    var deviceName: String,
    var deviceVendor: String,
    var osType: String,
    var osVersion: String,
    var sdkVersion: String
)