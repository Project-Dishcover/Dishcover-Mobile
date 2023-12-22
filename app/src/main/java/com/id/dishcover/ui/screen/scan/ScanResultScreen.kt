package com.id.dishcover.ui.screen.scan;

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.id.dishcover.R
import com.id.dishcover.ui.component.button.PrimaryButton
import com.id.dishcover.ui.component.button.SecondaryButton
import com.id.dishcover.ui.theme.DarkGreen500
import com.id.dishcover.ui.theme.DiSHCOVERTheme
import com.id.dishcover.ui.theme.Green500
import com.id.dishcover.ui.theme.Typography



@Composable
fun ScanResultScreen(
    modifier: Modifier = Modifier,
    navigateToRescan: () -> Unit = {}
) {
    val viewModel: ScanViewModel = hiltViewModel()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()


    Column {
        Column(modifier = modifier
            .background(Green500)
            .padding(horizontal = 45.dp, vertical = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(model = uiState.value.photoPath, contentDescription = null, modifier = Modifier
                .padding(top = 20.dp, bottom = 50.dp)
                .clip(RoundedCornerShape(20.dp))
                .border(BorderStroke(20.dp, DarkGreen500))
                .aspectRatio(36f / 24f),
                placeholder = painterResource(id = R.drawable.login_image)
            )
            Text(text = uiState.value.nameResult, style = Typography.titleMedium)
            SecondaryButton(text = "Tambah ke Pantry")
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Scan Lagi?", style = Typography.titleMedium, modifier = Modifier.padding(top = 30.dp, bottom = 10.dp))
            PrimaryButton(text = "Akses Kamera") {
                viewModel.resetField()
                navigateToRescan()
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun ShowScanResultScreenPreview() {
    DiSHCOVERTheme {
        ScanResultScreen()
    }
}
