package com.wsr.weightcalculator.di

import com.wsr.weightcalculator.repository.BaseRepositoryInterface
import com.wsr.weightcalculator.repository.TestRepository
import com.wsr.weightcalculator.service.title.TitleService
import com.wsr.weightcalculator.service.title.TitleServiceInterface
import com.wsr.weightcalculator.view_model.title.TitleViewModel
import com.wsr.weightcalculator.view_model.title.TitleViewModelInterface
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val testModule = module {
    factory<TitleServiceInterface> { TitleService() }
    factory<BaseRepositoryInterface> { TestRepository() }

    viewModel<TitleViewModelInterface> { TitleViewModel() }
}