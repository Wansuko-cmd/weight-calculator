package com.wsr.weightcalculator.domain.entity

data class Contents(
    val id: Int,
    val titleId: Int,
    val items: List<Item>
)