package com.wsr.weightcalculator.service.item

import com.wsr.weightcalculator.entity.Item
import com.wsr.weightcalculator.repository.BaseRepositoryInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import org.koin.core.component.inject

class ItemService : ItemServiceInterface {

    private val baseRepository: BaseRepositoryInterface by inject()

    override fun getItemsByTitleId(titleId: Int): Flow<List<Item>> {
        return flow {
            baseRepository.getItemsByTitleId(titleId).collect { items ->
                emit(items.sortedBy { it.order })
            }
        }
    }

    override fun updateItems(items: List<Item>){
        baseRepository.updateItems(items)
    }
}