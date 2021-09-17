package com.wsr.weightcalculator.view.ui.main.route.show

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wsr.weightcalculator.view.ui.main.route.show.alert_dialog.EditItemAlertDialog
import com.wsr.weightcalculator.view.ui.main.route.show.card.MainShowItemRow
import com.wsr.weightcalculator.view_model.show.ShowViewModelInterface
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun MainShow(titleId: String){

    val showViewModel = getViewModel<ShowViewModelInterface>{ parametersOf(titleId) }
    val itemToNumber by showViewModel.itemToNumber.collectAsState()
    val standardAmount by showViewModel.standardAmount.collectAsState()
    val result by showViewModel.result.collectAsState()

    var showDialog by remember { mutableStateOf(false) }

    if(showDialog){
        EditItemAlertDialog(
            onClickConfirmButton = { name, amount ->
                showViewModel.insertItem(name, amount)
            },
            onDismiss = { showDialog = false }
        )
    }

    Column(modifier = Modifier.fillMaxSize()) {

        MainShowInputAmount(
            value = standardAmount,
            onValueChange = { showViewModel.updateStandardAmount(it) },
            modifier = Modifier.fillMaxWidth()
        )

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            item {
                for ((item, number) in itemToNumber) {
                    MainShowItemRow(
                        item = item,
                        number = number,
                        onValueChange = { showViewModel.updateNumberOfItem(item, it) },
                        onItemUpdate = { showViewModel.updateItem(it) }
                    )
                }
            }
            item{
                MainShowAddButton(
                    onClick = { showDialog = true },
                    modifier = Modifier.padding(12.dp)
                )
            }
        }

        MainShowResultScreen(
            result = result.toString(),
            modifier = Modifier.fillMaxWidth()
        )
    }
}
