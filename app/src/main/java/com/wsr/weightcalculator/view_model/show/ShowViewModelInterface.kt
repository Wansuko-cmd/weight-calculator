package com.wsr.weightcalculator.view_model.show

import androidx.lifecycle.ViewModel
import com.wsr.weightcalculator.entity.Item
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.koin.core.component.KoinComponent

abstract class ShowViewModelInterface : ViewModel(), KoinComponent{

    abstract val itemToNumber: StateFlow<Map<Item, Int>>

    abstract val standardAmount: StateFlow<Int>

    abstract val result: StateFlow<Int>

    abstract fun insertItem(name: String, amount: Int): Job

    abstract fun updateItem(item: Item): Job

    abstract fun updateStandardAmount(newStandardAmount: Int): Job

    abstract fun updateNumberOfItem(item: Item, number: Int): Job
}