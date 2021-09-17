package com.wsr.weightcalculator.service.item

import com.wsr.weightcalculator.entity.Item
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent

interface ItemServiceInterface : KoinComponent {

    suspend fun getItemsByTitleId(titleId: String): Flow<List<Item>>

    suspend fun insertItem(titleId: String, name: String, amount: Int, order: Int): Item

    suspend fun updateItems(item: Item)

    suspend fun getResult(standardAmount: Int, itemToNumber: Map<Item, Int>): Int
}