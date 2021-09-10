package com.wsr.weightcalculator.view.ui.main.route.index

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.wsr.weightcalculator.view_model.title.TitleViewModelInterface
import org.koin.androidx.compose.getViewModel

@Composable
fun MainIndex(
    onClickContent: (Int) -> Unit
){
    val titleViewModel = getViewModel<TitleViewModelInterface>()
    val titles = titleViewModel.titles.collectAsState(initial = listOf())

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        for(title in titles.value){
            MainIndexTitleCard(
                title = "MainIndex #${title.name}",
                onClick = { onClickContent(title.id) }
            )
        }
    }
}