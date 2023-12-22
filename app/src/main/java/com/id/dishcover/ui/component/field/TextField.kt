package com.id.dishcover.ui.component.field;

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.id.dishcover.ui.theme.DarkGreen500
import com.id.dishcover.ui.theme.DiSHCOVERTheme
import com.id.dishcover.ui.theme.Typography
import com.id.dishcover.ui.theme.WhiteBone



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextField(
    modifier: Modifier = Modifier,
    text: String = "",
    hideValue: Boolean = false,
    value: String = "",
    leadingIcon: ImageVector,
    onTextChange: (String) -> Unit = {}
) {
    androidx.compose.material3.TextField(
        modifier = modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = onTextChange,
        textStyle = Typography.bodySmall,
        leadingIcon = {
            Icon(imageVector = leadingIcon, contentDescription = null, tint = DarkGreen500)
        },
        label = {
            Text(text = text, style = Typography.bodySmall)
        },
        maxLines = 1,
        visualTransformation = if (hideValue) PasswordVisualTransformation() else VisualTransformation.None,
        shape = RoundedCornerShape(20.dp),
        colors = TextFieldDefaults.textFieldColors(containerColor = WhiteBone)
    )
}

@Composable
@Preview
fun ShowTextFieldPreview() {
    DiSHCOVERTheme {
        TextField(
            text = "Search",
            leadingIcon = Icons.Default.Search
        )
    }
}
