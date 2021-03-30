package com.example.boot

import org.springframework.web.multipart.MultipartFile
import java.io.Serializable

data class Form(
    var name: String ?= null,
    var file: MultipartFile ?= null
) :Serializable
