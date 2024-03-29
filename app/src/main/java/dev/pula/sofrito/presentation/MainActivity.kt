package dev.pula.sofrito.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.rememberNavHostEngine
import dev.pula.sofrito.presentation.navigation.NavigationMenu
import dev.pula.sofrito.presentation.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent(this)
        }
    }
}

@Composable
fun MainContent(activity: MainActivity) {
    val engine = rememberNavHostEngine()
    val navController = engine.rememberNavController()
    val startRoute = NavGraphs.recipes

    AppTheme {
        NavigationMenu(navController) {
            Surface {
                DestinationsNavHost(
                    engine = engine,
                    navController = navController,
                    navGraph = NavGraphs.root,
                    startRoute = startRoute,
                    dependenciesContainerBuilder = { uiModuleDependenciesBuilder(activity) }
                )
            }
        }
    }
}

