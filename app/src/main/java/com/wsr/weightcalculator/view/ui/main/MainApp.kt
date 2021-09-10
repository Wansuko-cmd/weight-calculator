package com.wsr.weightcalculator.view.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.wsr.weightcalculator.view.ui.main.route.MainDestination
import com.wsr.weightcalculator.view.ui.main.route.MainNavHost
import com.wsr.weightcalculator.view.ui.main.top_bar.MainTopBar
import com.wsr.weightcalculator.view.ui.theme.WeightCalculatorTheme

@Composable
fun MainApp(){
    WeightCalculatorTheme( darkTheme = true ) {
        val navController = rememberNavController()
        val route = navController.currentBackStackEntryAsState()
        val currentScreen = MainDestination.fromRoute(
            route.value?.destination?.route
        )

        Scaffold(
            topBar = { MainTopBar(currentScreen = currentScreen) }
        ) {
            MainNavHost(
                navController = navController,
                modifier = Modifier.padding(it)
            )
        }
    }
}