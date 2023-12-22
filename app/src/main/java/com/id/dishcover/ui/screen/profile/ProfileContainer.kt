package com.id.dishcover.ui.screen.profile;

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.id.dishcover.ui.component.button.PrimaryButton
import com.id.dishcover.ui.component.card.ProfileCard
import com.id.dishcover.ui.component.field.TextField
import com.id.dishcover.ui.screen.pantry.PantryContainer
import com.id.dishcover.ui.theme.DiSHCOVERTheme
import com.id.dishcover.ui.theme.Green500
import com.id.dishcover.ui.theme.Typography



@Composable
fun ProfileContainer(
    modifier: Modifier = Modifier
) {
    val viewModel: ProfileViewModel = hiltViewModel()

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
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
                Text(text = "Profil Kamu", style = Typography.titleLarge)
                Text(text = "Rekomendasi resep untuk kamu hari ini", style = Typography.bodyLarge, textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth())
            }
        }
        ProfileCard(modifier = Modifier.padding(40.dp))
        PrimaryButton(text = "Logout", modifier = Modifier.padding(vertical = 30.dp)) {
            viewModel.logout()
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun ShowProfileContainerPreview() {
    DiSHCOVERTheme {
        ProfileContainer()
    }
}
