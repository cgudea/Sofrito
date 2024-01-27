package dev.pula.sofrito.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigation.suite.ExperimentalMaterial3AdaptiveNavigationSuiteApi
import androidx.compose.material3.adaptive.navigation.suite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigation.suite.NavigationSuiteScaffold
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.CalendarCheck
import compose.icons.fontawesomeicons.solid.Poop
import compose.icons.fontawesomeicons.solid.ShoppingCart
import dev.pula.sofrito.presentation.NavGraphs
import dev.pula.sofrito.presentation.appCurrentDestinationAsState
import dev.pula.sofrito.presentation.common.PreviewLargeDevices
import dev.pula.sofrito.presentation.common.PreviewSmallDevices
import dev.pula.sofrito.presentation.destinations.CalendarScreenDestination
import dev.pula.sofrito.presentation.destinations.Destination
import dev.pula.sofrito.presentation.destinations.RecipesOverviewScreenDestination
import dev.pula.sofrito.presentation.destinations.SettingsScreenDestination
import dev.pula.sofrito.presentation.destinations.ShoppingListDestination
import dev.pula.sofrito.presentation.startAppDestination
import dev.pula.sofrito.presentation.theme.AppThemePreview

@OptIn(ExperimentalMaterial3AdaptiveNavigationSuiteApi::class)
@Composable
fun NavigationMenu(
    navController: NavController = rememberNavController(),
    content: @Composable () -> Unit = {}
) {
    val currentDestination: Destination = navController.appCurrentDestinationAsState().value
        ?: NavGraphs.root.startAppDestination
    val navItems = NavigationItem.entries.toTypedArray()

    NavigationSuiteScaffold(
        navigationSuiteColors = NavigationSuiteDefaults.colors(),
        navigationSuiteItems = {
            navItems.forEach { item ->
                item(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = "",
                            modifier = Modifier.size(20.dp)
                        )
                    },
                    selected = currentDestination == item.direction,
                    onClick = { navController.navigate(item.direction.route) },
                    label = { Text(item.title) }
                )
            }
        },
        content = content
    )
}

enum class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val direction: Destination
){
    RECIPES(
        title = "Recipes",
        icon = FontAwesomeIcons.Solid.Poop,
        direction = RecipesOverviewScreenDestination
    ),
    SHOPPINGLIST(
        title = "Shopping",
        icon = FontAwesomeIcons.Solid.ShoppingCart,
        direction = ShoppingListDestination
    ),
    CALENDAR(
        title = "Calendar",
        icon = FontAwesomeIcons.Solid.CalendarCheck,
        direction = CalendarScreenDestination
    ),
    SETTINGS(
        title = "Settings",
        icon = Icons.Filled.Settings,
        direction = SettingsScreenDestination
    )
}

@PreviewSmallDevices
@PreviewLargeDevices
@Composable
private fun NavigationMenuPreview() {
    AppThemePreview {
        NavigationMenu {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .background(
                        color = MaterialTheme.colorScheme.surfaceColorAtElevation(12.dp),
                        shape = RoundedCornerShape(16.dp)
                    )
            )
        }
    }
}
