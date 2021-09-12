package com.wsr.weightcalculator.view.ui.main.route.show.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.wsr.weightcalculator.R

@Composable
fun MainShowCountSetter(
    value: Int,
    onValueChange: (Int) -> Unit,
    onMinusClicked: () -> Unit,
    onPlusClicked: () -> Unit,
    modifier: Modifier = Modifier
){
    Card(modifier = modifier) {
        Column(modifier = Modifier.width(120.dp)) {
            Row {
                MainShowIconButton(
                    painter = painterResource(id = R.drawable.ic_baseline_remove_24),
                    contentDescription = null,
                    onClick = onMinusClicked,
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(6.dp))

                MainShowIconButton(
                    painter = painterResource(id = R.drawable.ic_baseline_add_24),
                    contentDescription = null,
                    onClick = onPlusClicked,
                    modifier = Modifier.weight(1f)
                )
            }

            TextField(
                value = value.toString(),
                onValueChange = { onValueChange(if(it.isNotBlank()) it.toInt() else 0) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    textColor = Color.Black
                )
            )
        }
    }
}