package com.wsr.weightcalculator.service.title

import com.wsr.weightcalculator.entity.Title
import com.wsr.weightcalculator.repository.BaseRepositoryInterface
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.inject

class TitleService : TitleServiceInterface {

    private val baseRepository: BaseRepositoryInterface by inject()

    override fun getAllTitles(): Flow<List<Title>> {
        return baseRepository.getAllTitles()
    }
}