package com.wsr.weightcalculator.repository

import com.wsr.weightcalculator.entity.Contents
import com.wsr.weightcalculator.entity.Title
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TestRepository : BaseRepositoryInterface {

    companion object{
        private val titles = listOf(
            Title(1, "Test1"),
            Title(2, "Test2"),
            Title(3, "Test3"),
            Title(4, "Test4"),
            Title(5, "Test5"),
        )
    }

    override fun getAllTitles(): Flow<List<Title>> {
        return flow { emit(titles) }
    }

    override fun getContentsByTitleId(titleId: Int): Flow<List<Contents>> {
        TODO("Not yet implemented")
    }
}