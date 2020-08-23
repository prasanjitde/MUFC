package com.pd.mufc.data.entities

import com.pd.mufc.data.entities.Area
import com.pd.mufc.data.entities.Squad

data class Team(
    val address: String,
    val area: Area,
    val clubColors: String,
    val crestUrl: String,
    val email: String,
    val founded: Int,
    val id: Int,
    val lastUpdated: String,
    val name: String,
    val phone: String,
    val shortName: String,
    val squad: List<Squad>,
    val tla: String,
    val venue: String,
    val website: String
)