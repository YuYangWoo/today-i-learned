package com.kaonsoft.simple_mvvm_ex1.data.model

import java.io.Serializable

data class Room(
    var college: String,
    var roomName: String,
    var seat: ArrayList<Array<Int>>, //2차원
    var available: ArrayList<Boolean>,
    var reserved: List<ArrayList<Reservation>>,
    var confirmTimeLimit: Long,
    var maximumReservationTime: Long,
    var maximumReservationCount: Long,
    var maximumExtendCount: Long
) : Serializable {
    constructor() : this("", "", arrayListOf(), arrayListOf(), arrayListOf(), 0,0,0,0)

    data class Reservation(
            var studentId: String,
            var college: String,
            var roomName: String,
            var seat: Int,
            var time: Long,
            var begin: Long,
            var end: Long,
            var confirmed: Boolean,
            var extended: Boolean,
            var reservationId: String
    ) : Serializable {
        constructor() : this("", "", "", 0, 0, 0, 0, false, false, "")
    }

}