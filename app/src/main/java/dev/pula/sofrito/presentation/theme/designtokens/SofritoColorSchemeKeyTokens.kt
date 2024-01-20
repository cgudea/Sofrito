package dev.pula.sofrito.presentation.theme.designtokens

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

internal enum class SofritoColorSchemeKeyTokens {
    Background,
    Error,
    ErrorContainer,
    InverseOnSurface,
    InversePrimary,
    InverseSurface,
    OnBackground,
    OnError,
    OnErrorContainer,
    OnPrimary,
    OnPrimaryContainer,
    OnSecondary,
    OnSecondaryContainer,
    OnSurface,
    OnSurfaceVariant,
    OnTertiary,
    OnTertiaryContainer,
    Outline,
    OutlineVariant,
    Primary,
    PrimaryContainer,
    Scrim,
    Secondary,
    SecondaryContainer,
    Surface,
    SurfaceTint,
    SurfaceVariant,
    Tertiary,
    TertiaryContainer,
}


/**
 * Helper function for component color tokens. Here is an example on how to use component color
 * tokens:
 * ``MaterialTheme.colorScheme.fromToken(ExtendedFabBranded.BrandedContainerColor)``
 */
internal fun ColorScheme.fromToken(value: SofritoColorSchemeKeyTokens): Color {
    return when (value) {
        SofritoColorSchemeKeyTokens.Background -> background
        SofritoColorSchemeKeyTokens.Error -> error
        SofritoColorSchemeKeyTokens.ErrorContainer -> errorContainer
        SofritoColorSchemeKeyTokens.InverseOnSurface -> inverseOnSurface
        SofritoColorSchemeKeyTokens.InversePrimary -> inversePrimary
        SofritoColorSchemeKeyTokens.InverseSurface -> inverseSurface
        SofritoColorSchemeKeyTokens.OnBackground -> onBackground
        SofritoColorSchemeKeyTokens.OnError -> onError
        SofritoColorSchemeKeyTokens.OnErrorContainer -> onErrorContainer
        SofritoColorSchemeKeyTokens.OnPrimary -> onPrimary
        SofritoColorSchemeKeyTokens.OnPrimaryContainer -> onPrimaryContainer
        SofritoColorSchemeKeyTokens.OnSecondary -> onSecondary
        SofritoColorSchemeKeyTokens.OnSecondaryContainer -> onSecondaryContainer
        SofritoColorSchemeKeyTokens.OnSurface -> onSurface
        SofritoColorSchemeKeyTokens.OnSurfaceVariant -> onSurfaceVariant
        SofritoColorSchemeKeyTokens.SurfaceTint -> surfaceTint
        SofritoColorSchemeKeyTokens.OnTertiary -> onTertiary
        SofritoColorSchemeKeyTokens.OnTertiaryContainer -> onTertiaryContainer
        SofritoColorSchemeKeyTokens.Outline -> outline
        SofritoColorSchemeKeyTokens.OutlineVariant -> outlineVariant
        SofritoColorSchemeKeyTokens.Primary -> primary
        SofritoColorSchemeKeyTokens.PrimaryContainer -> primaryContainer
        SofritoColorSchemeKeyTokens.Scrim -> scrim
        SofritoColorSchemeKeyTokens.Secondary -> secondary
        SofritoColorSchemeKeyTokens.SecondaryContainer -> secondaryContainer
        SofritoColorSchemeKeyTokens.Surface -> surface
        SofritoColorSchemeKeyTokens.SurfaceVariant -> surfaceVariant
        SofritoColorSchemeKeyTokens.Tertiary -> tertiary
        SofritoColorSchemeKeyTokens.TertiaryContainer -> tertiaryContainer
    }
}

/**
 * A low level of alpha used to represent disabled components, such as text in a disabled Button.
 */
internal const val DisabledAlpha = 0.38f

/** Converts a color token key to the local color scheme provided by the theme */
@ReadOnlyComposable
@Composable
internal fun SofritoColorSchemeKeyTokens.toColor(): Color {
    return MaterialTheme.colorScheme.fromToken(this)
}
