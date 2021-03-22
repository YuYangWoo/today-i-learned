package com.cookandroid.gachon_study_room.data.room

import java.io.Serializable

data class RoomsData(
        var result: Boolean,
        var rooms: ArrayList<Room>,
        var message: String
) : Serializable {
    constructor() : this(false, arrayListOf(), "")
}
