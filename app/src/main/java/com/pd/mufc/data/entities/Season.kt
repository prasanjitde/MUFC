package com.pd.mufc.data.entities

data class Season(
    val availableStages: List<String>,
    val currentMatchday: Int,
    val endDate: String,
    val id: Int,
    val startDate: String
)