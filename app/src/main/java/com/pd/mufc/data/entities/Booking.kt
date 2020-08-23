package com.pd.mufc.data.entities

data class Booking(
    val card: String,
    val minute: Int,
    val player: Player,
    val team: TeamX
)