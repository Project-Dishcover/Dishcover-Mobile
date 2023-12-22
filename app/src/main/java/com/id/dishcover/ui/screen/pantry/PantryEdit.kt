package com.id.dishcover.ui.screen.pantry;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.id.dishcover.repository.model.ingridients.IngredientsModel
import com.id.dishcover.ui.component.button.ImageButton
import com.id.dishcover.ui.theme.DiSHCOVERTheme
import com.id.dishcover.ui.theme.Typography


 


@Composable
fun PantryEdit(
    modifier: Modifier = Modifier
) {
    val dummyIngredients = IngredientsModel.dummyList()

    LazyVerticalGrid(columns = GridCells.Fixed(4),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
    ) {
        item(span = { GridItemSpan(4) }) {
            Column {
                Text(text = "Hapus Bahan", style = Typography.titleMedium)
                Text(text = "Pilih bahan yang ingin dihapus", style = Typography.bodyMedium)
            }
        }
        items(dummyIngredients) {
            ImageButton(ingredientsModel = it)
        }
    }
}

@Composable
@Preview
fun ShowPantryEditPreview() {
    DiSHCOVERTheme {
        PantryEdit()
    }
}
