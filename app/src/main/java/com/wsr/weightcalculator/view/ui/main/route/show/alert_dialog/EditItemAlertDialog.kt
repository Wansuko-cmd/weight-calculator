package com.wsr.weightcalculator.view.ui.main.route.show.alert_dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun EditItemAlertDialog(
    initialName: String = "",
    initialAmount: Int = 0,
    onClickConfirmButton: (String, Int) -> Unit,
    onDismiss: () -> Unit,
) {
    val (name, setName) = remember{ mutableStateOf(initialName) }
    val (amount, setAmount) = remember{ mutableStateOf(initialAmount.toString()) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "アイテム") },
        text = {
               Column {
                   TextField(
                       value = name,
                       onValueChange = setName,
                       placeholder = { Text(text = "アイテム名") }
                   )
                   TextField(
                       value = amount,
                       onValueChange = setAmount,
                       placeholder = { Text(text = "数量") },
                       keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                   )
               }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onClickConfirmButton(name, amount.toInt())
                    onDismiss()
                }
            ) {
                Text(text = "設定")
            }
        }
    )
}