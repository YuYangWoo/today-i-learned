package com.kaonsoft.mobidoo_sdk_test.request

internal data class ResultRequest(private val apiKey: String,
                                  private val sonicData: Long
                                ) // type ["data" | "file"]