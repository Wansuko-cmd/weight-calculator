package com.wsr.weightcalculator.view.ui.main.route.index.alert_dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun MakeTitleAlertDialog(
    onClickConfirmButton: (String) -> Unit,
    onDismiss: () -> Unit,
){
    val (title, setTitle) = remember { mutableStateOf("") }
    
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "タイトル名") },
        text = {
            Column {
                TextField(
                    value = title,
                    onValueChange = setTitle
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = { onClickConfirmButton(title) }
            ) {
                Text(text = "作成")
            }
        }
    )
}