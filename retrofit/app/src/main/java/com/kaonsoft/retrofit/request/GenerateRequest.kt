package com.kaonsoft.mobidoo_sdk_test.request

internal data class GenerateRequest(private val apiKey: String,
                                    private val expire: Int,
                                    private val format: String,
                                    private val hostData1: String,
                                    private val hostData2: String,
                                    private val multiple: Boolean,
                                    private val type: String) // type ["data" | "file"]