package com.wsr.weightcalculator.repository

import com.wsr.weightcalculator.entity.Item
import com.wsr.weightcalculator.entity.Title
import kotlinx.coroutines.flow.Flow

interface BaseRepositoryInterface {

    fun getAllTitles(): Flow<List<Title>>

    fun getItemsByTitleId(titleId: Int): Flow<List<Item>>

    fun updateItems(items: List<Item>)
}