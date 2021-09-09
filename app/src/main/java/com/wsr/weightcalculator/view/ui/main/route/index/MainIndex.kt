package com.wsr.weightcalculator.view.ui.main.route.index

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainIndex(onClickContent: (Int) -> Unit){

    Scaffold(
        topBar = { MainIndexTopBar() }
    ) { innerPadding ->

        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            for(i in 1..50){
                Button(
                    onClick = { onClickContent(i) },
                    modifier = Modifier.padding(5.dp)
                ) {
                    Text(text = "MainIndex #$i")
                }
            }
        }
    }
}