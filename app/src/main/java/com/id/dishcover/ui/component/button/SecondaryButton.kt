package com.id.dishcover.ui.component.button;

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.id.dishcover.ui.theme.DiSHCOVERTheme
import com.id.dishcover.ui.theme.Green500
import com.id.dishcover.ui.theme.Typography
import com.id.dishcover.ui.theme.Yellow500

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    text: String = "",
    enable: Boolean = true,
    onClick: () -> Unit = {}
) {
    ElevatedButton(onClick = onClick, modifier = modifier,
        enabled = enable,
        colors = ButtonDefaults.buttonColors(containerColor = Yellow500)) {
        Text(text = text, style = Typography.bodySmall, color = Color.Black)
    }
}

@Composable
@Preview
fun ShowSecondaryButtonPreview() {
    DiSHCOVERTheme {
        SecondaryButton(text = "Daftar")
    }
}
