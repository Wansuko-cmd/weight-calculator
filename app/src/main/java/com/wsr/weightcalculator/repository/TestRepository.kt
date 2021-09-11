package com.wsr.weightcalculator.repository

import com.wsr.weightcalculator.entity.Item
import com.wsr.weightcalculator.entity.ItemTitle
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

        private val items = listOf(
            Item(1, "Item1", 100),
            Item(2, "Item2", 200),
            Item(3, "Item3", 300),
            Item(4, "Item4", 400),
            Item(5, "Item5", 500),
            Item(6, "Item6", 600),
            Item(7, "Item7", 700),
            Item(8, "Item8", 800),
            Item(9, "Item9", 900),
            Item(10, "Item10", 20),
        )

        private val itemTitle = listOf(
            ItemTitle(1, 1, 1, 1),
            ItemTitle(1, 1, 2, 2),
            ItemTitle(1, 1, 3, 5),
            ItemTitle(1, 1, 4, 4),
            ItemTitle(1, 1, 5, 3),
            ItemTitle(1, 2, 6, 1),
            ItemTitle(1, 2, 7, 2),
            ItemTitle(1, 2, 8, 3),
            ItemTitle(1, 3, 9, 1),
        )
    }

    override fun getAllTitles(): Flow<List<Title>> {
        return flow { emit(titles) }
    }

    override fun getItemsByTitleId(titleId: Int): Flow<List<Item>> {
        return flow {

            val result = mutableListOf<Item>()

            itemTitle.filter { it.titleId == titleId }
                .sortedBy { it.order }
                .forEach { relatedItemTitle ->
                    result.add(items.first { it.id == relatedItemTitle.itemId })
                }

            emit(result)
        }
    }
}