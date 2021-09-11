package com.wsr.weightcalculator.view.ui.main.route.show

import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainShowResultScreen(
    result: String,
    modifier: Modifier = Modifier
){
    Card(modifier = modifier) {
        Text(text = result)
    }
}