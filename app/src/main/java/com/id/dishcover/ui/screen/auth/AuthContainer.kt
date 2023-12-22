package com.id.dishcover.ui.screen.auth;

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import com.id.dishcover.ui.screen.auth.login.LoginScreen
import com.id.dishcover.ui.screen.auth.register.RegisterScreen
import com.id.dishcover.ui.theme.DiSHCOVERTheme


enum class AuthContainer {
    LOGIN, REGISTER
}

@Composable
fun AuthContainer(
    modifier: Modifier = Modifier
) {
    val currentNav = remember { mutableStateOf(AuthContainer.REGISTER) }
    Column(modifier = modifier) {
        when (currentNav.value) {
            AuthContainer.LOGIN -> LoginScreen(navigateToRegister = {currentNav.value = AuthContainer.REGISTER})
            AuthContainer.REGISTER -> RegisterScreen(navigateToLogin = {currentNav.value = AuthContainer.LOGIN})
        }
    }
}

@Composable
@Preview
fun ShowAuthContainerPreview() {
    DiSHCOVERTheme {
        AuthContainer()
    }
}
