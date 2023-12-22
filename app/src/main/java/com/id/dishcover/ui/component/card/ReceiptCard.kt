package com.id.dishcover.ui.component.card;

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.id.dishcover.R
import com.id.dishcover.repository.model.receipt.ReceiptModel
import com.id.dishcover.ui.theme.DiSHCOVERTheme
import com.id.dishcover.ui.theme.Typography
import com.id.dishcover.ui.theme.Yellow500


@Composable
fun ReceiptCard(
    modifier: Modifier = Modifier,
    receiptModel: ReceiptModel = ReceiptModel.dummyList()[0]
) {
    Column(
        modifier = modifier
            .background(Yellow500)
            .clip(RoundedCornerShape(10.dp))
    ) {
        AsyncImage(
            model = receiptModel.imageUrl,
            placeholder = painterResource(R.drawable.dadar_image),
            contentDescription = null,
            modifier = Modifier.aspectRatio(158f/128f)
        )
        Column(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp)
        ) {
            Text(text = receiptModel.name, style = Typography.titleMedium)
            Text(text = receiptModel.description, style = Typography.bodyMedium)
        }
    }
}

@Composable
@Preview
fun ShowReceiptCardPreview() {
    DiSHCOVERTheme {
        ReceiptCard()
    }
}
