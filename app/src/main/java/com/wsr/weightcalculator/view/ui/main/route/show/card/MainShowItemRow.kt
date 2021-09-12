package com.wsr.weightcalculator.view.ui.main.route.show.card

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.wsr.weightcalculator.R
import com.wsr.weightcalculator.entity.Item
import com.wsr.weightcalculator.view.ui.main.route.show.card.MainShowIconButton

@Composable
fun MainShowItemRow(
    onMinusClicked: () -> Unit,
    onPlusClicked: () -> Unit,
    item: Item
){

    Row(
        modifier = Modifier.padding(12.dp)
    ) {

        MainShowNameCard(
            item = item,
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(6.dp))

        MainShowIconButton(
            painter = painterResource(id = R.drawable.ic_baseline_remove_24),
            contentDescription = null,
            onClick = onMinusClicked
        )

        Spacer(modifier = Modifier.width(6.dp))

        MainShowIconButton(
            painter = painterResource(id = R.drawable.ic_baseline_add_24),
            contentDescription = null,
            onClick = onPlusClicked
        )
    }
}