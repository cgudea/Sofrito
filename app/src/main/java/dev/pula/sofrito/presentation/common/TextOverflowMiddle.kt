package dev.pula.sofrito.presentation.common

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import dev.pula.sofrito.presentation.recipes.MockData
import dev.pula.sofrito.presentation.theme.AppThemePreview
import kotlin.math.floor

@Composable
fun TextOverflowMiddle(
    start: String,
    end: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = LocalTextStyle.current
) {
    BoxWithConstraints(
        modifier = Modifier.fillMaxWidth(),
    ) {
        val composableWidth = maxWidth
        val textMeasurer = rememberTextMeasurer()

        val startWidth = textMeasurer.measure(
            text = start,
            style = textStyle,
        ).size.width.pxToDp()
        val endWidth = textMeasurer.measure(
            text = end,
            style = textStyle,
        ).size.width.pxToDp()
        val dotWidth = textMeasurer.measure(
            text = ".",
            style = textStyle,
        ).size.width.pxToDp()

        val composableWidthInFloat = floor(composableWidth.value)
        val startAndEndComposableWidthWithPadding = (startWidth.value) + (endWidth.value)

        val calculatedNumberOfDots =
            ((composableWidthInFloat - startAndEndComposableWidthWithPadding) / dotWidth.value).toInt()
        val numberOfDots = if (calculatedNumberOfDots < 0) {
            0
        } else {
            calculatedNumberOfDots
        }
        val dotText = ".".repeat(numberOfDots)

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = start,
                style = textStyle,
                modifier = modifier
            )
            Text(
                text = dotText,
                style = textStyle,
                modifier = modifier.weight(1F),
            )
            Text(
                text = end,
                style = textStyle,
                modifier = modifier
            )
        }
    }
}

@Composable
fun Int.pxToDp() = with(LocalDensity.current) { this@pxToDp.toDp() }

@Preview
@Composable
private fun Preview() {
    AppThemePreview {
        TextOverflowMiddle(MockData.recipe.ingredients[0].name, MockData.recipe.ingredients[0].amount)
    }
}
