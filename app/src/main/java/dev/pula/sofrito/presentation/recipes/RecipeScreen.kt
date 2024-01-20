package dev.pula.sofrito.presentation.recipes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import dev.pula.sofrito.domain.model.Recipe
import dev.pula.sofrito.presentation.common.PreviewLargeDevices
import dev.pula.sofrito.presentation.navigation.RecipesNavGraph
import dev.pula.sofrito.presentation.theme.AppThemePreview

@RecipesNavGraph
@Composable
fun RecipeScreen(recipe: Recipe) {
    RecipeContent(recipe)
}

@Composable
fun RecipeContent(recipe: Recipe) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            modifier = Modifier
                .sizeIn(maxHeight = 300.dp)
                .aspectRatio(1.0f)
                .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.25f)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SubcomposeAsyncImage(
                model = recipe.imageUrl,
                contentDescription = "",
                loading = { CircularProgressIndicator() },
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = recipe.name,
//            maxLines = if (recipe.name.split(" ", "\n").size > 2) 2 else 1,
            style = MaterialTheme.typography.displayMedium.merge(
                TextStyle(
                    color = MaterialTheme.colorScheme.secondary,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            )
        )
    }
}

@PreviewLargeDevices
@Composable
private fun RecipeScreenPreview() {
    AppThemePreview {
        RecipeContent(
            Recipe(
                name = "Key Lime Pie",
                imageUrl = "https://source.unsplash.com/user/thematteroffood",
                category = "Desserts"
            )
        )
    }
}