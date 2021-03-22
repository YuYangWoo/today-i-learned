package com.kaonsoft.mobidoo_sdk_test.request

internal data class VerifyRequest(private val apiKey: String,
                                  private val deviceName: String,
                                  private val deviceVendor: String,
                                  private val osType: String,
                                  private val osVersion: String,
                                  private val sdkVersion: String,
                                  private val sonicData: Long,
                                  private val userData1: String,
                                  private val userData2: String)