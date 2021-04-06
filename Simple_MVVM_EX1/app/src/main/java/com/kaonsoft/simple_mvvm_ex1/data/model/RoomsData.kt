package com.kaonsoft.simple_mvvm_ex1.data.model

import java.io.Serializable

data class RoomsData(
    var result: Boolean,
    var rooms: ArrayList<Room>,
    var response: String
) : Serializable {
    constructor() : this(false, arrayListOf(), "")
}
