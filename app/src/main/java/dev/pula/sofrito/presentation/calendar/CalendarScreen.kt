package dev.pula.sofrito.presentation.calendar

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
import dev.pula.sofrito.presentation.navigation.CalendarNavGraph
import dev.pula.sofrito.presentation.theme.AppThemePreview

@CalendarNavGraph(start = true)
@Composable
fun CalendarScreen(
    @Suppress("UNUSED_PARAMETER") navigator: DestinationsNavigator
) {
    CalendarScreenContent()
}

@Composable
fun CalendarScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Text(
            text = "Calendar",
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@PreviewSmallDevices
@PreviewLargeDevices
@Composable
private fun CalendarScreenPreview() {
    AppThemePreview {
        CalendarScreenContent()
    }
}
