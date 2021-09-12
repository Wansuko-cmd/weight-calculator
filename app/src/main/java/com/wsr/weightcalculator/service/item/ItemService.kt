package com.wsr.weightcalculator.service.item

import com.wsr.weightcalculator.entity.Item
import com.wsr.weightcalculator.repository.BaseRepositoryInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import org.koin.core.component.inject

class ItemService : ItemServiceInterface {

    private val baseRepository: BaseRepositoryInterface by inject()

    override suspend fun getItemsByTitleId(titleId: Int): Flow<List<Item>> {
        return flow {
            baseRepository.getItemsByTitleId(titleId).collect { items ->
                emit(items.sortedBy { it.order })
            }
        }
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