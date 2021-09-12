package com.wsr.weightcalculator.view.ui.main.route.show

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wsr.weightcalculator.view.ui.main.route.show.card.MainShowItemRow
import com.wsr.weightcalculator.view_model.show.ShowViewModelInterface
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun MainShow(titleId: String){

    val showViewModel = getViewModel<ShowViewModelInterface>{ parametersOf(titleId) }
    val itemToNumber = showViewModel.itemToNumber.collectAsState()
    val standardAmount = showViewModel.standardAmount.collectAsState()
    val result = showViewModel.result.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {

        MainShowInputAmount(
            value = standardAmount.value,
            onValueChange = { showViewModel.updateStandardAmount(it) },
            modifier = Modifier.fillMaxWidth()
        )

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            item {
                for ((item, number) in itemToNumber.value) {
                    MainShowItemRow(
                        item = item,
                        number = number,
                        onValueChange = { showViewModel.updateNumberOfItem(item, it) }
                    )
                }
            }
            item{
                MainShowAddButton(
                    onClick = { showViewModel.insertItem("TEST", 50) },
                    modifier = Modifier.padding(12.dp)
                )
            }
        }

        MainShowResultScreen(
            result = result.value.toString(),
            modifier = Modifier.fillMaxWidth()
        )
    }
}
