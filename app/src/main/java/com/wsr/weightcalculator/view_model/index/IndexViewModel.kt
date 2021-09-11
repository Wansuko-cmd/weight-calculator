package com.wsr.weightcalculator.view_model.index

import androidx.lifecycle.viewModelScope
import com.wsr.weightcalculator.entity.Title
import com.wsr.weightcalculator.service.title.TitleServiceInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class IndexViewModel() : IndexViewModelInterface() {

    private val titleService: TitleServiceInterface by inject()

    private val _titles = MutableStateFlow<List<Title>>(listOf())
    override val titles: MutableStateFlow<List<Title>> get() = _titles

    init{
        viewModelScope.launch {
            titleService.getAllTitles().collect {
                _titles.emit(it)
            }
        }
    }
}