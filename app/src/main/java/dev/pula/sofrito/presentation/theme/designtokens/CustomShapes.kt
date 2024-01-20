package dev.pula.sofrito.presentation.theme.designtokens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import dev.pula.sofrito.presentation.theme.AppThemePreview

class ToqueShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline = Outline.Generic(
        path = drawHatPath(size = size)
    )
}

private fun drawHatPath(size: Size): Path = Path().apply {
    // base rectangle
    addOval(
        Rect(
            Offset(x = size.width / 4f - 5, y = size.height - 10),
            size = Size(width = 10f, height = 10f)
        )
    )
    addRect(
        Rect(
            topLeft = Offset(x = size.width / 4f - 5, y = size.height / 4f),
            bottomRight = Offset(x = size.width- size.width / 4f + 5, y = size.height - 5)
        )
    )
    addRect(
        Rect(
            topLeft = Offset(x = size.width / 4f, y = size.height / 4f),
            bottomRight = Offset(x = size.width- size.width / 4f, y = size.height)
        )
    )
    addOval(
        Rect(
            Offset(x = size.width - size.width / 4f - 5, y = size.height - 10),
            size = Size(width = 10f, height = 10f)
        )
    )
    // left oval
    addOval(
        Rect(
            Offset(x = 0f, y = size.height / 6f),
            size = Size(width = size.width/2f, height = size.height/2f)
        )
    )
    // center oval
    addOval(
        Rect(
            Offset(x = size.width / 4f, y = size.height / 16),
            size = Size(width = size.width/2f, height = size.height/2f)
        )
    )
    // right oval
    addOval(
        Rect(
            offset = Offset(x = size.width - size.width / 2f, y = size.height / 6f),
            size = Size(width = size.width / 2f, height = size.height / 2f)
        )
    )
}

class TicketShape(private val cornerRadius: Dp) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            // Draw your custom path here
            path = drawTicketPath(size = size, cornerRadius = cornerRadius.value)
        )
    }
}

private fun drawTicketPath(size: Size, cornerRadius: Float): Path = Path().apply {
    reset()
    // Top left arc
    arcTo(
        rect = Rect(
            left = -cornerRadius,
            top = -cornerRadius,
            right = cornerRadius,
            bottom = cornerRadius
        ),
        startAngleDegrees = 90.0f,
        sweepAngleDegrees = -90.0f,
        forceMoveTo = false
    )
    lineTo(x = size.width - cornerRadius, y = 0f)
    // Top right arc
    arcTo(
        rect = Rect(
            left = size.width - cornerRadius,
            top = -cornerRadius,
            right = size.width + cornerRadius,
            bottom = cornerRadius
        ),
        startAngleDegrees = 180.0f,
        sweepAngleDegrees = -90.0f,
        forceMoveTo = false
    )
    lineTo(x = size.width, y = size.height - cornerRadius)
    // Bottom right arc
    arcTo(
        rect = Rect(
            left = size.width - cornerRadius,
            top = size.height - cornerRadius,
            right = size.width + cornerRadius,
            bottom = size.height + cornerRadius
        ),
        startAngleDegrees = 270.0f,
        sweepAngleDegrees = -90.0f,
        forceMoveTo = false
    )
    lineTo(x = cornerRadius, y = size.height)
    // Bottom left arc
    arcTo(
        rect = Rect(
            left = -cornerRadius,
            top = size.height - cornerRadius,
            right = cornerRadius,
            bottom = size.height + cornerRadius
        ),
        startAngleDegrees = 0.0f,
        sweepAngleDegrees = -90.0f,
        forceMoveTo = false
    )
    lineTo(x = 0f, y = cornerRadius)
    close()
}

class RoundedRectOutlinedCorner(
    private val cornerRadius: Dp = 16.dp,
    private val cutOutHeight: Dp = 60.dp,
    private val cutOutWidth: Dp = 145.dp
) : Shape {
    override fun createOutline(
        size: Size, layoutDirection: LayoutDirection, density: Density
    ): Outline {
        return Outline.Generic(Path().apply {
            val cornerRadius = with(density) { cornerRadius.toPx() }
            val cutOutHeight = with(density) { cutOutHeight.toPx() }
            val cutOutWidth = with(density) { cutOutWidth.toPx() }

            arcTo(
                rect = Rect(offset = Offset(0f, 0f), Size(cornerRadius, cornerRadius)),
                startAngleDegrees = 180f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )

            lineTo(size.width - cutOutWidth - cornerRadius, 0f)
            arcTo(
                rect = Rect(
                    offset = Offset(size.width - cutOutWidth - cornerRadius, 0f),
                    Size(cornerRadius, cornerRadius)
                ), startAngleDegrees = 270.0f, sweepAngleDegrees = 90f, forceMoveTo = false
            )

            lineTo(size.width - cutOutWidth, cutOutHeight - cornerRadius)
            arcTo(
                rect = Rect(
                    offset = Offset(size.width - cutOutWidth, cutOutHeight - cornerRadius),
                    Size(cornerRadius, cornerRadius)
                ), startAngleDegrees = 180.0f, sweepAngleDegrees = -90f, forceMoveTo = false
            )

            lineTo(size.width - cornerRadius, cutOutHeight)
            arcTo(
                rect = Rect(
                    offset = Offset(size.width - cornerRadius, cutOutHeight),
                    Size(cornerRadius, cornerRadius)
                ), startAngleDegrees = 270f, sweepAngleDegrees = 90f, forceMoveTo = false
            )

            lineTo(size.width, size.height - cornerRadius)
            arcTo(
                rect = Rect(
                    offset = Offset(size.width - cornerRadius, size.height - cornerRadius),
                    Size(cornerRadius, cornerRadius)
                ), startAngleDegrees = 0f, sweepAngleDegrees = 90f, forceMoveTo = false
            )

            lineTo(cornerRadius, size.height)
            arcTo(
                rect = Rect(
                    offset = Offset(0f, size.height - cornerRadius),
                    Size(cornerRadius, cornerRadius)
                ), startAngleDegrees = 90f, sweepAngleDegrees = 90f, forceMoveTo = false
            )
            close()
        })
    }
}

class TrapezoidShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            Path().apply {
                moveTo(x = 0f, y = size.height * 7f / 8f)
                lineTo(x = size.width / 4f, y = size.height / 8f)
                lineTo(x = size.width, y = size.height / 8f)
                lineTo(x = size.width* 3f / 4f, y = size.height * 7f / 8f)
                close()
            }
        )
    }
}

@Preview(widthDp = 352, heightDp = 300)
@Preview(widthDp = 352, heightDp = 300, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ShapesPreview() {
    AppThemePreview {
        LazyVerticalGrid(
            modifier = Modifier.padding(16.dp),
            columns = GridCells.FixedSize(80.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                ShapePreviewItem(
                    shape = TicketShape(12.dp),
                    shapeLabel = "Ticket Shape",
                )
            }

            item {
                ShapePreviewItem(
                    shape = ToqueShape(),
                    shapeLabel = "Hat Shape",
                )
            }

            item {
                ShapePreviewItem(
                    shape = RoundedRectOutlinedCorner(
                        cornerRadius = 8.dp,
                        cutOutHeight = 12.dp,
                        cutOutWidth = 12.dp
                    ),
                    shapeLabel = "Cut Out Shape",
                )
            }

            item {
                ShapePreviewItem(
                    shape = TrapezoidShape(),
                    shapeLabel = "Trapezoid Shape",
                )
            }

            item {
                ShapePreviewItem(
                    shape = RoundedCornerShape(bottomEnd = 16.dp),
                    shapeLabel = "Round Corner",
                )
            }


            item {
                ShapePreviewItem(
                    shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 4.dp,
                        bottomStart = 12.dp,
                        bottomEnd = 16.dp
                    ),
                    shapeLabel = "Round Corner Alt",
                )
            }

            item {
                ShapePreviewItem(
                    shape = CutCornerShape(bottomEnd = 8.dp),
                    shapeLabel = "Cut Corner",
                )
            }


            item {
                ShapePreviewItem(
                    shape = CutCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp,
                        bottomStart = 16.dp,
                        bottomEnd = 16.dp
                    ),
                    shapeLabel = "Cut Corner Alt",
                )
            }

        }
    }
}

@Composable
private fun ShapePreviewItem(
    containerSize: Dp = 32.dp,
    shape: Shape,
    shapeLabel: String,
    icon: ImageVector = Icons.Filled.Notifications
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(containerSize)
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = shape
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "",
                modifier = Modifier.size(16.dp)
            )
        }
        Text(text = shapeLabel, style = MaterialTheme.typography.labelSmall)
    }

}
