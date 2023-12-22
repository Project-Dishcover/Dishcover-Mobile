package com.id.dishcover.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.id.dishcover.ui.screen.pantry.PantryContainer
import com.id.dishcover.ui.screen.profile.ProfileContainer
import com.id.dishcover.ui.screen.scan.ScanContainer


fun NavGraphBuilder.homeNavigation(navController: NavController){
    navigation(startDestination = NavigationRoute.PantryRoute.routeName, route = "homeRoute") {
        composable(NavigationRoute.PantryRoute.routeName){
            PantryContainer()
        }
        composable(NavigationRoute.ProfileRoute.routeName) {
            ProfileContainer()
        }
        composable(NavigationRoute.ScanRoute.routeName) {
            ScanContainer()
        }
    }
}
