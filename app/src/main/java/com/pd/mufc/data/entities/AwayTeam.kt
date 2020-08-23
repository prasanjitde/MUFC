package com.pd.mufc.data.entities

data class AwayTeam(
    val bench: List<Bench>,
    val captain: Captain,
    val coach: Coach,
    val id: Int,
    val lineup: List<Lineup>,
    val name: String
)