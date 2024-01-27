package dev.pula.sofrito.presentation.recipes

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.pula.sofrito.domain.model.Recipe
import dev.pula.sofrito.presentation.common.PreviewLargeDevices
import dev.pula.sofrito.presentation.common.TextOverflowMiddle
import dev.pula.sofrito.presentation.navigation.RecipesNavGraph
import dev.pula.sofrito.presentation.theme.AppThemePreview

@RecipesNavGraph
@Composable
fun IngredientsScreen(recipe: Recipe) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item { Text("Ingredients", style = MaterialTheme.typography.displaySmall)}
        items(recipe.ingredients) { ingredient ->
            Row {
                TextOverflowMiddle(
                    start = ingredient.name,
                    end = ingredient.amount,
                    textStyle = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp)
                )
            }
        }
    }
}

@PreviewLargeDevices
@Composable
private fun IngredientsScreenPreview() {
    AppThemePreview {
        IngredientsScreen(MockData.recipe)
    }
}
