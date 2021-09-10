package com.wsr.weightcalculator.repository

import com.wsr.weightcalculator.entity.Contents
import com.wsr.weightcalculator.entity.Title
import kotlinx.coroutines.flow.Flow

interface BaseRepositoryInterface {

    fun getAllTitles(): Flow<List<Title>>

    fun getContentsByTitleId(titleId: Int): Flow<List<Contents>>
}