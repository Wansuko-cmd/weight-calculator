package com.wsr.weightcalculator.view.ui.main.route.show

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.wsr.weightcalculator.view.ui.main.route.show.card.MainShowItemRow
import com.wsr.weightcalculator.view_model.show.ShowViewModelInterface
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun MainShow(titleId: Int){

    val showViewModel = getViewModel<ShowViewModelInterface>{ parametersOf(titleId) }
    val items = showViewModel.items.collectAsState(initial = listOf())

    LazyColumn(modifier = Modifier) {
        item{
            for (item in items.value){
                MainShowItemRow(item = item)
            }
        }
    }
}
