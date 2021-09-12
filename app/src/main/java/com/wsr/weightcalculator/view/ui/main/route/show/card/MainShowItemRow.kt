package com.wsr.weightcalculator.view.ui.main.route.show.card

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.wsr.weightcalculator.R
import com.wsr.weightcalculator.entity.Item

@Composable
fun MainShowItemRow(
    onMinusClicked: (Int) -> Unit,
    onPlusClicked: (Int) -> Unit,
    item: Item,
    number: Int
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
            onClick = { onMinusClicked(number - 1) }
        )

        Spacer(modifier = Modifier.width(6.dp))

        MainShowIconButton(
            painter = painterResource(id = R.drawable.ic_baseline_add_24),
            contentDescription = null,
            onClick = { onPlusClicked(number + 1) }
        )
    }
}