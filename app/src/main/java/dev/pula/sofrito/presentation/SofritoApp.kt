package dev.pula.sofrito.presentation

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.google.accompanist.adaptive.HorizontalTwoPaneStrategy
import com.google.accompanist.adaptive.TwoPane
import dev.pula.sofrito.presentation.common.PreviewLargeDevices
import dev.pula.sofrito.presentation.navigation.NavigationMenu
import dev.pula.sofrito.presentation.recipes.IngredientsScreen
import dev.pula.sofrito.presentation.recipes.MockData
import dev.pula.sofrito.presentation.recipes.RecipeDetailContent
import dev.pula.sofrito.presentation.theme.AppThemePreview

@Composable
fun SofritoApp() {
    NavigationMenu {
        Surface {
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
    }
//    when (windowSize.widthSizeClass) {
//        WindowWidthSizeClass.Compact -> { RecipeDetailContent(recipe = MockData.recipe) }
//        WindowWidthSizeClass.Medium -> {
//            if (foldingDevicePosture != DevicePosture.NormalPosture) {
//                NavigationMenu(windowSize.widthSizeClass) {
//                    TwoPane(
//                        first = { RecipeDetailContent(recipe = MockData.recipe) },
//                        second = { IngredientsScreen(recipe = MockData.recipe) },
//                        strategy = HorizontalTwoPaneStrategy(
//                            splitFraction = 0.5f,
//                            gapWidth = 16.dp
//                        ),
//                        displayFeatures = listOf(),
//                    )
//                }
//            } else {
//                RecipeDetailContent(recipe = MockData.recipe)
//            }
//        }
//        WindowWidthSizeClass.Expanded -> {
//            NavigationMenu(windowSize.widthSizeClass) {
//                TwoPane(
//                    first = { RecipeDetailContent(recipe = MockData.recipe) },
//                    second = { IngredientsScreen(recipe = MockData.recipe) },
//                    strategy = HorizontalTwoPaneStrategy(splitFraction = 0.5f, gapWidth = 16.dp),
//                    displayFeatures = listOf(),
//                )
//            }
//        }
//        else -> { IngredientsScreen(recipe = MockData.recipe) }
//    }
}

@PreviewLargeDevices
@Composable
private fun AppPreview() {
    AppThemePreview {
        SofritoApp()
    }
}