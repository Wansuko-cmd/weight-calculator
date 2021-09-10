package com.wsr.weightcalculator.view_model.show

import androidx.lifecycle.ViewModel
import com.wsr.weightcalculator.entity.Item
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent

abstract class ShowViewModelInterface : ViewModel(), KoinComponent{

    abstract val items: Flow<List<Item>>
}