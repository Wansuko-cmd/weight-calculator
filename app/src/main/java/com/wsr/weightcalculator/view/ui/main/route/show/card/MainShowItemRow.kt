package com.wsr.weightcalculator.view.ui.main.route.show.card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.wsr.weightcalculator.R
import com.wsr.weightcalculator.entity.Item
import com.wsr.weightcalculator.view.ui.main.route.show.alert_dialog.EditItemAlertDialog

@Composable
fun MainShowItemRow(
    onValueChange: (Int) -> Unit,
    onItemUpdate: (Item) -> Unit,
    item: Item,
    number: Int
){
    var showDialog by remember { mutableStateOf(false) }

    if(showDialog){
        EditItemAlertDialog(
            initialName = item.name,
            initialAmount = item.amount,
            onClickConfirmButton = { name, amount ->
                onItemUpdate(Item(item.id, item.titleId, name, item.order, amount))
            },
            onDismiss = { showDialog = false }
        )
    }

    Row(
        modifier = Modifier.padding(12.dp)
    ) {

        MainShowNameCard(
            item = item,
            modifier = Modifier
                .weight(1f)
                .height(110.dp).clickable { showDialog = true }
        )

        Spacer(modifier = Modifier.width(6.dp))

        MainShowCountSetter(
            value = number,
            onValueChange = onValueChange,
            onMinusClicked = { if(number > 0) onValueChange(number - 1) },
            onPlusClicked = { onValueChange(number + 1) }
        )
    }
}