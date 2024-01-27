package dev.pula.sofrito.presentation.common

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(name = "TabLandscape", widthDp = 700, heightDp = 500)
@Preview(name = "TabLandDark", widthDp = 700, heightDp = 500, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(name = "TabPortrait", widthDp = 500, heightDp = 700)
@Preview(name = "TabPortrait", widthDp = 500, heightDp = 700, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(name = "DeskLandscape", widthDp = 1100, heightDp = 600)
@Preview(name = "DeskPortrait", widthDp = 600, heightDp = 1100)
annotation class PreviewLargeDevices


@Preview(name = "PhonePortrait", widthDp = 412, heightDp = 915)
@Preview(name = "PhoneLandscape", widthDp = 915, heightDp = 412)
@Preview(name = "PhonePortraitDark", widthDp = 412, heightDp = 912, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(name = "PhoneLandscapeDark", widthDp = 915, heightDp = 412, uiMode = Configuration.UI_MODE_NIGHT_YES)
annotation class PreviewSmallDevices
