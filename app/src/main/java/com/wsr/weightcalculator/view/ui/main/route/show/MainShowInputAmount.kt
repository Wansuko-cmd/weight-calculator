package com.wsr.weightcalculator.view.ui.main.route.show

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun MainShowInputAmount(
    onValueChange: (Int) -> Unit,
    modifier: Modifier = Modifier
){
    TextField(
        value = "",
        onValueChange = { onValueChange(it.toInt()) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = modifier
    )
}