package dev.pula.sofrito.presentation.navigation

import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.annotation.RootNavGraph

@NavGraph
@RootNavGraph(start = true)
@Destination
annotation class RecipesNavGraph(
    val start: Boolean = false
)

@NavGraph
@RootNavGraph
@Destination
annotation class ShoppingNavGraph(val start: Boolean = false)

@NavGraph
@RootNavGraph
@Destination
annotation class SettingsNavGraph(val start: Boolean = false)
