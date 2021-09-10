package com.wsr.weightcalculator.view_model.index

import com.wsr.weightcalculator.entity.Title
import com.wsr.weightcalculator.service.title.TitleServiceInterface
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.inject

class IndexViewModel() : IndexViewModelInterface() {

    private val titleService: TitleServiceInterface by inject()

    override val titles: Flow<List<Title>> = titleService.getAllTitles()
}