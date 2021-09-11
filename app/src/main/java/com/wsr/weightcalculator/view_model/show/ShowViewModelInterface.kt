package com.wsr.weightcalculator.view_model.show

import androidx.lifecycle.ViewModel
import com.wsr.weightcalculator.entity.Item
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.core.component.KoinComponent

abstract class ShowViewModelInterface : ViewModel(), KoinComponent{

    abstract val items: MutableStateFlow<List<Item>>

    abstract val result: MutableStateFlow<Int>

    abstract suspend fun updateItems(items: List<Item>)
}