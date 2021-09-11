package com.wsr.weightcalculator.repository

import com.wsr.weightcalculator.entity.Item
import com.wsr.weightcalculator.entity.Title
import kotlinx.coroutines.flow.Flow

class RoomRepository : BaseRepositoryInterface{
    override fun getAllTitles(): Flow<List<Title>> {
        TODO("Not yet implemented")
    }

    override fun getItemsByTitleId(titleId: Int): Flow<List<Item>> {
        TODO("Not yet implemented")
    }
}