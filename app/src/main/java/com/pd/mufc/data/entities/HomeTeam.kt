package com.pd.mufc.data.entities

data class HomeTeam(
    val bench: List<BenchX>,
    val captain: CaptainX,
    val coach: CoachX,
    val id: Int,
    val lineup: List<LineupX>,
    val name: String
)