package com.wsr.weightcalculator.view.ui.main.route.show.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wsr.weightcalculator.entity.Item

@Composable
fun MainShowNameCard(
    item: Item,
    modifier: Modifier = Modifier
){
    Card(modifier = modifier) {
        Column(modifier = Modifier.padding(6.dp)) {
            Text(
                text = item.name,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = item.amount.toString(),
                modifier = Modifier.weight(1f)
            )
        }
    }
}