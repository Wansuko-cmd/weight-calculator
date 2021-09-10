package com.wsr.weightcalculator.view_model.index

import androidx.lifecycle.ViewModel
import com.wsr.weightcalculator.entity.Title
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent

abstract class IndexViewModelInterface : ViewModel(), KoinComponent{

    abstract val titles: Flow<List<Title>>
}