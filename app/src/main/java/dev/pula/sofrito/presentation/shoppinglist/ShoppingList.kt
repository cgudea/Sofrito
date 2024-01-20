package dev.pula.sofrito.presentation.shoppinglist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import dev.pula.sofrito.R
import dev.pula.sofrito.domain.model.Ingredient
import dev.pula.sofrito.presentation.common.PreviewLargeDevices
import dev.pula.sofrito.presentation.common.TextOverflowMiddle
import dev.pula.sofrito.presentation.navigation.ShoppingNavGraph
import dev.pula.sofrito.presentation.recipes.MockData
import dev.pula.sofrito.presentation.theme.AppThemePreview

@ShoppingNavGraph(start = true)
@Composable
fun ShoppingList() {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item { ShoppingListHeader() }
        items(MockData.shoppingList) { item -> ShoppingListItem(item) }
    }
}

@Composable
private fun ShoppingListHeader() {
    val image: Painter = painterResource(id = R.drawable.ic_bookmark)
    Text(
        text = "Shopping List",
        style = MaterialTheme.typography.displayLarge,
    )
    Icon(
        painter = image,
        tint = MaterialTheme.colorScheme.primary,
        contentDescription = ""
    )
}

@Composable
fun ShoppingListItem(item: Ingredient) {
    val neededStyle = MaterialTheme.typography.titleLarge.merge(
        TextStyle(
            color = MaterialTheme.colorScheme.secondary,
            textDecoration = TextDecoration.None
        )
    )
    val purchasedStyle = MaterialTheme.typography.titleLarge.merge(
        TextStyle(
            color = MaterialTheme.colorScheme.onBackground,
            textDecoration = TextDecoration.LineThrough
        )
    )
    val haveItem = rememberSaveable { mutableStateOf(false) }
    TextOverflowMiddle(
        start = item.name,
        end = item.amount,
        textStyle = if (haveItem.value) purchasedStyle else neededStyle,
        modifier = Modifier.clickable { haveItem.value = !haveItem.value },
    )
}

@PreviewLargeDevices
@Composable
private fun ShoppingListPreview() {
    AppThemePreview(isScreen = true) {
        ShoppingList()
    }
}
