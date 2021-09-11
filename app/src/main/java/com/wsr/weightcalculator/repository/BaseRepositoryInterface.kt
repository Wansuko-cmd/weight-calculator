package com.wsr.weightcalculator.repository

import com.wsr.weightcalculator.entity.Item
import com.wsr.weightcalculator.entity.Title
import kotlinx.coroutines.flow.Flow

interface BaseRepositoryInterface {

    suspend fun getAllTitles(): Flow<List<Title>>

    suspend fun getItemsByTitleId(titleId: Int): Flow<List<Item>>

    suspend fun updateItems(items: List<Item>)
}