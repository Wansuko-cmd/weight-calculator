package com.wsr.weightcalculator.view.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.wsr.weightcalculator.view.ui.main.route.MainNavHost
import com.wsr.weightcalculator.view.ui.theme.WeightCalculatorTheme

@Composable
fun MainApp(){
    WeightCalculatorTheme {
        val navController = rememberNavController()

        MainNavHost(
            navController = navController
        )
    }
}