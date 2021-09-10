package com.wsr.weightcalculator.repository

import com.wsr.weightcalculator.entity.Contents
import com.wsr.weightcalculator.entity.Title
import kotlinx.coroutines.flow.Flow

class RoomRepository : BaseRepositoryInterface{
    override fun getAllTitles(): Flow<List<Title>> {
        TODO("Not yet implemented")
    }

    override fun getContentsByTitleId(titleId: Int): Flow<List<Contents>> {
        TODO("Not yet implemented")
    }
}