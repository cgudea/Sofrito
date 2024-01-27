package dev.pula.sofrito.presentation.recipes

import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import com.google.accompanist.adaptive.HorizontalTwoPaneStrategy
import com.google.accompanist.adaptive.TwoPane
import dev.pula.sofrito.presentation.common.PreviewLargeDevices
import dev.pula.sofrito.presentation.common.PreviewSmallDevices
import dev.pula.sofrito.presentation.navigation.RecipesNavGraph
import dev.pula.sofrito.presentation.theme.AppThemePreview
import dev.pula.sofrito.presentation.util.DevicePosture
import dev.pula.sofrito.presentation.util.collectDevicePostureAsState

/**
 * Utilize [Carousel](https://m3.material.io/components/carousel/specs) for a grid display of
 * recipes with their images.
 *
 * Also utilize [search bar](https://material.io/blog/material-3-compose-1-1)
 */
@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@RecipesNavGraph(start = true)
@Composable
fun RecipesOverviewScreen() {
    val windowSize = currentWindowAdaptiveInfo().windowSizeClass

    val foldingDevicePosture by collectDevicePostureAsState()

    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> { RecipeDetailContent(recipe = MockData.recipe) }
        WindowWidthSizeClass.Medium -> {
            if (foldingDevicePosture != DevicePosture.NormalPosture) {
                    TwoPane(
                        first = { RecipeDetailContent(recipe = MockData.recipe) },
                        second = { IngredientsScreen(recipe = MockData.recipe) },
                        strategy = HorizontalTwoPaneStrategy(
                            splitFraction = 0.5f,
                            gapWidth = 16.dp
                        ),
                        displayFeatures = listOf(),
                    )
            } else {
                RecipeDetailContent(recipe = MockData.recipe)
            }
        }
        WindowWidthSizeClass.Expanded -> {
                TwoPane(
                    first = { RecipeDetailContent(recipe = MockData.recipe) },
                    second = { IngredientsScreen(recipe = MockData.recipe) },
                    strategy = HorizontalTwoPaneStrategy(splitFraction = 0.5f, gapWidth = 16.dp),
                    displayFeatures = listOf(),
                )
        }
        else -> { IngredientsScreen(recipe = MockData.recipe) }
    }
}

@PreviewSmallDevices
@PreviewLargeDevices
@Composable
private fun Preview() {
    AppThemePreview {
        RecipesOverviewScreen()
    }
}