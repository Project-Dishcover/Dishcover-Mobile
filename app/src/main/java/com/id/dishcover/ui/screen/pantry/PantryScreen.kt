package com.id.dishcover.ui.screen.pantry;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.id.dishcover.repository.model.ingridients.IngredientsModel
import com.id.dishcover.repository.model.receipt.ReceiptModel
import com.id.dishcover.ui.component.button.ImageButton
import com.id.dishcover.ui.component.button.PrimaryButton
import com.id.dishcover.ui.component.button.SecondaryButton
import com.id.dishcover.ui.component.card.ReceiptCard
import com.id.dishcover.ui.theme.DiSHCOVERTheme
import com.id.dishcover.ui.theme.Typography


 


@Composable
fun PantryScreen(
    modifier: Modifier = Modifier,
    navigateToSearch: () -> Unit = {},
    navigateToEdit: () -> Unit = {}
) {
    val dummyIngredients = IngredientsModel.dummyList()
    val dummyReceipts = ReceiptModel.dummyList()

    LazyVerticalGrid(columns = GridCells.Fixed(4),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
    ) {
        item(span = { GridItemSpan(4) }) {
            Column {
                Text(text = "Bahan yang kamu punya di rumah", style = Typography.titleMedium)
                Text(text = "Kami yakin kamu punya air, garam, gula, dan minyak di rumah. Jadi tidak perlu masuk list ini yaa :D",
                    style = Typography.bodyMedium, modifier = Modifier.padding(top = 10.dp)
                )
            }
        }
        items(dummyIngredients) {
            ImageButton(ingredientsModel = it)
        }
        item(span = { GridItemSpan(4) }) {
            Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 30.dp), horizontalArrangement = Arrangement.SpaceAround) {
            PrimaryButton(
                text = "Cari Resep"
            ){navigateToSearch()}
            SecondaryButton(
                text = "Edit Pantry"
            ){navigateToEdit()}
        }
        }
        item(span = { GridItemSpan(4) }) {
            Column {
                Text(text = "Masak Lagi", style = Typography.titleMedium)
                Text(text = "Resep yang sebelumnya kamu lihat", style = Typography.bodyMedium, modifier = Modifier.padding(top = 10.dp))
            }
        }
        items(dummyReceipts, span = {GridItemSpan(2)}) {
            ReceiptCard(receiptModel = it)
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun ShowPantryScreenPreview() {
    DiSHCOVERTheme {
        PantryScreen()
    }
}
