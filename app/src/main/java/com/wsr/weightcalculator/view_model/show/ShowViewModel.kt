package com.wsr.weightcalculator.view_model.show

import androidx.lifecycle.viewModelScope
import com.wsr.weightcalculator.entity.Item
import com.wsr.weightcalculator.service.item.ItemServiceInterface
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class ShowViewModel(val titleId: Int) : ShowViewModelInterface(){

    private val itemService: ItemServiceInterface by inject()

    private val _items = MutableStateFlow<List<Item>>(listOf())
    override val items: MutableStateFlow<List<Item>> get() = _items

    private val _result = MutableStateFlow(0)
    override val result: MutableStateFlow<Int> get() = _result

    init {
        viewModelScope.launch {
            itemService.getItemsByTitleId(titleId).collect {
                _items.emit(it)
            }
        }
    }

    override suspend fun updateItems(items: List<Item>) = itemService.updateItems(items)
}