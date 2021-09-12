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
    onValueChange: (Int) -> Unit,
    item: Item,
    number: Int
){

    Row(
        modifier = Modifier.padding(12.dp)
    ) {

        MainShowNameCard(
            item = item,
            modifier = Modifier.weight(1f).height(110.dp)
        )

        Spacer(modifier = Modifier.width(6.dp))

        MainShowCountSetter(
            value = number,
            onValueChange = onValueChange,
            onMinusClicked = { onValueChange(number - 1) },
            onPlusClicked = { onValueChange(number + 1) }
        )
    }
}