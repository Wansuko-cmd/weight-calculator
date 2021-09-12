package com.wsr.weightcalculator.view.ui.main.route

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.wsr.weightcalculator.view.ui.main.route.index.MainIndex
import com.wsr.weightcalculator.view.ui.main.route.show.MainShow

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = MainDestination.INDEX.name,
        modifier = modifier
    ){

        //Index
        composable(MainDestination.INDEX.name){
            MainIndex(
                onClickContent = { titleId ->
                    navigateToContent(navController, titleId)
                }
            )
        }

        //Content
        composable(
            route = "${MainDestination.SHOW.name}/{titleId}",
            arguments = listOf(
                navArgument("titleId"){
                    type = NavType.StringType
                }
            )
        ){  backStackEntry ->

            backStackEntry.arguments?.getString("titleId")?.let{ titleId ->
                MainShow(titleId = titleId)
            }
        }
    }
}

private fun navigateToContent(
    navController: NavHostController,
    titleId: String
){
    navController.navigate("${MainDestination.SHOW.name}/$titleId")
}
