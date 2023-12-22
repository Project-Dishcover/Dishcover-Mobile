package com.id.dishcover.ui.navigation

import com.id.dishcover.R


data class NavigationItem(
    val icon: Int,
    val screen: String,
)
val navigationItem = listOf(
    NavigationItem(
        icon =  R.drawable.icon_home,
        screen = NavigationRoute.HomeRoute.routeName

    ),
    NavigationItem(
        icon =  R.drawable.icon_store,
        screen = NavigationRoute.PantryRoute.routeName
    ),
    NavigationItem(
        icon =  R.drawable.scan_vegetable,
        screen = NavigationRoute.ScanRoute.routeName
    ),
    NavigationItem(
        icon =  R.drawable.icon_thumbs,
        screen = NavigationRoute.LikedRoute.routeName
    ),
    NavigationItem(
        icon =  R.drawable.icon_profile,
        screen = NavigationRoute.ProfileRoute.routeName
    ),

)