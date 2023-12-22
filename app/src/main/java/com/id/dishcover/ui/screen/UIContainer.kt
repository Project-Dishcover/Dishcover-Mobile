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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.id.dishcover.ui.navigation.homeNavigation
import com.id.dishcover.ui.navigation.navigationItem
import com.id.dishcover.ui.screen.auth.AuthContainer
import com.id.dishcover.ui.theme.DarkGreen500
import com.id.dishcover.ui.theme.DiSHCOVERTheme
import kotlinx.coroutines.launch



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UIContainer(
    modifier: Modifier = Modifier,
    viewModel: UIViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()


    LaunchedEffect(Unit) {
        viewModel.fetchIsLogin()
    }

    when (uiState.value.isLogin) {
        true -> UIScreen()
        false -> AuthContainer()
    }
}

@Composable
@Preview
fun ShowUIContainerPreview() {
    DiSHCOVERTheme {
        UIContainer()
    }
}
