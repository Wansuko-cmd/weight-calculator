package com.wsr.weightcalculator.view_model.show

import androidx.lifecycle.ViewModel
import com.wsr.weightcalculator.entity.Item
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.core.component.KoinComponent

abstract class ShowViewModelInterface : ViewModel(), KoinComponent{

    abstract val itemToNumber: MutableStateFlow<MutableMap<Item, Int>>

    abstract val standardAmount: MutableStateFlow<Int>

    abstract val result: MutableStateFlow<Int>

    abstract fun insertItem(name: String, amount: Int): Job

    abstract fun updateItems(items: List<Item>): Job

    abstract fun updateStandardAmount(newStandardAmount: Int): Job

    abstract fun updateNumberOfItem(item: Item, number: Int): Job
}