package com.wsr.weightcalculator.view.ui.main.route.index

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun MainIndex(onClickContent: (Int) -> Unit){
    Button(onClick = { onClickContent(1) }) {
        Text(text = "MainIndex")
    }
}