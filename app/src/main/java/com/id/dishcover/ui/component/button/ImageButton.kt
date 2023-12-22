package com.id.dishcover.ui.component.button;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.id.dishcover.R
import com.id.dishcover.repository.model.ingridients.IngredientsModel
import com.id.dishcover.ui.theme.DiSHCOVERTheme
import com.id.dishcover.ui.theme.Typography


 


@Composable
fun ImageButton(
    modifier: Modifier = Modifier,
    ingredientsModel: IngredientsModel = IngredientsModel.emptyData(),
    onClickListener: () -> Unit = {}
) {
    OutlinedButton(onClick = onClickListener, modifier = modifier, shape = RectangleShape) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(
                model = ingredientsModel.imageUrl,
                placeholder = painterResource(R.drawable.egg_image),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
            Text(text = ingredientsModel.name, style = Typography.bodySmall, textAlign = TextAlign.Center)
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun ShowImageButtonPreview() {
    DiSHCOVERTheme {
        ImageButton()
    }
}
