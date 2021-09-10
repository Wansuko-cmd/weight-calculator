package com.wsr.weightcalculator.entity

data class Contents(
    val id: Int,
    val titleId: Int,
    val items: List<Item>
)

data class Item(
    val name: String,
    val number: Int
)