package dev.pula.sofrito.domain

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

sealed class IconContainer {
    data class ImageVectorContainer(val image: ImageVector): IconContainer()
    data class DrawableContainer(@DrawableRes val drawable: Int): IconContainer()
}