package com.wsr.weightcalculator.di

import com.wsr.weightcalculator.repository.BaseRepositoryInterface
import com.wsr.weightcalculator.repository.TestRepository
import com.wsr.weightcalculator.service.item.ItemService
import com.wsr.weightcalculator.service.item.ItemServiceInterface
import com.wsr.weightcalculator.service.title.TitleService
import com.wsr.weightcalculator.service.title.TitleServiceInterface
import com.wsr.weightcalculator.view_model.index.IndexViewModel
import com.wsr.weightcalculator.view_model.index.IndexViewModelInterface
import com.wsr.weightcalculator.view_model.show.ShowViewModel
import com.wsr.weightcalculator.view_model.show.ShowViewModelInterface
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val testModule = module {

    factory<TitleServiceInterface> { TitleService() }
    factory<ItemServiceInterface> { ItemService() }

    factory<BaseRepositoryInterface> { TestRepository() }

    viewModel<IndexViewModelInterface> { IndexViewModel() }
    viewModel<ShowViewModelInterface> { params -> ShowViewModel(titleId = params.get()) }
}