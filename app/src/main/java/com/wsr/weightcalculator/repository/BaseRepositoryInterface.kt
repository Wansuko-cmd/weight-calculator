package com.wsr.weightcalculator.repository

import com.wsr.weightcalculator.entity.Item
import com.wsr.weightcalculator.entity.Title
import kotlinx.coroutines.flow.Flow

interface BaseRepositoryInterface {

    suspend fun getAllTitles(): Flow<List<Title>>

    suspend fun insertTitle(title: Title)

    suspend fun getItemsByTitleId(titleId: String): Flow<List<Item>>

    suspend fun insertItem(item: Item)

    suspend fun updateItem(item: Item)
}