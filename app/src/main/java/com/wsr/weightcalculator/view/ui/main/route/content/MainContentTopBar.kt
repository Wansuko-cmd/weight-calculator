package com.wsr.weightcalculator.view.ui.main.route.content

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun MainContentTopBar(){
    TopAppBar(
        title = { Text(text = "Content") }
    )
}