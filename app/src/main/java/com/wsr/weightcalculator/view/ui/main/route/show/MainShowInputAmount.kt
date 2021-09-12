package com.wsr.weightcalculator.view.ui.main.route.show

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun MainShowInputAmount(
    value: Int,
    onValueChange: (Int) -> Unit,
    modifier: Modifier = Modifier
){
    TextField(
        value = value.toString(),
        onValueChange = { onValueChange(if(it.isNotBlank()) it.toInt() else 0) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = modifier
    )
}