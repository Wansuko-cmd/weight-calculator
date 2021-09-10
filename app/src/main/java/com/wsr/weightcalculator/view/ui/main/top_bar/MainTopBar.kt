package com.wsr.weightcalculator.view.ui.main.top_bar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.wsr.weightcalculator.view.ui.main.route.MainDestination

@Composable
fun MainTopBar(
    currentScreen: MainDestination,
    modifier: Modifier = Modifier
){
    when(currentScreen){
        MainDestination.INDEX -> MainIndexTopBar()
        MainDestination.SHOW -> MainShowTopBar()
    }
}