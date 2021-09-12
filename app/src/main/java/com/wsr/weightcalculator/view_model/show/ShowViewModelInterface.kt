package com.wsr.weightcalculator.view_model.show

import androidx.lifecycle.ViewModel
import com.wsr.weightcalculator.entity.Item
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.core.component.KoinComponent

abstract class ShowViewModelInterface : ViewModel(), KoinComponent{

    abstract val items: MutableStateFlow<List<Item>>

    abstract val standardAmount: MutableStateFlow<Int>

    abstract val result: MutableStateFlow<Int>

    abstract fun updateItems(items: List<Item>): Job

    abstract fun updateStandardAmount(newStandardAmount: Int): Job

    abstract fun plusNumberOfItem(item: Item): Job

    abstract fun minusNumberOfItem(item: Item): Job
}