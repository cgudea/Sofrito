package dev.pula.sofrito.presentation.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.sp
import dev.pula.sofrito.R
import dev.pula.sofrito.presentation.common.PreviewLargeDevices

fun themeTypography(colorScheme: ColorScheme): Typography {
    val regular = Font(R.font.montserrat_regular)
    val medium = Font(R.font.montserrat_medium, FontWeight.W500)
    val semibold = Font(R.font.montserrat_semibold, FontWeight.W600)
    val bold = Font(R.font.montserrat_bold, FontWeight.W700)

    val montserratFontFamily = FontFamily(
        regular,
        medium,
        semibold,
        bold
    )
    val lektonFontFamily = Font(R.font.lekton_bold, FontWeight.W700).toFontFamily()

    return Typography(
        displayLarge = TextStyle(
            fontFamily = montserratFontFamily,
            fontSize = 57.sp,
            color = colorScheme.primary,
            fontWeight = FontWeight.W600,
        ),
        displayMedium = TextStyle(
            fontFamily = montserratFontFamily,
            fontSize = 45.sp,
            color = colorScheme.primary,
            fontWeight = FontWeight.W600,
        ),
        displaySmall = TextStyle(
            fontFamily = montserratFontFamily,
            fontSize = 36.sp,
            color = colorScheme.primary,
            fontWeight = FontWeight.W600,
        ),
        headlineLarge = TextStyle(
            fontFamily = montserratFontFamily,
            fontSize = 32.sp,
            color = colorScheme.primary,
            fontWeight = FontWeight.W600,
        ),
        headlineMedium = TextStyle(
            fontFamily = montserratFontFamily,
            fontSize = 28.sp,
            color = colorScheme.primary,
            fontWeight = FontWeight.W600,
        ),
        headlineSmall = TextStyle(
            fontFamily = montserratFontFamily,
            fontSize = 24.sp,
            color = colorScheme.primary,
            fontWeight = FontWeight.W600,
        ),
        titleLarge = TextStyle(
            fontFamily = lektonFontFamily,
            fontSize = 22.sp,
            color = colorScheme.primary,
            fontWeight = FontWeight.W500,
        ),
        titleMedium = TextStyle(
            fontFamily = lektonFontFamily,
            fontSize = 16.sp,
            color = colorScheme.primary,
            fontWeight = FontWeight.W700,
        ),
        titleSmall = TextStyle(
            fontFamily = lektonFontFamily,
            fontSize = 14.sp,
            color = colorScheme.primary,
            fontWeight = FontWeight.W700,
        ),
        bodyLarge = TextStyle(
            fontFamily = montserratFontFamily,
            fontSize = 16.sp,
            color = colorScheme.primary
        ),
        bodyMedium = TextStyle(
            fontFamily = montserratFontFamily,
            fontSize = 14.sp,
            color = colorScheme.primary
        ),
        bodySmall = TextStyle(
            fontFamily = montserratFontFamily,
            fontSize = 12.sp,
            color = colorScheme.primary
        ),
        labelLarge = TextStyle(
            fontFamily = montserratFontFamily,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
        ),
        labelMedium = TextStyle(
            fontFamily = montserratFontFamily,
            fontSize = 10.sp,
            fontWeight = FontWeight.Medium,
        ),
        labelSmall = TextStyle(
            fontFamily = montserratFontFamily,
            fontSize = 8.sp,
            fontWeight = FontWeight.Medium,
        ),
    )
}

@Composable
private fun TypographyPreviews() {
    Surface {
        Column {
            Text(text = "displayLarge", style = MaterialTheme.typography.displayLarge)
            Text(text = "displayMedium", style = MaterialTheme.typography.displayMedium)
            Text(text = "displaySmall", style = MaterialTheme.typography.displaySmall)
            Text(text = "headlineLarge", style = MaterialTheme.typography.headlineLarge)
            Text(text = "headlineMedium", style = MaterialTheme.typography.headlineMedium)
            Text(text = "headlineSmall", style = MaterialTheme.typography.headlineSmall)
            Text(text = "titleLarge", style = MaterialTheme.typography.titleLarge)
            Text(text = "titleMedium", style = MaterialTheme.typography.titleMedium)
            Text(text = "titleSmall", style = MaterialTheme.typography.titleSmall)
            Text(text = "bodyLarge", style = MaterialTheme.typography.bodyLarge)
            Text(text = "bodyMedium", style = MaterialTheme.typography.bodyMedium)
            Text(text = "bodySmall", style = MaterialTheme.typography.bodySmall)
            Text(text = "labelLarge", style = MaterialTheme.typography.labelLarge)
            Text(text = "labelMedium", style = MaterialTheme.typography.labelMedium)
            Text(text = "labelSmall", style = MaterialTheme.typography.labelSmall)
        }
    }
}

@PreviewLargeDevices
@Composable
private fun LightPreview() {
    AppThemePreview {
        TypographyPreviews()
    }
}

