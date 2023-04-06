package cx.example.ekartest.utils

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

/**
 * This composable is used for managing the navigation by using navigation controller in compose
 */
@Composable
fun NavigationController():NavController{
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenNames.viewMap.route){

    }
    return navController
}