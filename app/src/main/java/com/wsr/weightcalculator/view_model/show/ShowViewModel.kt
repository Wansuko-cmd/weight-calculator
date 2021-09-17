package com.wsr.weightcalculator.view_model.show

import androidx.lifecycle.viewModelScope
import com.wsr.weightcalculator.entity.Item
import com.wsr.weightcalculator.service.item.ItemServiceInterface
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class ShowViewModel(val titleId: String) : ShowViewModelInterface(){

    private val itemService: ItemServiceInterface by inject()

    private var _itemToNumber = MutableStateFlow<Map<Item, Int>>(mutableMapOf())
    override val itemToNumber get() = _itemToNumber

    private val _standardAmount = MutableStateFlow(0)
    override val standardAmount get() = _standardAmount

    private val _result = MutableStateFlow(0)
    override val result get() = _result

    init {
        viewModelScope.launch {
            itemService.getItemsByTitleId(titleId).collect {
                _itemToNumber.emit(
                    it.sortedBy { item -> item.order }
                        .associateWith { 0 }
                        .toMutableMap()
                )
            }
        }
    }

    override fun insertItem(name: String, amount: Int): Job = viewModelScope.launch {

        val newItem = async {
            itemService.insertItem(titleId, name, _itemToNumber.value.size + 1, amount)
        }
        _itemToNumber.emit(_itemToNumber.value + mapOf(newItem.await() to 0))
    }

    override fun updateItem(item: Item): Job = viewModelScope.launch {
        itemService.updateItems(item)
        _itemToNumber.emit(
            _itemToNumber.value
                .map { if(it.key.id == item.id) item to it.value else it.key to it.value }
                .toMap()
        )
        _result.emit(itemService.getResult(standardAmount.value, _itemToNumber.value))
    }

    override fun updateStandardAmount(newStandardAmount: Int): Job = viewModelScope.launch {
        _standardAmount.emit(newStandardAmount)
        _result.emit(itemService.getResult(newStandardAmount, _itemToNumber.value))
    }

    override fun updateNumberOfItem(item: Item, number: Int): Job = viewModelScope.launch {
        _itemToNumber.emit(
            _itemToNumber.value
                .map { if(it.key == item) it.key to number else it.key to it.value }
                .toMap()
        )
        _result.emit(itemService.getResult(standardAmount.value, _itemToNumber.value))
    }
}