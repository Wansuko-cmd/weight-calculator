package com.wsr.weightcalculator.service.title

import com.wsr.weightcalculator.entity.Title
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent

interface TitleServiceInterface : KoinComponent{

    fun getAllTitles(): Flow<List<Title>>
}