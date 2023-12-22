package com.id.dishcover.ui.screen.scan;

import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.id.dishcover.BuildConfig
import com.id.dishcover.R
import com.id.dishcover.ui.component.button.PrimaryButton
import com.id.dishcover.ui.theme.DarkGreen500
import com.id.dishcover.ui.theme.DiSHCOVERTheme
import com.id.dishcover.ui.theme.Typography
import com.id.dishcover.util.Util.createImageFile
import java.io.File
import java.util.Objects



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScanTakeScreen(
    modifier: Modifier = Modifier,
    navigateToResultScreen: () -> Unit = {}
) {
    val viewModel: ScanViewModel = hiltViewModel()
    val context = LocalContext.current
    val path = context.createImageFile()
    val uri = FileProvider.getUriForFile(
        Objects.requireNonNull(context),
        BuildConfig.APPLICATION_ID + ".provider", File(path)
    )
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    val cameraLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) {
            viewModel.setImagePath(File(path).absolutePath)
        }

    LaunchedEffect(key1 = uiState.value.isSuccess) {
        if (uiState.value.isSuccess) {
            navigateToResultScreen()
        }
    }

    LaunchedEffect(key1 = uiState.value.photoPath){
        if (uiState.value.photoPath.isNotEmpty()) {
            viewModel.predict(uiState.value.photoPath)
        }
    }



    Column(
        modifier = modifier
            .padding(horizontal = 45.dp, vertical = 25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Pastikan Bahan Makanan yang difoto dalam keadaan JELAS dan UTUH (tidak terpotong)",
            textAlign = TextAlign.Center,
            style = Typography.bodyLarge)
        Image(painter = painterResource(id = R.drawable.login_image),
            modifier = Modifier
                .padding(top = 20.dp, bottom = 50.dp)
                .clip(RoundedCornerShape(20.dp))
                .border(BorderStroke(20.dp, DarkGreen500))
                .aspectRatio(36f / 24f),
            contentDescription = null
        )
        if (uiState.value.isLoading) {
            CircularProgressIndicator()
        } else {
            PrimaryButton(text = "Akses Kamera") {
                cameraLauncher.launch(uri)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview(showSystemUi = true)
fun ShowScanTakeScreenPreview() {
    DiSHCOVERTheme {
        ScanTakeScreen()
    }
}
