package com.id.dishcover.ui.screen.auth.login;

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.id.dishcover.R
import com.id.dishcover.ui.component.button.PrimaryButton
import com.id.dishcover.ui.component.button.SecondaryButton
import com.id.dishcover.ui.component.field.TextField
import com.id.dishcover.ui.theme.DarkGreen500
import com.id.dishcover.ui.theme.DiSHCOVERTheme
import com.id.dishcover.ui.theme.Green500
import com.id.dishcover.ui.theme.Typography
import com.id.dishcover.ui.theme.Yellow500


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navigateToRegister: () -> Unit = {}
) {
    val viewModel: LoginViewModel = hiltViewModel()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }

    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    LaunchedEffect(key1 = uiState.value.isError) {
        if (uiState.value.isError) {
            snackBarHostState.showSnackbar(uiState.value.errorMessage)
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
    ) {
        Column(
            modifier = modifier.padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .background(Green500)
                    .padding(horizontal = 50.dp)
                    .padding(top = 50.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Selamat Datang \ndi DiSHCOVER", style = Typography.titleLarge)
                Image(
                    painter = painterResource(id = R.drawable.login_image),
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .border(BorderStroke(20.dp, DarkGreen500))
                        .aspectRatio(36f / 24f),
                    contentDescription = null
                )
                TextField(
                    modifier = Modifier.padding(top = 30.dp),
                    leadingIcon = Icons.Default.Person,
                    text = "Username",
                    value = username.value,
                    onTextChange = {
                        username.value = it
                    }
                )
                TextField(
                    modifier = Modifier.padding(vertical = 30.dp),
                    leadingIcon = Icons.Default.Lock,
                    hideValue = true,
                    text = "Password",
                    value = password.value,
                    onTextChange = {
                        password.value = it
                    }
                )
            }
            PrimaryButton(
                text = "Login", modifier = Modifier
                    .padding(top = 30.dp)
                    .padding(horizontal = 50.dp),
                enable = username.value.isNotEmpty() && password.value.isNotEmpty()
            ) {
                viewModel.login(username.value, password.value)
            }
            Text(
                text = "Belum Punya Akun?",
                style = Typography.bodyMedium,
                modifier = Modifier.padding(top = 23.dp, bottom = 10.dp)
            )
            SecondaryButton(
                text = "Daftar", modifier = Modifier
                    .padding(bottom = 50.dp)
                    .padding(horizontal = 50.dp)
            ) {
                navigateToRegister()
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun ShowLoginScreenPreview() {
    DiSHCOVERTheme {
        LoginScreen()
    }
}
