package dev.pula.sofrito.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.collectFoldingFeaturesAsState
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.adaptive.HorizontalTwoPaneStrategy
import com.google.accompanist.adaptive.TwoPane
import dev.pula.sofrito.R
import dev.pula.sofrito.presentation.common.PreviewLargeDevices
import dev.pula.sofrito.presentation.navigation.NavigationMenu
import dev.pula.sofrito.presentation.navigation.RecipesNavGraph
import dev.pula.sofrito.presentation.recipes.IngredientsScreen
import dev.pula.sofrito.presentation.recipes.MockData
import dev.pula.sofrito.presentation.recipes.RecipeDetailContent
import dev.pula.sofrito.presentation.theme.AppThemePreview
import dev.pula.sofrito.presentation.util.DevicePosture
import dev.pula.sofrito.presentation.util.isBookPosture
import dev.pula.sofrito.presentation.util.isSeparating

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@RecipesNavGraph(start = true)
@Composable
fun SofritoApp() {
    val windowSize = currentWindowAdaptiveInfo().windowSizeClass
    val foldingFeatureList by collectFoldingFeaturesAsState()
    val foldingFeature = foldingFeatureList.firstOrNull()

    val foldingDevicePosture = when {
        isBookPosture(foldingFeature) ->
            DevicePosture.BookPosture(foldingFeature.bounds)

        isSeparating(foldingFeature) ->
            DevicePosture.Separating(foldingFeature.bounds, foldingFeature.orientation)

        else -> DevicePosture.NormalPosture
    }

    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> { RecipeDetailContent(recipe = MockData.recipe) }
        WindowWidthSizeClass.Medium -> {
            if (foldingDevicePosture != DevicePosture.NormalPosture) {
                NavigationMenu {
                    TwoPane(
                        first = { RecipeDetailContent(recipe = MockData.recipe) },
                        second = { IngredientsScreen(recipe = MockData.recipe) },
                        strategy = HorizontalTwoPaneStrategy(
                            splitFraction = 0.5f,
                            gapWidth = 16.dp
                        ),
                        displayFeatures = listOf(),
                    )
                }
            } else {
                RecipeDetailContent(recipe = MockData.recipe)
            }
        }
        WindowWidthSizeClass.Expanded -> {
            NavigationMenu {
                TwoPane(
                    first = { RecipeDetailContent(recipe = MockData.recipe) },
                    second = { IngredientsScreen(recipe = MockData.recipe) },
                    strategy = HorizontalTwoPaneStrategy(splitFraction = 0.5f, gapWidth = 16.dp),
                    displayFeatures = listOf(),
                )
            }
        }
        else -> { IngredientsScreen(recipe = MockData.recipe) }
    }

}

@Composable
private fun ScreenContainer(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.surfaceColorAtElevation(4.dp),
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Column(
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.app_name).uppercase(),
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(start = 32.dp)
            )
            HorizontalDivider(
                Modifier
                    .fillMaxWidth()
                    .height(2.dp)
            )
            content()
        }
    }
}

@PreviewLargeDevices
@Composable
private fun AppPreview() {
    AppThemePreview {
        SofritoApp()
    }
}