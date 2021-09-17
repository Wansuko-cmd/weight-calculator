package com.wsr.weightcalculator.view.ui.main.route.index

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.wsr.weightcalculator.view.ui.main.route.index.alert_dialog.MainIndexAddButton
import com.wsr.weightcalculator.view.ui.main.route.index.alert_dialog.MakeTitleAlertDialog
import com.wsr.weightcalculator.view_model.index.IndexViewModelInterface
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.koin.androidx.compose.getViewModel

@Composable
fun MainIndex(
    onClickContent: (String) -> Unit
){
    val indexViewModel = getViewModel<IndexViewModelInterface>()
    val titles = indexViewModel.titles.collectAsState(initial = listOf())

    var showDialog by remember { mutableStateOf(false) }

    if(showDialog){
        MakeTitleAlertDialog(
            onClickConfirmButton = {
                runBlocking {
                    indexViewModel.insertTitle(it).collect {
                        onClickContent(it.id)
                    }
                }
            },
            onDismiss = { showDialog = false }
        )
    }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        for(title in titles.value){
            MainIndexTitleCard(
                title = title.name,
                onClick = { onClickContent(title.id) }
            )
        }
        MainIndexAddButton(onClick = { showDialog = true })
    }
}