package cx.example.ekartest.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cx.example.ekartest.ui.screens.viewmap.ViewMapScreen
import cx.example.ekartest.ui.screens.viewonboard.ViewOnBoard
import cx.example.ekartest.ui.screens.viewvehicle.ViewVehicle
import cx.example.ekartest.utils.ScreenNames

@Composable

fun SetupNavGraph(
    navController: NavHostController

){
    NavHost(navController = navController, startDestination = ScreenNames.viewMap.route){
        composable(
            route = ScreenNames.viewMap.route
        ){
            ViewMapScreen(navController)
        }

        composable(
            route = ScreenNames.viewVehicle.route
        ){
            ViewVehicle(navController)
        }

        composable(
            route = ScreenNames.viewOnBoard.route
        ){
            ViewOnBoard(navController)
        }


    }
}