package com.wsr.weightcalculator.view.main.route

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wsr.weightcalculator.view.main.route.index.MainIndex

@Composable
fun MainRoute(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MainRouteDestination.INDEX
    ){
        composable(MainRouteDestination.INDEX) { MainIndex() }
    }
}

class MainRouteDestination{
    companion object{
        const val INDEX = "index"
    }
}
