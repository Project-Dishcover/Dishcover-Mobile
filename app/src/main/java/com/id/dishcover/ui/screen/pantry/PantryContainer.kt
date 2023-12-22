package com.id.dishcover.ui.screen.pantry;

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.id.dishcover.ui.component.field.TextField
import com.id.dishcover.ui.theme.DiSHCOVERTheme
import com.id.dishcover.ui.theme.Green500
import com.id.dishcover.ui.theme.Typography
import com.id.dishcover.ui.theme.Yellow500


 

enum class PantryContainer(val title: String, val description: String = "") {
    SEARCH(title = "Cari Bahan"),
    MAIN(title = "Pantry Saya"),
    EDIT(title = "Edit Pantry Saya", description = "Kamu dapat menghapus bahan yang sudah habis")
}

@Composable
fun PantryContainer(
    modifier: Modifier = Modifier
) {
    val currentScreen = remember { mutableStateOf(PantryContainer.MAIN) }
    val paddingModifier = Modifier.padding(horizontal = 12.dp, vertical = 18.dp)
    Column(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Green500)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 40.dp)
                    .padding(top = 40.dp, bottom = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = currentScreen.value.title, style = Typography.titleLarge)
                if (currentScreen.value == PantryContainer.EDIT) {
                    Text(text = currentScreen.value.description, style = Typography.bodyLarge, textAlign = TextAlign.Center)
                } else {
                    TextField(leadingIcon = Icons.Default.Search, modifier = Modifier.padding(top = 10.dp),
                        text = "Tambah Bahan Yang Kamu Punya")
                }
            }
        }
        when (currentScreen.value) {
            PantryContainer.SEARCH -> PantrySearch(modifier = paddingModifier)
            PantryContainer.MAIN -> PantryScreen(modifier = paddingModifier, navigateToSearch = {currentScreen.value = PantryContainer.SEARCH},
                navigateToEdit = {currentScreen.value = PantryContainer.EDIT})
            PantryContainer.EDIT -> PantryEdit(modifier = paddingModifier)
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun ShowPantryContainerPreview() {
    DiSHCOVERTheme {
        PantryContainer()
    }
}
