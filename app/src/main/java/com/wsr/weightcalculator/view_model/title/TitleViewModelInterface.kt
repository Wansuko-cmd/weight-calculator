package com.wsr.weightcalculator.view_model.title

import androidx.lifecycle.ViewModel
import com.wsr.weightcalculator.entity.Title
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent

abstract class TitleViewModelInterface : ViewModel(), KoinComponent{

    abstract val titles: Flow<List<Title>>
}