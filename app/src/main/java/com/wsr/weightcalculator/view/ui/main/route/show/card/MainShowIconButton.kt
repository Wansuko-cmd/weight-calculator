package com.wsr.weightcalculator.view.ui.main.route.show.card

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun MainShowIconButton(
    painter: Painter,
    contentDescription: String?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
){
    Card(
        modifier = modifier
    ) {
        IconButton(
            onClick = onClick,
            modifier = Modifier.padding(4.dp)
        ) {
            Icon(
                painter = painter,
                contentDescription = contentDescription
            )
        }
    }
}