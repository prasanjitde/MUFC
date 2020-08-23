package com.pd.mufc.data.entities

data class Goal(
    val assist: List<Assist>,
    val minute: Int,
    val scorer: Scorer
)