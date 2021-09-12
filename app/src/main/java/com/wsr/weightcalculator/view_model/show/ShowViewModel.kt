package com.wsr.weightcalculator.view_model.show

import androidx.compose.runtime.toMutableStateMap
import androidx.lifecycle.viewModelScope
import com.wsr.weightcalculator.entity.Item
import com.wsr.weightcalculator.service.item.ItemServiceInterface
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class ShowViewModel(val titleId: Int) : ShowViewModelInterface(){

    private val itemService: ItemServiceInterface by inject()

    private val _items = MutableStateFlow<List<Item>>(listOf())
    override val items: MutableStateFlow<List<Item>> get() = _items

    private val _standardAmount = MutableStateFlow(0)
    override val standardAmount: MutableStateFlow<Int> get() = _standardAmount

    private var itemToNumber: MutableMap<Item, Int> = mutableMapOf()

    private val _result = MutableStateFlow(0)
    override val result: MutableStateFlow<Int> get() = _result

    init {
        viewModelScope.launch {
            itemService.getItemsByTitleId(titleId).collect {
                _items.emit(it)
            }
            items.collect{ itemToNumber = it.map { item -> item to 0 }.toMutableStateMap() }
        }
    }

    override fun updateItems(items: List<Item>): Job =
        viewModelScope.launch { itemService.updateItems(items) }

    override fun updateStandardAmount(newStandardAmount: Int): Job = viewModelScope.launch {
        _standardAmount.emit(newStandardAmount)
        _result.emit(itemService.getResult(newStandardAmount, itemToNumber))
    }

    override fun plusNumberOfItem(item: Item): Job = viewModelScope.launch {
        itemToNumber[item] = itemToNumber[item]!!.plus(1)
        _result.emit(itemService.getResult(standardAmount.value, itemToNumber))
    }

    override fun minusNumberOfItem(item: Item): Job = viewModelScope.launch {
        itemToNumber[item] = itemToNumber[item]!!.minus(1)
        _result.emit(itemService.getResult(standardAmount.value, itemToNumber))
    }
}