package com.wsr.weightcalculator.view.ui.main.route.show

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
    val items = showViewModel.itemToNumber.collectAsState()
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
                for ((item, number) in items.value) {
                    MainShowItemRow(
                        item = item,
                        number = number,
                        onMinusClicked = { showViewModel.updateNumberOfItem(item, it) },
                        onPlusClicked = { showViewModel.updateNumberOfItem(item, it) }
                    )
                }
            }
        }

        MainShowResultScreen(
            result = result.value.toString(),
            modifier = Modifier.fillMaxWidth()
        )
    }
}
