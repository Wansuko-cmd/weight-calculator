package com.wsr.weightcalculator.service.item

import com.wsr.weightcalculator.entity.Item
import com.wsr.weightcalculator.repository.BaseRepositoryInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import org.koin.core.component.inject
import java.util.*

class ItemService : ItemServiceInterface {

    private val baseRepository: BaseRepositoryInterface by inject()

    override suspend fun getItemsByTitleId(titleId: String): Flow<List<Item>> {
        return flow {
            baseRepository.getItemsByTitleId(titleId).collect { items ->
                emit(items.sortedBy { it.order })
            }
        }
    }

    override suspend fun insertItem(
        titleId: String,
        name: String,
        amount: Int,
        order: Int
    ): Item {
        val newItem = Item(UUID.randomUUID().toString(), titleId, name, amount, order)
        baseRepository.insertItem(newItem)
        return newItem
    }

    override suspend fun updateItems(items: List<Item>){
        baseRepository.updateItems(items)
    }

    override suspend fun getResult(
        standardAmount: Int,
        itemToNumber: Map<Item, Int>
    ): Int = withContext(Dispatchers.Default) {

        var result = standardAmount
        itemToNumber.map { result -= it.key.amount * it.value }

        return@withContext result
    }
}