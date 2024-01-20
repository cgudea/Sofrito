package dev.pula.sofrito.presentation.common

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(name = "TabLandscape",showBackground = true, widthDp = 700, heightDp = 500)
@Preview(name = "TabLandDark",showBackground = true, widthDp = 700, heightDp = 500, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(name = "TabPortrait",showBackground = true, widthDp = 500, heightDp = 700)
@Preview(name = "TabPortrait",showBackground = true, widthDp = 500, heightDp = 700, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(name = "DeskLandscape",showBackground = true, widthDp = 1100, heightDp = 600)
@Preview(name = "DeskPortrait",showBackground = true, widthDp = 600, heightDp = 1100)
annotation class PreviewLargeDevices

