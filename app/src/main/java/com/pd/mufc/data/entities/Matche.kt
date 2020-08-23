package com.pd.mufc.data.entities

data class Matche(
    val attendance: Int,
    val awayTeam: AwayTeam,
    val bookings: List<Booking>,
    val competition: Competition,
    val goals: List<Goal>,
    val group: String,
    val homeTeam: HomeTeam,
    val id: Int,
    val lastUpdated: String,
    val matchday: Int,
    val minute: Any,
    val referees: List<Referee>,
    val score: Score,
    val season: Season,
    val stage: String,
    val status: String,
    val substitutions: List<Substitution>,
    val utcDate: String
)