package dev.pula.sofrito.presentation.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import compose.icons.AllIcons
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Calendar
import compose.icons.fontawesomeicons.solid.CalendarAlt
import compose.icons.fontawesomeicons.solid.CalendarCheck
import compose.icons.fontawesomeicons.solid.CalendarDay
import compose.icons.fontawesomeicons.solid.CalendarTimes
import compose.icons.fontawesomeicons.solid.CalendarWeek
import compose.icons.fontawesomeicons.solid.Clock
import compose.icons.fontawesomeicons.solid.ShoppingCart
import dev.pula.sofrito.presentation.common.PreviewLargeDevices
import dev.pula.sofrito.presentation.navigation.navigationrail.SofritoCenteredNavigationRail
import dev.pula.sofrito.presentation.navigation.navigationrail.SofritoNavigationRailItem
import dev.pula.sofrito.presentation.theme.AppThemePreview

@Composable
fun NavigationMenu(
    content: @Composable () -> Unit
) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val pages = Page.entries.toTypedArray()
    val icons = listOf(
        Icons.Filled.Home,
        FontAwesomeIcons.Solid.ShoppingCart,
        FontAwesomeIcons.Solid.CalendarCheck,
        Icons.Filled.Settings
    )
    Row {
        SofritoCenteredNavigationRail(
            header = {
                IconButton(
                    onClick = {},
                ) {
                    Image(
                        imageVector = Icons.Filled.Menu,
//                        painter = painterResource(R.drawable.ic_menu_open),
                        contentDescription = "",
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant),
                    )
                }
            }
        ) {
            pages.forEachIndexed { index, item ->
                when(item){
                    Page.HOME -> {
                        SofritoNavigationRailItem(
                            icon = {
                                Icon(
                                    imageVector = icons[index],
                                    contentDescription = "",
                                )
                            },
                            selected = selectedItem == index,
                            onClick = { selectedItem = index },
                            label = { Text(pages[index].title) }
                        )
                    }
                    Page.SHOPPINGLIST -> {
                        SofritoNavigationRailItem(
                            icon = {
                                Icon(
                                    imageVector = icons[index],
                                    contentDescription = "",
                                    modifier = Modifier.size(20.dp)
                                )
                            },
                            selected = selectedItem == index,
                            onClick = { selectedItem = index },
                            label = { Text(pages[index].title) }
                        )
                    }
                    Page.CALENDAR -> {
                        SofritoNavigationRailItem(
                            icon = {
                                Icon(
                                    imageVector = icons[index],
                                    contentDescription = "",
                                    modifier = Modifier.size(20.dp)
                                )
                            },
                            selected = selectedItem == index,
                            onClick = { selectedItem = index },
                            label = { Text(pages[index].title) }
                        )
                    }

                    Page.SETTINGS -> {
                        SofritoNavigationRailItem(
                            icon = {
                                Icon(
                                    imageVector = icons[index],
                                    contentDescription = "",
                                )
                            },
                            selected = selectedItem == index,
                            onClick = { selectedItem = index },
                            label = { Text(pages[index].title) }
                        )
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp, bottom = 16.dp, end = 16.dp)
        ) {
            content()
        }
    }
}

enum class Page(val title: String, val content: String){
    HOME("Home","Show only icon"),
    SHOPPINGLIST("Shopping","Show icon with label"),
    CALENDAR("Calendar","Timers"),
    SETTINGS("Settings","Show icon /Show the label only when selected")
}

@PreviewLargeDevices
@Composable
private fun NavigationMenuPreview() {
    AppThemePreview{
        NavigationMenu {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = MaterialTheme.colorScheme.surfaceColorAtElevation(4.dp),
                        shape = RoundedCornerShape(16.dp)
                    )
            )
        }
    }
}
