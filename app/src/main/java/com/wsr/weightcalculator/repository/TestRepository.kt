package com.wsr.weightcalculator.repository

import com.wsr.weightcalculator.entity.Item
import com.wsr.weightcalculator.entity.Title
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TestRepository : BaseRepositoryInterface {

    companion object{
        private val titlesData = listOf(
            Title("1", "Test1"),
            Title("2", "Test2"),
            Title("3", "Test3"),
            Title("4", "Test4"),
            Title("5", "Test5"),
        )

        private val itemsData = mutableListOf(
            Item("1", "1", "Item1", 1, 100),
            Item("2", "1", "Item2", 2, 200),
            Item("3", "1", "Item3", 5, 300),
            Item("4", "1", "Item4", 4, 400),
            Item("5", "1", "Item5", 3, 500),
            Item("10", "1", "Item10", 6, 200),
            Item("11", "1", "Item11", 7, 300),
            Item("12", "1", "Item12", 8, 400),
            Item("13", "1", "Item13", 9, 500),

            Item("6", "2", "Item6", 1, 600),
            Item("7", "2", "Item7", 2, 700),
            Item("8", "2", "Item8", 3, 800),

            Item("9", "3", "Item9", 1, 900),
        )
    }

    override suspend fun getAllTitles(): Flow<List<Title>> =
        flow { emit(titlesData) }



    override suspend fun getItemsByTitleId(titleId: String): Flow<List<Item>> =
        flow { emit(itemsData.filter { it.titleId == titleId }) }

    override suspend fun insertItem(item: Item) {
        itemsData.add(item)
    }


    override suspend fun updateItem(item: Item) =
        itemsData.updateFromId(item)


    private inline fun <reified T> MutableList<T>.updateFromId(value: T) {

        val index = when{
            all { it is Item } -> {
                @Suppress("UNCHECKED_CAST")
                this as List<Item>
                value as Item
                indexOfFirst { it.id == value.id }
            }
            all { it is Title } -> {
                @Suppress("UNCHECKED_CAST")
                this as List<Title>
                value as Title
                indexOfFirst { it.id == value.id }
            }
            else -> throw IllegalArgumentException("indexFromId Argument should have id.")
        }

        this[index] = value
    }
}

