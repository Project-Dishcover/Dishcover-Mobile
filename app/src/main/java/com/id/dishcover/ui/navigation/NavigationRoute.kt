package com.id.dishcover.ui.navigation



sealed class NavigationRoute(val routeName: String) {
    object ScanRoute: NavigationRoute("scanScreen")
    object PantryRoute: NavigationRoute("pantryScreen")
    object HomeRoute: NavigationRoute("homeScreen")
    object ProfileRoute: NavigationRoute("profileScreen")
    object LikedRoute: NavigationRoute("likedScreen")
}
