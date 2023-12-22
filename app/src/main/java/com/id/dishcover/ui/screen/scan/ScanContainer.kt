package com.id.dishcover.ui.screen.scan;

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.id.dishcover.ui.theme.DiSHCOVERTheme
import com.id.dishcover.ui.theme.Green500
import com.id.dishcover.ui.theme.Typography
import kotlinx.coroutines.launch


enum class ScanContainer(val title: String, val description: String) {
    SCAN(title = "Scan Bahan", description = "Gunakan kamera untuk menambahkan bahan yang kamu punya. Harap scan satu-persatu yaa!"),
    RESULT(title = "Hasil Scan", description = "Berikut adalah bahan yang terdeteksi")
}

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScanContainer(
    modifier: Modifier = Modifier
) {
    val currentScreen = remember { mutableStateOf(ScanContainer.SCAN) }
    val viewModel: ScanViewModel = hiltViewModel()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    val scope = rememberCoroutineScope()
    val snackHostState = remember {SnackbarHostState()}


    LaunchedEffect(key1 = uiState.value.isError) {
        scope.launch {
            if (uiState.value.isError) {
                snackHostState.showSnackbar(uiState.value.errorMessage)
            }
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackHostState)
        }
    ) {innerPadding ->
        Column {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Green500)
                    .padding(horizontal = 40.dp)
                    .padding(top = 40.dp, bottom = 20.dp)
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = currentScreen.value.title, style = Typography.titleLarge)
                Text(text = currentScreen.value.description, style = Typography.bodyLarge, textAlign = TextAlign.Center)
            }
            when (currentScreen.value) {
                ScanContainer.SCAN -> ScanTakeScreen(navigateToResultScreen = {currentScreen.value = ScanContainer.RESULT})
                ScanContainer.RESULT -> ScanResultScreen(navigateToRescan = {currentScreen.value = ScanContainer.SCAN})
            }
        }
    }

}

@Composable
@Preview(showSystemUi = true)
fun ShowScanContainerPreview() {
    DiSHCOVERTheme {
        ScanContainer()
    }
}
