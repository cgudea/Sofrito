package dev.pula.sofrito.presentation.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color

/** Light theme colors */
val md_theme_light_primary = Color(0xFF356859)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFFB9DFD7)
val md_theme_light_onPrimaryContainer = Color(0xFF002018)
val md_theme_light_inversePrimary = Color(0xFF5FDBBA)
val md_theme_light_secondary = Color(0xFFFD5523)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFFFFDBD1)
val md_theme_light_onSecondaryContainer = Color(0xFF3B0900)
val md_theme_light_tertiary = Color(0xFF825500)
val md_theme_light_onTertiary = Color(0xFFffffff)
val md_theme_light_tertiaryContainer = Color(0xFFffddb3)
val md_theme_light_onTertiaryContainer = Color(0xFF291800)
val md_theme_light_background= Color(0xFFB9E4C9)
val md_theme_light_onBackground = Color(0xFF002114)
val md_theme_light_surface = Color(0xFFFFFBE6)
val md_theme_light_onSurface = Color(0xFF002114)
val md_theme_light_surfaceVariant = Color(0xFFDBE5DF)
val md_theme_light_onSurfaceVariant = Color(0xFF3F4945)
val md_theme_light_surfaceTint = Color(0xFF006B56)
val md_theme_light_inverseSurface = Color(0xFF003825)
val md_theme_light_inverseOnSurface = Color(0xFFBEFFDC)
val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFF410002)
val md_theme_light_outline = Color(0xFF6F7975)
val md_theme_light_outlineVariant = Color(0xFFBFC9C3)
val md_theme_light_scrim = Color(0xFF000000)
/** Dark theme colors */
val md_theme_dark_primary = Color(0xFF469582)
val md_theme_dark_onPrimary = Color(0xFF00382C)
val md_theme_dark_primaryContainer = Color(0xFF005140)
val md_theme_dark_onPrimaryContainer = Color(0xFF7EF8D5)
val md_theme_dark_inversePrimary = Color(0xFF006B56)
val md_theme_dark_secondary = Color(0xFFFEAA91)
val md_theme_dark_onSecondary = Color(0xFF601400)
val md_theme_dark_secondaryContainer = Color(0xFF872000)
val md_theme_dark_onSecondaryContainer = Color(0xFFFFDBD1)
val md_theme_dark_tertiary = Color(0xFFffb951)
val md_theme_dark_onTertiary = Color(0xFF452b00)
val md_theme_dark_tertiaryContainer = Color(0xFF633f00)
val md_theme_dark_onTertiaryContainer = Color(0xFFffddb3)
val md_theme_dark_background = Color(0xFF002114)
val md_theme_dark_onBackground = Color(0xFF8BF8C4)
val md_theme_dark_surface = Color(0xFF1D2724)
val md_theme_dark_onSurface = Color(0xFF8BF8C4)
val md_theme_dark_surfaceVariant = Color(0xFF3F4945)
val md_theme_dark_onSurfaceVariant = Color(0xFFBFC9C3)
val md_theme_dark_surfaceTint = Color(0xFF5FDBBA)
val md_theme_dark_inverseSurface = Color(0xFF8BF8C4)
val md_theme_dark_inverseOnSurface = Color(0xFF002114)
val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)
val md_theme_dark_outline = Color(0xFF89938E)
val md_theme_dark_outlineVariant = Color(0xFF3F4945)
val md_theme_dark_scrim = Color(0xFF000000)

val ColorScheme.primaryFixed: Color
    get() = md_theme_light_primaryContainer
val ColorScheme.primaryFixedDim: Color
    get() = md_theme_light_inversePrimary
val ColorScheme.onPrimaryFixed: Color
    get() = md_theme_light_onPrimaryContainer
val ColorScheme.onPrimaryFixedVariant: Color
    get() = md_theme_dark_primary

val ColorScheme.secondaryFixed: Color
    get() = md_theme_light_secondaryContainer
val ColorScheme.secondaryFixedDim: Color
    get() = md_theme_light_secondaryContainer
val ColorScheme.onSecondaryFixed: Color
    get() = md_theme_light_onSecondaryContainer
val ColorScheme.onSecondaryFixedVariant: Color
    get() = md_theme_dark_secondary

val ColorScheme.tertiaryFixed: Color
    get() = md_theme_light_tertiaryContainer
val ColorScheme.tertiaryFixedDim: Color
    get() = md_theme_light_tertiaryContainer
val ColorScheme.onTertiaryFixed: Color
    get() = md_theme_light_onTertiaryContainer
val ColorScheme.onTertiaryFixedVariant: Color
    get() = md_theme_dark_tertiary

