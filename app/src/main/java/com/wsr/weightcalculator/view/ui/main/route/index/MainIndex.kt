package com.wsr.weightcalculator.view.ui.main.route.index

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainIndex(onClickContent: (Int) -> Unit){

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        for(i in 1..50){
            MainIndexTitleCard(title = "MainIndex #$i", onClick = { onClickContent(i) })
        }
    }
}