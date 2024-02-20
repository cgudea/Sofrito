package dev.pula.sofrito.presentation.navigation.suite

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigation.suite.ExperimentalMaterial3AdaptiveNavigationSuiteApi
import androidx.compose.material3.adaptive.navigation.suite.NavigationSuiteColors
import androidx.compose.material3.adaptive.navigation.suite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigation.suite.NavigationSuiteItemColors
import androidx.compose.material3.adaptive.navigation.suite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigation.suite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigation.suite.NavigationSuiteScaffoldLayout
import androidx.compose.material3.adaptive.navigation.suite.NavigationSuiteScope
import androidx.compose.material3.adaptive.navigation.suite.NavigationSuiteType
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collection.MutableVector
import androidx.compose.runtime.collection.mutableVectorOf
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * The Navigation Suite Scaffold wraps the provided content and places the adequate provided
 * navigation component on the screen according to the current [NavigationSuiteType].
 *
 * Example default usage:
 * @sample androidx.compose.material3.adaptive.navigation.suite.samples.NavigationSuiteScaffoldSample
 * Example custom configuration usage:
 * @sample androidx.compose.material3.adaptive.navigation.suite.samples.NavigationSuiteScaffoldCustomConfigSample
 *
 * @param navigationSuiteItems the navigation items to be displayed
 * @param modifier the [Modifier] to be applied to the navigation suite scaffold
 * @param layoutType the current [NavigationSuiteType]. Defaults to
 * [NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo]
 * @param navigationSuiteColors [NavigationSuiteColors] that will be used to determine the container
 * (background) color of the navigation component and the preferred color for content inside the
 * navigation component
 * @param containerColor the color used for the background of the navigation suite scaffold. Use
 * [Color.Transparent] to have no color
 * @param contentColor the preferred color for content inside the navigation suite scaffold.
 * Defaults to either the matching content color for [containerColor], or to the current
 * [LocalContentColor] if [containerColor] is not a color from the theme
 * @param content the content of your screen
 */
@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@ExperimentalMaterial3AdaptiveNavigationSuiteApi
@Composable
fun SofritoNavigationSuiteScaffold(
    navigationSuiteItems: NavigationSuiteScope.() -> Unit,
    modifier: Modifier = Modifier,
    layoutType: NavigationSuiteType =
        NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(WindowAdaptiveInfoDefault),
    navigationSuiteColors: NavigationSuiteColors = NavigationSuiteDefaults.colors(),
    containerColor: Color = MaterialTheme.colorScheme.background,
    contentColor: Color = contentColorFor(containerColor),
    content: @Composable () -> Unit = {},
) {
    Surface(modifier = modifier, color = containerColor, contentColor = contentColor) {
        NavigationSuiteScaffoldLayout(
            navigationSuite = {
                NavigationSuite(
                    layoutType = layoutType,
                    colors = navigationSuiteColors,
                    content = navigationSuiteItems
                )
            },
            layoutType = layoutType,
            content = content
        )
    }
}


/**
 * The default Material navigation component according to the current [NavigationSuiteType] to be
 * used with the [NavigationSuiteScaffold].
 *
 * For specifics about each navigation component, see [NavigationBar], [NavigationRail], and
 * [PermanentDrawerSheet].
 *
 * @param modifier the [Modifier] to be applied to the navigation component
 * @param layoutType the current [NavigationSuiteType] of the [NavigationSuiteScaffold]. Defaults to
 * [NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo]
 * @param colors [NavigationSuiteColors] that will be used to determine the container (background)
 * color of the navigation component and the preferred color for content inside the navigation
 * component
 * @param content the content inside the current navigation component, typically
 * [NavigationSuiteScope.item]s
 */
@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@ExperimentalMaterial3AdaptiveNavigationSuiteApi
@Composable
fun NavigationSuite(
    modifier: Modifier = Modifier,
    layoutType: NavigationSuiteType =
        NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(WindowAdaptiveInfoDefault),
    colors: NavigationSuiteColors = NavigationSuiteDefaults.colors(),
    content: NavigationSuiteScope.() -> Unit
) {
    val scope by rememberStateOfItems(content)

    when (layoutType) {
        NavigationSuiteType.NavigationBar -> {
            NavigationBar(
                modifier = modifier,
                containerColor = colors.navigationBarContainerColor,
                contentColor = colors.navigationBarContentColor
            ) {
                scope.itemList.forEach {
                    NavigationBarItem(
                        modifier = it.modifier,
                        selected = it.selected,
                        onClick = it.onClick,
                        icon = { NavigationItemIcon(icon = it.icon, badge = it.badge) },
                        enabled = it.enabled,
                        label = it.label,
                        alwaysShowLabel = it.alwaysShowLabel,
                        colors = it.colors?.navigationBarItemColors
                            ?: NavigationBarItemDefaults.colors(),
                        interactionSource = it.interactionSource
                    )
                }
            }
        }

        NavigationSuiteType.NavigationRail -> {
            SofritoNavigationRail(
                modifier = modifier,
                containerColor = colors.navigationRailContainerColor,
                contentColor = colors.navigationRailContentColor
            ) {
                scope.itemList.forEach {
                    SofritoNavigationRailItem(
                        modifier = it.modifier,
                        selected = it.selected,
                        onClick = it.onClick,
                        icon = { NavigationItemIcon(icon = it.icon, badge = it.badge) },
                        enabled = it.enabled,
                        label = it.label,
                        alwaysShowLabel = it.alwaysShowLabel,
//                        colors = it.colors?.navigationRailItemColors
//                            ?: NavigationRailItemDefaults.colors(),
                        interactionSource = it.interactionSource
                    )
                }
            }
        }

        NavigationSuiteType.NavigationDrawer -> {
            PermanentDrawerSheet(
                modifier = modifier,
                drawerContainerColor = colors.navigationDrawerContainerColor,
                drawerContentColor = colors.navigationDrawerContentColor
            ) {
                scope.itemList.forEach {
                    NavigationDrawerItem(
                        modifier = it.modifier,
                        selected = it.selected,
                        onClick = it.onClick,
                        icon = it.icon,
                        badge = it.badge,
                        label = { it.label?.invoke() ?: Text("") },
                        colors = it.colors?.navigationDrawerItemColors
                            ?: NavigationDrawerItemDefaults.colors(),
                        interactionSource = it.interactionSource
                    )
                }
            }
        }

        NavigationSuiteType.None -> { /* Do nothing. */ }
    }
}

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
internal val WindowAdaptiveInfoDefault: WindowAdaptiveInfo
    @Composable
    get() = currentWindowAdaptiveInfo()

private interface NavigationSuiteItemProvider {
    val itemsCount: Int
    val itemList: MutableVector<NavigationSuiteItem>
}

@OptIn(ExperimentalMaterial3AdaptiveNavigationSuiteApi::class)
private class NavigationSuiteItem(
    val selected: Boolean,
    val onClick: () -> Unit,
    val icon: @Composable () -> Unit,
    val modifier: Modifier,
    val enabled: Boolean,
    val label: @Composable (() -> Unit)?,
    val alwaysShowLabel: Boolean,
    val badge: (@Composable () -> Unit)?,
    val colors: NavigationSuiteItemColors?,
    val interactionSource: MutableInteractionSource
)

@OptIn(ExperimentalMaterial3AdaptiveNavigationSuiteApi::class)
private class NavigationSuiteScopeImpl : NavigationSuiteScope,
    NavigationSuiteItemProvider {

    override fun item(
        selected: Boolean,
        onClick: () -> Unit,
        icon: @Composable () -> Unit,
        modifier: Modifier,
        enabled: Boolean,
        label: @Composable (() -> Unit)?,
        alwaysShowLabel: Boolean,
        badge: (@Composable () -> Unit)?,
        colors: NavigationSuiteItemColors?,
        interactionSource: MutableInteractionSource
    ) {
        itemList.add(
            NavigationSuiteItem(
                selected = selected,
                onClick = onClick,
                icon = icon,
                modifier = modifier,
                enabled = enabled,
                label = label,
                alwaysShowLabel = alwaysShowLabel,
                badge = badge,
                colors = colors,
                interactionSource = interactionSource
            )
        )
    }

    override val itemList: MutableVector<NavigationSuiteItem> = mutableVectorOf()

    override val itemsCount: Int
        get() = itemList.size
}

@OptIn(ExperimentalMaterial3AdaptiveNavigationSuiteApi::class)
@Composable
private fun rememberStateOfItems(
    content: NavigationSuiteScope.() -> Unit
): State<NavigationSuiteItemProvider> {
    val latestContent = rememberUpdatedState(content)
    return remember {
        derivedStateOf { NavigationSuiteScopeImpl().apply(latestContent.value) }
    }
}

@Composable
private fun NavigationItemIcon(
    icon: @Composable () -> Unit,
    badge: (@Composable () -> Unit)? = null,
) {
    if (badge != null) {
        BadgedBox(badge = { badge.invoke() }) {
            icon()
        }
    } else {
        icon()
    }
}
