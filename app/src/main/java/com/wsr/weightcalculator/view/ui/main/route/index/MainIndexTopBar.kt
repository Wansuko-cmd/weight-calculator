package com.wsr.weightcalculator.view.ui.main.route.index

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun MainIndexTopBar(){
    TopAppBar(
        title = { Text(text = "Main") }
    )
}