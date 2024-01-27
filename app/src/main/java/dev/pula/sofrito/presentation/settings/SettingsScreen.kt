package dev.pula.sofrito.presentation.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dev.pula.sofrito.presentation.common.PreviewLargeDevices
import dev.pula.sofrito.presentation.common.PreviewSmallDevices
import dev.pula.sofrito.presentation.navigation.SettingsNavGraph
import dev.pula.sofrito.presentation.theme.AppThemePreview

@SettingsNavGraph(start = true)
@Composable
fun SettingsScreen(
    @Suppress("UNUSED_PARAMETER") navigator: DestinationsNavigator
) {
    SettingsScreenContent()
}

@Composable
fun SettingsScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Text(
            text = "Settings",
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@PreviewSmallDevices
@PreviewLargeDevices
@Composable
private fun SettingsScreenPreview() {
    AppThemePreview {
        SettingsScreenContent()
    }
}
