package com.wsr.weightcalculator.service.item

import com.wsr.weightcalculator.entity.Item
import com.wsr.weightcalculator.repository.BaseRepositoryInterface
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.inject

class ItemService : ItemServiceInterface {

    private val baseRepository: BaseRepositoryInterface by inject()

    override fun getItemsByTitleId(titleId: Int): Flow<List<Item>> {
        return baseRepository.getItemsByTitleId(titleId)
    }
}