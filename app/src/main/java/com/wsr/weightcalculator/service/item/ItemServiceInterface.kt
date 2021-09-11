package com.wsr.weightcalculator.service.item

import com.wsr.weightcalculator.entity.Item
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent

interface ItemServiceInterface : KoinComponent {

    fun getItemsByTitleId(titleId: Int): Flow<List<Item>>
}