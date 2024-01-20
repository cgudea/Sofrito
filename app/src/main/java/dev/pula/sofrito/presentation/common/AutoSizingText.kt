package dev.pula.sofrito.presentation.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.InternalFoundationTextApi
import androidx.compose.foundation.text.TextDelegate
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFontFamilyResolver
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.pula.sofrito.presentation.common.AutoSizingText.Companion.DEFAULT_AUTO_SIZE_MAX_TEXT_SIZE
import dev.pula.sofrito.presentation.common.AutoSizingText.Companion.DEFAULT_AUTO_SIZE_MIN_TEXT_SIZE

class AutoSizingText private constructor() {
    companion object {
        val DEFAULT_AUTO_SIZE_MIN_TEXT_SIZE = 12.sp
        val DEFAULT_AUTO_SIZE_MAX_TEXT_SIZE = 112.sp
    }
}

/**
 * High level element that displays text and scales to fit the provided horizontal space by
 * utilizing a binary search.
 *
 * The [text] provided can include newline characters to forcefully split the string. In this case
 * the [maxLines] parameter will be ignored and automatically calculated.
 *
 * The default [style] uses the [LocalTextStyle] provided by the [MaterialTheme] / components. If
 * you are setting your own style, you may want to consider first retrieving [LocalTextStyle],
 * and using [TextStyle.copy] to keep any theme defined attributes, only modifying the specific
 * attributes you want to override.
 *
 *
 * @param modifier [Modifier] to apply to this layout node.
 * @param text The text to be displayed.
 * @param style Style configuration for the text such as color, font, line height etc.
 * @param stepGranularity The text size step used in the search to fit the string horizontally.
 * @param maxLines The number of lines to be utilized to split the text
 * @param minTextSize The lower limit of the text size.
 * @param maxTextSize The upper limit of the text size.
 */
@Suppress("ReusedModifierInstance")
@Composable
fun AutoSizingText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    maxLines: Int = 1,
    stepGranularity: TextUnit = 2.sp,
    minTextSize: TextUnit = DEFAULT_AUTO_SIZE_MIN_TEXT_SIZE,
    maxTextSize: TextUnit = DEFAULT_AUTO_SIZE_MAX_TEXT_SIZE
) {
    val calculatedLines = if (text.contains('\n')) {
        text.split('\n').size
    } else {
        maxLines
    }
    BoxWithConstraints(modifier = modifier.then(Modifier.fillMaxWidth())) {
        AutoSizingText(
            text = text,
            modifier = modifier,
            textStyle = style,
            maxLines = calculatedLines,
            stepGranularity = stepGranularity,
            minTextSize = minTextSize,
            maxTextSize = maxTextSize,
            constraints = constraints
        )
    }
}

/**
 * High level element that displays text and scales to fit the provided horizontal space by
 * utilizing a binary search.
 *
 * The [text] provided can include newline characters to forcefully split the string. In this case
 * the [maxLines] parameter will be ignored and automatically calculated.
 *
 * The default [textStyle] uses the [LocalTextStyle] provided by the [MaterialTheme] / components. If
 * you are setting your own style, you may want to consider first retrieving [LocalTextStyle],
 * and using [TextStyle.copy] to keep any theme defined attributes, only modifying the specific
 * attributes you want to override.
 *
 *
 * @param modifier [Modifier] to apply to this layout node.
 * @param text The text to be displayed.
 * @param textStyle Style configuration for the text such as color, font, line height etc.
 * @param stepGranularity The text size step used in the search to fit the string horizontally.
 * @param maxLines The number of lines to be utilized to split the text
 * @param minTextSize The lower limit of the text size.
 * @param maxTextSize The upper limit of the text size.
 * @param constraints The constraints to fit the text inside.
 */
@Composable
fun AutoSizingText(
    text: String,
    textStyle: TextStyle,
    maxLines: Int,
    constraints: Constraints,
    modifier: Modifier = Modifier,
    stepGranularity: TextUnit = 2.sp,
    minTextSize: TextUnit = DEFAULT_AUTO_SIZE_MIN_TEXT_SIZE,
    maxTextSize: TextUnit = DEFAULT_AUTO_SIZE_MAX_TEXT_SIZE
) {
    require(minTextSize < maxTextSize) {
        "minTextSize should be less than maxTextSize (${minTextSize.value} > ${maxTextSize.value}"
    }
    require(maxTextSize.value <= constraints.maxWidth) {
        "maxTextSize should be less than the possible constraint width" +
                "\n\tmaxTextSize: ${maxTextSize.value} > Constraints.MaxWidth: ${constraints.maxWidth}"
    }
    require(minTextSize > 0.sp) { "minWidth ${minTextSize.value} should be greater than 0.sp" }
    require(maxTextSize > 1.sp) { "maxWidth ${maxTextSize.value} should be at least 1.sp" }
    require(constraints.maxHeight > 0 && constraints.maxWidth > 0) {
        "Constraints maxHeight & maxWidth must be greater than zero!"
    }


    // generate list of text sizes to search
    val presetValues by remember {
        mutableStateOf(generateSequence(minTextSize) { (it.value + stepGranularity.value).sp }
            .take((maxTextSize.value.toInt() - minTextSize.value.toInt()) / stepGranularity.value.toInt() + 1)
            .toList()
        )
    }

    var lowIndex by remember { mutableIntStateOf(0) }
    var highIndex by remember { mutableIntStateOf(presetValues.size - 1) }
    var bestSizeIndex by remember { mutableIntStateOf(0) }
    var sizeToTryIndex: Int

    // perform binary search to find best size
    while (lowIndex <= highIndex) {
        sizeToTryIndex = (highIndex + lowIndex) / 2
        if (suggestedSizeFitsInConstraints(text, textStyle, maxLines, constraints, presetValues[sizeToTryIndex])) {
            highIndex = sizeToTryIndex - 1
            bestSizeIndex = highIndex
        } else {
            bestSizeIndex = lowIndex
            lowIndex = sizeToTryIndex + 1
        }
    }

    if (bestSizeIndex == -1) bestSizeIndex = 0

    val autoSizedStyle by remember {
        mutableStateOf(textStyle.merge(TextStyle(fontSize = presetValues[bestSizeIndex])))
    }

    Text(text = text, modifier = modifier, style = autoSizedStyle)
}

@OptIn(InternalFoundationTextApi::class)
@Composable
private fun suggestedSizeFitsInConstraints(
    text: String,
    textStyle: TextStyle,
    maxLines: Int,
    constraints: Constraints,
    suggestedSize: TextUnit
): Boolean {

    val suggestedStyle = textStyle.merge(TextStyle(fontSize = suggestedSize))

    val textDelegate = TextDelegate(
        text = AnnotatedString(text = text, paragraphStyle = textStyle.toParagraphStyle()),
        density = LocalDensity.current,
        style = suggestedStyle,
        fontFamilyResolver = LocalFontFamilyResolver.current,
        maxLines = maxLines
    )

    val layoutResult = textDelegate.layout(
        constraints = constraints,
        layoutDirection = LocalLayoutDirection.current
    )

    val shadowCanvas = Canvas(android.graphics.Canvas())

    TextDelegate.paint(canvas = shadowCanvas, textLayoutResult = layoutResult)

    return layoutResult.hasVisualOverflow
}

@Composable
@Preview
private fun Preview() {
    val twoWordNewLine = "chestnut\neggplant"
    val threeWordNewLine = "winter\nfennel azuki bean"
    val multiWordSplit = "beet broccoli\nkombu beet\ngreens fava bean"
    val style = MaterialTheme.typography.displayLarge.merge(
        TextStyle(
            color = MaterialTheme.colorScheme.secondary,
            textAlign = TextAlign.Center
        )
    )

    Surface {
        Box(Modifier.fillMaxSize().padding(horizontal = 16.dp)) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AutoSizingText(text = twoWordNewLine, style = style)
                AutoSizingText(text = threeWordNewLine, style = style)
                AutoSizingText(text = multiWordSplit, style = style)
            }
        }
    }
}