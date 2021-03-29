package com.kaonsoft.mission

import java.io.Serializable

data class InformationResponse(
    var result: Boolean,
    var admin: Boolean
): Serializable {
    constructor(): this(false, false)
}
