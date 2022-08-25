package com.example.mymoneymanagementapp.ui.routes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mymoneymanagementapp.ui.features.addActivity.AddActivityScreen
import com.example.mymoneymanagementapp.ui.features.detail.DetailActivityScreen
import com.example.mymoneymanagementapp.ui.features.detail.EditActivityScreen
import com.example.mymoneymanagementapp.ui.features.home.AllActivitiesScreen
import com.example.mymoneymanagementapp.ui.features.home.HomeScreen
import com.example.mymoneymanagementapp.ui.features.settings.SettingsScreen

@Composable
fun NavigationGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestinations: String = Destinations.HOME_ROUTE,
) {
    val navActions = remember(navController) {
        NavigationActions(navController)
    }
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestinations
    ) {
        composable(Destinations.HOME_ROUTE) {
            HomeScreen(navActions::navigateWithStartDestination)
        }
        composable(Destinations.REPORTS_ROUTE) {
//            ReportsScreen()
        }
        composable(Destinations.SETTINGS_ROUTE) {
            SettingsScreen(navController)
        }
        composable(Destinations.ALL_ACTIVITIES_ROUTE) {
            AllActivitiesScreen(navigateTo = navActions::navigateWithStartDestination)
        }
        composable(Destinations.ADD_ACTIVITY_ROUTE) {
            AddActivityScreen(navigateTo = navActions::navigateWithInclusive)
        }
        composable(route = "${Destinations.DETAIL_ACTIVITY_ROUTE}/{${Arguments.ARGS_ID}}",
            arguments = listOf(
                navArgument(Arguments.ARGS_ID) {
                    type = NavType.IntType
                }
            )) {
            DetailActivityScreen(
                navigateTo = navActions::navigateWithCurrentDestination,
                activityId = it.arguments?.getInt(Arguments.ARGS_ID),
            )
        }
//        composable(
//            route = "${Destinations.EDIT_ACTIVITY_ROUTE}?id={${Arguments.ARGS_ID}}&name={${Arguments.ARGS_NAME}}&amount={${Arguments.ARGS_AMOUNT}}&date={${Arguments.ARGS_DATE}}&isExpense={${Arguments.ARGS_ISEXPENSE}}",
//            arguments = listOf(
//                navArgument(Arguments.ARGS_ID) {
//                    type = NavType.IntType
//                },
//                navArgument(Arguments.ARGS_NAME) {
//                    type = NavType.StringType
//                },
//                navArgument(Arguments.ARGS_AMOUNT) {
//                    type = NavType.LongType
//                },
//                navArgument(Arguments.ARGS_DATE) {
//                    type = NavType.StringType
//                },
//                navArgument(Arguments.ARGS_ISEXPENSE) {
//                    type = NavType.BoolType
//                }
//
//            ),
//        ) {
//            EditActivityScreen(
//                activityId = it.arguments?.getInt(Arguments.ARGS_ID),
//                navigateTo = navActions::navigateWithInclusive
//            )
//        }
        composable("${Destinations.EDIT_ACTIVITY_ROUTE}/{${Arguments.ARGS_ID}}", arguments = listOf(
            navArgument(Arguments.ARGS_ID) {
                type = NavType.IntType
            }
        )) {
            EditActivityScreen(
                activityId = it.arguments?.getInt(Arguments.ARGS_ID),
                navigateTo = navActions::navigateWithInclusive
            )
        }
    }
}

object Arguments {
    const val ARGS_ID = "args_id"
    const val ARGS_NAME = "args_name"
    const val ARGS_AMOUNT = "args_amount"
    const val ARGS_DATE = "args_date"
    const val ARGS_ISEXPENSE = "args_isExpense"
}