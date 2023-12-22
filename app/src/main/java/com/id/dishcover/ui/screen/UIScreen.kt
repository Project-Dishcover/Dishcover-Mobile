package com.id.dishcover.ui.screen;

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.id.dishcover.ui.navigation.homeNavigation
import com.id.dishcover.ui.navigation.navigationItem
import com.id.dishcover.ui.theme.DarkGreen500
import com.id.dishcover.ui.theme.DiSHCOVERTheme
import kotlinx.coroutines.launch


  


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UIScreen(
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }

    val currentRoute = remember { mutableStateOf(navigationItem[1]) }
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color.White
            ) {
                navigationItem.forEachIndexed { _, navItem ->
                    NavigationBarItem(
                        selected = currentRoute.value.screen == navItem.screen,
                        onClick = {
                            try {
                                navController.navigate(navItem.screen)
                                currentRoute.value = navItem
                            } catch (_: Exception) {
                                scope.launch {
                                    snackBarHostState.showSnackbar("This ${navItem.screen} Coming Soon")
                                }
                            }
                        },
                        icon = {
                            Icon(painter = painterResource(id = navItem.icon),
                                modifier = Modifier.size(35.dp),
                                contentDescription = null,
                                tint = if (currentRoute.value.screen == navItem.screen) DarkGreen500 else Color.Unspecified
                            )
                        }
                    )
                }
            }
        },
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        },
    ) {innerPadding ->
        NavHost(navController = navController, startDestination = "homeRoute", modifier = Modifier.padding(innerPadding)) {
            homeNavigation(navController)
        }
    }
}

@Composable
@Preview
fun ShowUIScreenPreview() {
    DiSHCOVERTheme {
        UIScreen()
    }
}
