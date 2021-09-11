package com.wsr.weightcalculator.view.ui.main.route.show

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.wsr.weightcalculator.view_model.show.ShowViewModelInterface
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun MainShow(titleId: Int){

    val showViewModel = getViewModel<ShowViewModelInterface>{ parametersOf(titleId) }
    val items = showViewModel.items.collectAsState(initial = listOf())

    Column(modifier = Modifier) {
        for (item in items.value){
            TextButton(onClick = { showViewModel.updateItems(listOf(item.copy(name = "Changed"))) }) {
                Text(text = "MainContents #${item.name}")
            }
        }
    }
}
