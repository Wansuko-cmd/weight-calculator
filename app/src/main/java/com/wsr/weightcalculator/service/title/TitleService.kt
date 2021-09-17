package com.wsr.weightcalculator.service.title

import com.wsr.weightcalculator.entity.Title
import com.wsr.weightcalculator.repository.BaseRepositoryInterface
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.inject
import java.util.*

class TitleService : TitleServiceInterface {

    private val baseRepository: BaseRepositoryInterface by inject()

    override suspend fun getAllTitles(): Flow<List<Title>> {
        return baseRepository.getAllTitles()
    }

    override suspend fun insertTitle(name: String): Title {
        val newTitle = Title(UUID.randomUUID().toString(), name)
        baseRepository.insertTitle(newTitle)
        return newTitle
    }
}