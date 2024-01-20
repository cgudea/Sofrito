package dev.pula.sofrito.presentation.theme

import android.app.Activity
import android.content.res.Configuration
import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat


private val LightColorScheme = lightColorScheme(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    primaryContainer = md_theme_light_primaryContainer,
    onPrimaryContainer = md_theme_light_onPrimaryContainer,
    inversePrimary = md_theme_light_inversePrimary,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    secondaryContainer = md_theme_light_secondaryContainer,
    onSecondaryContainer = md_theme_light_onSecondaryContainer,
    tertiary = md_theme_light_tertiary,
    onTertiary = md_theme_light_onTertiary,
    tertiaryContainer = md_theme_light_tertiaryContainer,
    onTertiaryContainer = md_theme_light_onTertiaryContainer,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
    surfaceVariant = md_theme_light_surfaceVariant,
    onSurfaceVariant = md_theme_light_onSurfaceVariant,
    surfaceTint = md_theme_light_surfaceTint,
    inverseSurface = md_theme_light_inverseSurface,
    inverseOnSurface = md_theme_light_inverseOnSurface,
    error = md_theme_light_error,
    onError = md_theme_light_errorContainer,
    errorContainer = md_theme_light_onError,
    onErrorContainer = md_theme_light_onErrorContainer,
    outline = md_theme_light_outline,
    outlineVariant = md_theme_light_outlineVariant,
    scrim = md_theme_light_scrim,
)

private val DarkColorScheme = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,
    inversePrimary = md_theme_dark_inversePrimary,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    secondaryContainer = md_theme_dark_secondaryContainer,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer,
    tertiary = md_theme_dark_tertiary,
    onTertiary = md_theme_dark_onTertiary,
    tertiaryContainer = md_theme_dark_tertiaryContainer,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    surfaceVariant = md_theme_dark_surfaceVariant,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant,
    surfaceTint = md_theme_dark_surfaceTint,
    inverseSurface = md_theme_dark_inverseSurface,
    inverseOnSurface = md_theme_dark_inverseOnSurface,
    error = md_theme_dark_error,
    onError = md_theme_dark_errorContainer,
    errorContainer = md_theme_dark_onError,
    onErrorContainer = md_theme_dark_onErrorContainer,
    outline = md_theme_dark_outline,
    outlineVariant = md_theme_dark_outlineVariant,
    scrim = md_theme_dark_scrim,
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.surface.toArgb()
            window.navigationBarColor = colorScheme.surface.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = themeTypography(colorScheme),
        content = content
    )
}

@Composable
fun AppThemePreview(
    isScreen: Boolean = false,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit = {}
) {
    val modifier = if (isScreen) Modifier.fillMaxSize().padding(16.dp) else Modifier
    AppTheme(
        darkTheme = isSystemInDarkTheme(),
        dynamicColor = dynamicColor,
    ) {
        Surface(
            modifier = modifier,
            color = MaterialTheme.colorScheme.surface
        ) {
            content()
        }
    }
}

private data class ColorSwatchItem(
    val text: String,
    val color: Color,
    val textColor: Color,
)

@Composable
private fun SwatchItem(
    item: ColorSwatchItem,
    width: Dp = 192.dp,
    height: Dp = 48.dp,
) {
    Box(modifier = Modifier
        .size(width = width, height = height)
        .background(item.color)
    ) {
        Text(
            text = item.text,
            modifier = Modifier.padding(8.dp),
            color = item.textColor,
            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold)
        )
    }
}

@Preview(widthDp = 1000, heightDp = 700)
@Preview(widthDp = 1000, heightDp = 700, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ColorSwatchPreview() {
    AppTheme {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = if (isSystemInDarkTheme()) Color(0xFF28242e) else Color(0xFFeff3e8),
                    shape = RoundedCornerShape(16.dp)
                ),
            horizontalArrangement = Arrangement.Center
        ) {
            Column {
                FirstRow()
                SecondRow()
                ThirdRow()
            }
        }
    }
}

@Composable
private fun FirstRow() {
    val firstColumn = listOf(
        ColorSwatchItem(
            text = "Primary",
            color = MaterialTheme.colorScheme.primary,
            textColor = MaterialTheme.colorScheme.onPrimary
        ),
        ColorSwatchItem(
            text = "onPrimary",
            color = MaterialTheme.colorScheme.onPrimary,
            textColor = MaterialTheme.colorScheme.primary
        ),
        ColorSwatchItem(
            text = "PrimaryContainer",
            color = MaterialTheme.colorScheme.primaryContainer,
            textColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        ColorSwatchItem(
            text = "onPrimaryContainer",
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            textColor = MaterialTheme.colorScheme.primaryContainer
        )
    )
    val secondColumn = listOf(
        ColorSwatchItem(
            text = "Secondary",
            color = MaterialTheme.colorScheme.secondary,
            textColor = MaterialTheme.colorScheme.onSecondary
        ),
        ColorSwatchItem(
            text = "onSecondary",
            color = MaterialTheme.colorScheme.onSecondary,
            textColor = MaterialTheme.colorScheme.secondary
        ),
        ColorSwatchItem(
            text = "SecondaryContainer",
            color = MaterialTheme.colorScheme.secondaryContainer,
            textColor = MaterialTheme.colorScheme.onSecondaryContainer
        ),
        ColorSwatchItem(
            text = "onSecondaryContainer",
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            textColor = MaterialTheme.colorScheme.secondaryContainer
        )
    )
    val thirdColumn = listOf(
        ColorSwatchItem(
            text = "Tertiary",
            color = MaterialTheme.colorScheme.tertiary,
            textColor = MaterialTheme.colorScheme.onTertiary
        ),
        ColorSwatchItem(
            text = "onTertiary",
            color = MaterialTheme.colorScheme.onTertiary,
            textColor = MaterialTheme.colorScheme.tertiary
        ),
        ColorSwatchItem(
            text = "TertiaryContainer",
            color = MaterialTheme.colorScheme.tertiaryContainer,
            textColor = MaterialTheme.colorScheme.onTertiaryContainer
        ),
        ColorSwatchItem(
            text = "onTertiaryContainer",
            color = MaterialTheme.colorScheme.onTertiaryContainer,
            textColor = MaterialTheme.colorScheme.tertiaryContainer
        )
    )
    val forthColumn = listOf(
        ColorSwatchItem(
            text = "Error",
            color = MaterialTheme.colorScheme.error,
            textColor = MaterialTheme.colorScheme.onError
        ),
        ColorSwatchItem(
            text = "onError",
            color = MaterialTheme.colorScheme.onError,
            textColor = MaterialTheme.colorScheme.error
        ),
        ColorSwatchItem(
            text = "ErrorContainer",
            color = MaterialTheme.colorScheme.errorContainer,
            textColor = MaterialTheme.colorScheme.onErrorContainer
        ),
        ColorSwatchItem(
            text = "onErrorContainer",
            color = MaterialTheme.colorScheme.onErrorContainer,
            textColor = MaterialTheme.colorScheme.errorContainer
        )
    )
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(top = 32.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            firstColumn.forEach {
                SwatchItem(it)
            }
        }
        Column(
            modifier = Modifier.padding(top = 32.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            secondColumn.forEach {
                SwatchItem(it)
            }
        }
        Column(
            modifier = Modifier.padding(top = 32.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            thirdColumn.forEach {
                SwatchItem(it)
            }
        }
        Column(
            modifier = Modifier.padding(top = 32.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            forthColumn.forEach {
                SwatchItem(it)
            }
        }
    }
}

@Composable
private fun SecondRow() {
    val firstColumn = listOf(
        ColorSwatchItem(
            text = "Primary Fixed",
            color = MaterialTheme.colorScheme.primaryFixed,
            textColor = MaterialTheme.colorScheme.onPrimaryFixed
        ),
        ColorSwatchItem(
            text = "Primary Fixed Dim",
            color = MaterialTheme.colorScheme.primaryFixedDim,
            textColor = MaterialTheme.colorScheme.onPrimaryFixed
        ),
        ColorSwatchItem(
            text = "On Primary Fixed",
            color = MaterialTheme.colorScheme.onPrimaryFixed,
            textColor = MaterialTheme.colorScheme.primaryFixed
        ),
        ColorSwatchItem(
            text = "On Primary Fixed Variant",
            color = MaterialTheme.colorScheme.onPrimaryFixedVariant,
            textColor = MaterialTheme.colorScheme.primaryFixed
        )
    )
    val secondColumn = listOf(
        ColorSwatchItem(
            text = "Secondary Fixed",
            color = MaterialTheme.colorScheme.secondaryContainer,
            textColor = MaterialTheme.colorScheme.onSecondaryContainer
        ),
        ColorSwatchItem(
            text = "Secondary Fixed Dim",
            color = MaterialTheme.colorScheme.onSecondary,
            textColor = MaterialTheme.colorScheme.secondary
        ),
        ColorSwatchItem(
            text = "On Secondary Fixed",
            color = MaterialTheme.colorScheme.secondaryContainer,
            textColor = MaterialTheme.colorScheme.onSecondaryContainer
        ),
        ColorSwatchItem(
            text = "On Secondary Fixed Variant",
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            textColor = MaterialTheme.colorScheme.secondaryContainer
        )
    )
    val thirdColumn = listOf(
        ColorSwatchItem(
            text = "Tertiary Fixed",
            color = MaterialTheme.colorScheme.tertiaryContainer,
            textColor = MaterialTheme.colorScheme.onTertiaryContainer
        ),
        ColorSwatchItem(
            text = "Tertiary Fixed Dim",
            color = MaterialTheme.colorScheme.onTertiary,
            textColor = MaterialTheme.colorScheme.tertiary
        ),
        ColorSwatchItem(
            text = "On Tertiary Fixed",
            color = MaterialTheme.colorScheme.tertiaryContainer,
            textColor = MaterialTheme.colorScheme.onTertiaryContainer
        ),
        ColorSwatchItem(
            text = "On Tertiary Fixed Variant",
            color = MaterialTheme.colorScheme.onTertiaryContainer,
            textColor = MaterialTheme.colorScheme.tertiaryContainer
        )
    )

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(top = 32.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row {
                SwatchItem(firstColumn[0], width = 96.dp)
                SwatchItem(firstColumn[1], width = 96.dp)
            }
            SwatchItem(firstColumn[2])
            SwatchItem(firstColumn[3])
        }
        Column(
            modifier = Modifier.padding(top = 32.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row {
                SwatchItem(secondColumn[0], width = 96.dp)
                SwatchItem(secondColumn[1], width = 96.dp)
            }
            SwatchItem(secondColumn[2])
            SwatchItem(secondColumn[3])
        }
        Column(
            modifier = Modifier.padding(top = 32.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row {
                SwatchItem(thirdColumn[0], width = 96.dp)
                SwatchItem(thirdColumn[1], width = 96.dp)
            }
            SwatchItem(thirdColumn[2])
            SwatchItem(thirdColumn[3])
        }
        Column(
            modifier = Modifier.padding(top = 32.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {}
    }
}

@Composable
private fun ThirdRow() {
        Row(modifier = Modifier.padding(top = 32.dp)) {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ){
                Row {
                    SwatchItem(
                        ColorSwatchItem(
                            text = "Surface Dim",
                            color = MaterialTheme.colorScheme.surface,
                            textColor = MaterialTheme.colorScheme.onSurface
                        ),
                        width = 196.dp
                    )
                    SwatchItem(
                        ColorSwatchItem(
                            text = "Surface",
                            color = MaterialTheme.colorScheme.surface,
                            textColor = MaterialTheme.colorScheme.onSurface
                        ),
                        width = 196.dp
                    )
                    SwatchItem(
                        ColorSwatchItem(
                            text = "Surface Bright",
                            color = MaterialTheme.colorScheme.surface,
                            textColor = MaterialTheme.colorScheme.onSurface
                        ),
                        width = 200.dp
                    )
                }
                Row {
                    SwatchItem(
                        ColorSwatchItem(
                            text = "Surface\n Container\n Lowest",
                            color = MaterialTheme.colorScheme.surfaceColorAtElevation(0.dp),
                            textColor = MaterialTheme.colorScheme.onSurface
                        ),
                        width = 118.dp,
                        height = 72.dp,
                    )
                    SwatchItem(
                        ColorSwatchItem(
                            text = "Surface\n Container\n Low",
                            color = MaterialTheme.colorScheme.surfaceColorAtElevation(4.dp),
                            textColor = MaterialTheme.colorScheme.onSurface
                        ),
                        width = 118.dp,
                        height = 72.dp,
                    )
                    SwatchItem(
                        ColorSwatchItem(
                            text = "Surface\n Container",
                            color = MaterialTheme.colorScheme.surfaceColorAtElevation(8.dp),
                            textColor = MaterialTheme.colorScheme.onSurface
                        ),
                        width = 118.dp,
                        height = 72.dp,
                    )
                    SwatchItem(
                        ColorSwatchItem(
                            text = "Surface\n Container\n High",
                            color = MaterialTheme.colorScheme.surfaceColorAtElevation(12.dp),
                            textColor = MaterialTheme.colorScheme.onSurface
                        ),
                        width = 118.dp,
                        height = 72.dp,
                    )
                    SwatchItem(
                        ColorSwatchItem(
                            text = "Surface\n Container\n Highest",
                            color = MaterialTheme.colorScheme.surfaceColorAtElevation(16.dp),
                            textColor = MaterialTheme.colorScheme.onSurface
                        ),
                        width = 120.dp,
                        height = 72.dp,
                    )
                }
                Row {
                    SwatchItem(
                        ColorSwatchItem(
                            text = "On Surface",
                            color = MaterialTheme.colorScheme.onSurface,
                            textColor = MaterialTheme.colorScheme.surface
                        ),
                        width = 148.dp
                    )
                    SwatchItem(
                        ColorSwatchItem(
                            text = "On Surface Variant",
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            textColor = MaterialTheme.colorScheme.surface
                        ),
                        width = 148.dp
                    )
                    SwatchItem(
                        ColorSwatchItem(
                            text = "Outline",
                            color = MaterialTheme.colorScheme.outline,
                            textColor = MaterialTheme.colorScheme.surface
                        ),
                        width = 148.dp
                    )
                    SwatchItem(
                        ColorSwatchItem(
                            text = "Outline Variant",
                            color = MaterialTheme.colorScheme.outlineVariant,
                            textColor = MaterialTheme.colorScheme.onSurface
                        ),
                        width = 148.dp
                    )
                }
            }

            Column(
                modifier = Modifier.padding(start = 8.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                SwatchItem(
                    ColorSwatchItem(
                        text = "Inverse Surface",
                        color = MaterialTheme.colorScheme.inverseSurface,
                        textColor = MaterialTheme.colorScheme.surface
                    ),
                    height = 32.dp
                )
                SwatchItem(
                    ColorSwatchItem(
                        text = "Inverse On Surface",
                        color = MaterialTheme.colorScheme.inverseOnSurface,
                        textColor = MaterialTheme.colorScheme.inverseSurface
                    ),
                    height = 32.dp
                )
                SwatchItem(
                    ColorSwatchItem(
                        text = "Inverse Primary",
                        color = MaterialTheme.colorScheme.inversePrimary,
                        textColor = MaterialTheme.colorScheme.inverseSurface
                    ),
                    height = 32.dp
                )

                Spacer(Modifier.height(16.dp))
                Row {
                    SwatchItem(
                        ColorSwatchItem(
                            text = "Scrim",
                            color = MaterialTheme.colorScheme.scrim,
                            textColor = Color(0xFFFFFFFF)
                        ),
                        width = 89.dp
                    )
                    Spacer(Modifier.width(16.dp))
                    SwatchItem(
                        ColorSwatchItem(
                            text = "Shadow",
                            color = MaterialTheme.colorScheme.scrim,
                            textColor = Color(0xFFFFFFFF)
                        ),
                        width = 89.dp
                    )
                }
            }
        }
}
