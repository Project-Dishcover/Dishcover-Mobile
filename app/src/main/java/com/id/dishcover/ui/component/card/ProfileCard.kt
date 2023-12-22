package com.id.dishcover.ui.component.card;

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.id.dishcover.R
import com.id.dishcover.repository.model.profile.ProfileModel
import com.id.dishcover.ui.theme.DiSHCOVERTheme
import com.id.dishcover.ui.theme.Typography
import com.id.dishcover.ui.theme.Yellow500


@Composable
fun ProfileCard(
    modifier: Modifier = Modifier,
    profile: ProfileModel = ProfileModel.emptyData()
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Yellow500)
    ) {
        AsyncImage(
            model = profile.photoUrl,
            placeholder = painterResource(R.drawable.dadar_image),
            contentDescription = null,
            modifier = Modifier.aspectRatio(158f/128f),
            contentScale = ContentScale.Fit
        )
        Column(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(text = "Username", style = Typography.titleMedium)
                Text(text = profile.userName, style = Typography.bodyMedium)
            }
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(text = "Email", style = Typography.titleMedium)
                Text(text = profile.email, style = Typography.bodyMedium)
            }
        }
    }
}

@Composable
@Preview
fun ShowProfileCardPreview() {
    DiSHCOVERTheme {
        ProfileCard()
    }
}
