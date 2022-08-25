package com.example.mymoneymanagementapp.ui.routes

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.mymoneymanagementapp.R

data class TopLevelDestinations(
    val route: String,
    val title: String,
    @DrawableRes val defaultIcon: Int,
    @DrawableRes val selectedIcon: Int,
)

object Destinations {
    const val HOME_ROUTE = "home"
    const val REPORTS_ROUTE = "reports"
    const val SETTINGS_ROUTE = "settings"
    const val ALL_ACTIVITIES_ROUTE = "all_activities"
    const val ADD_ACTIVITY_ROUTE = "add_activity"
    const val DETAIL_ACTIVITY_ROUTE = "detail_activity"
    const val EDIT_ACTIVITY_ROUTE = "edit_activity"

    val topLevelDestinations = listOf(
        TopLevelDestinations(
            route = HOME_ROUTE,
            title = "Home",
            defaultIcon = R.drawable.home_outlined,
            selectedIcon = R.drawable.home_filled,
        ),
        TopLevelDestinations(
            route = REPORTS_ROUTE,
            title = "Reports",
            defaultIcon = R.drawable.insert_chart_outlined,
            selectedIcon = R.drawable.insert_chart_filled
        ),
        TopLevelDestinations(
            route = SETTINGS_ROUTE,
            title = "Settings",
            defaultIcon = R.drawable.settings_outlined,
            selectedIcon = R.drawable.settings_filled,
        )
    )
}

class NavigationActions(private val navController: NavHostController) {
    fun navigateWithStartDestination(destinations: String) {
        navController.navigate(destinations){
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            Log.d("NavGraph ", navController.graph.findStartDestination().id.toString())
            Log.d("NavGraph ", navController.graph.findStartDestination().route.toString())
            Log.d("NavGraph ", navController.currentDestination?.route.toString())
            launchSingleTop = true
            restoreState = true
        }
    }
    fun navigateWithInclusive(destinations: String){
        navController.navigate(destinations){
            popUpTo(navController.graph.findStartDestination().id){
                inclusive = true
            }
            Log.d("NavGraph ", navController.currentDestination?.route.toString())
            launchSingleTop = true
        }
    }
    fun navigateWithCurrentDestination(destinations: String){
        navController.navigate(destinations){
            popUpTo(navController.currentDestination?.id!!){
//                inclusive = true
            }
            launchSingleTop = true
        }
    }

}