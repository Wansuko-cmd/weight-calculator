package com.wsr.weightcalculator.repository

import com.wsr.weightcalculator.entity.Item
import com.wsr.weightcalculator.entity.Title
import kotlinx.coroutines.flow.Flow

class RoomRepository : BaseRepositoryInterface{
    override suspend fun getAllTitles(): Flow<List<Title>> {
        TODO("Not yet implemented")
    }

    override suspend fun getItemsByTitleId(titleId: String): Flow<List<Item>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertItem(item: Item) {
        TODO("Not yet implemented")
    }

    override suspend fun updateItems(items: List<Item>) {
        TODO("Not yet implemented")
    }
}