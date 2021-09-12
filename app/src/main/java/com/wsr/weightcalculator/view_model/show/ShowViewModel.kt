package com.wsr.weightcalculator.view_model.show

import androidx.lifecycle.viewModelScope
import com.wsr.weightcalculator.entity.Item
import com.wsr.weightcalculator.service.item.ItemServiceInterface
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class ShowViewModel(val titleId: String) : ShowViewModelInterface(){

    private val itemService: ItemServiceInterface by inject()

    override var itemToNumber = MutableStateFlow<MutableMap<Item, Int>>(mutableMapOf())

    private val _standardAmount = MutableStateFlow(0)
    override val standardAmount: MutableStateFlow<Int> get() = _standardAmount

    private val _result = MutableStateFlow(0)
    override val result: MutableStateFlow<Int> get() = _result

    init {
        viewModelScope.launch {
            itemService.getItemsByTitleId(titleId).collect {
                itemToNumber.emit(
                    it.sortedBy { item -> item.order }
                        .associateWith { 0 }
                        .toMutableMap()
                )
            }
        }
    }

    override fun insertItem(name: String, amount: Int): Job = viewModelScope.launch {

        val newItem = async {
            itemService.insertItem(titleId, name, amount, itemToNumber.value.size + 1)
        }
        val tempItemToNumber = itemToNumber.value
        tempItemToNumber[newItem.await()] = 0
        itemToNumber.emit(tempItemToNumber)
    }

    override fun updateItems(items: List<Item>): Job =
        viewModelScope.launch { itemService.updateItems(items) }

    override fun updateStandardAmount(newStandardAmount: Int): Job = viewModelScope.launch {
        _standardAmount.emit(newStandardAmount)
        _result.emit(itemService.getResult(newStandardAmount, itemToNumber.value))
    }

    override fun updateNumberOfItem(item: Item, number: Int): Job = viewModelScope.launch {
        val tempItemToNumber = itemToNumber.value
        tempItemToNumber[item] = number
        itemToNumber.emit(tempItemToNumber)
        _result.emit(itemService.getResult(standardAmount.value, itemToNumber.value))
    }
}