package com.wsr.weightcalculator.view.ui.main.top_bar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.wsr.weightcalculator.view.ui.main.route.MainDestination

@Composable
fun MainTopBar(
    currentScreen: MainDestination,
    modifier: Modifier = Modifier
){
    when(currentScreen){
        MainDestination.INDEX -> MainIndexTopBar()
        MainDestination.CONTENT -> MainContentTopBar()
    }
}