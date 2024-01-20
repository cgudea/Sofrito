package dev.pula.sofrito.presentation

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder

//val uiModule = module {
//    viewModelOf(::NavDrawerViewModel)
//    viewModelOf(::RecipeListViewModel)
//}

val uiModuleDependenciesBuilder: @Composable (
DependenciesContainerBuilder<*>.(activity: MainActivity) -> Unit
) = { //mainActivity ->
    /**
     * Dependencies scoped to MainActivity
     */
//    dependency(getViewModel<_ViewModel>(viewModelStoreOwner = mainActivity))

    /**
     * Dependencies scoped to the home graph
     */
//    dependency(NavGraphs.home) {
//        val parentEntry = remember(navBackStackEntry) {
//            navController.getBackStackEntry(NavGraphs.home.route)
//        }
//
//        getViewModel<NavDrawerViewModel>(viewModelStoreOwner = parentEntry)
//    }
//
//    dependency(NavGraphs.home) {
//        val parentEntry = remember(navBackStackEntry) {
//            navController.getBackStackEntry(NavGraphs.home.route)
//        }
//
//        getViewModel<RecipeListViewModel>(viewModelStoreOwner = parentEntry)
//    }
}
