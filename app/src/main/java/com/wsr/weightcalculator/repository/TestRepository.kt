package com.wsr.weightcalculator.repository

import com.wsr.weightcalculator.entity.Item
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

        private val contents = listOf(
            Item(1, 1, "Item1", 100),
            Item(2, 1, "Item2", 200),
            Item(3, 1, "Item3", 300),
            Item(4, 1, "Item4", 400),
            Item(5, 1, "Item5", 500),
            Item(6, 2, "Item6", 600),
            Item(7, 2, "Item7", 700),
            Item(8, 2, "Item8", 800),
            Item(9, 3, "Item9", 900),
            Item(10, 3, "Item10", 20),
        )
    }

    override fun getAllTitles(): Flow<List<Title>> {
        return flow { emit(titles) }
    }

    override fun getContentsByTitleId(titleId: Int): Flow<List<Item>> {
        return flow { emit(contents.filter { it.titleId == titleId }) }
    }
}