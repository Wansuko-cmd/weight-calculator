package com.wsr.weightcalculator.view.ui.main.route.show

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.wsr.weightcalculator.R

@Composable
fun MainShowAddButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Card(modifier = modifier) {
        IconButton(
            onClick = onClick,
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_add_24),
                contentDescription = null
            )
        }
    }
}