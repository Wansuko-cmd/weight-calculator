package com.wsr.weightcalculator.view.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.wsr.weightcalculator.view.ui.main.route.MainNavHost
import com.wsr.weightcalculator.view.ui.theme.WeightCalculatorTheme

@Composable
fun MainApp(){
    WeightCalculatorTheme {
        val navController = rememberNavController()

        Scaffold() { innerPadding ->
            MainNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}