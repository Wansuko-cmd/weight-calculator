package com.wsr.weightcalculator.view_model.show

import com.wsr.weightcalculator.entity.Item
import com.wsr.weightcalculator.service.item.ItemServiceInterface
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.inject

class ShowViewModel(val titleId: Int) : ShowViewModelInterface(){

    private val itemService: ItemServiceInterface by inject()

    override val items: Flow<List<Item>> = itemService.getItemsByTitleId(titleId)
}