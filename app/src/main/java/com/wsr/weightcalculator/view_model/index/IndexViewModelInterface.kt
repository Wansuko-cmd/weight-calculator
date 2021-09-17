package com.wsr.weightcalculator.view_model.index

import androidx.lifecycle.ViewModel
import com.wsr.weightcalculator.entity.Title
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.core.component.KoinComponent

abstract class IndexViewModelInterface : ViewModel(), KoinComponent{

    abstract val titles: MutableStateFlow<List<Title>>

    abstract fun insertTitle(name: String): Flow<Title>
}