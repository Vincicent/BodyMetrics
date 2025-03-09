package org.verb.bodymetrics.core.presentation.navigation

import bodymetrics.composeapp.generated.resources.Res
import bodymetrics.composeapp.generated.resources.graph
import bodymetrics.composeapp.generated.resources.home
import bodymetrics.composeapp.generated.resources.settings
import org.jetbrains.compose.resources.DrawableResource

sealed class Screen(val route: String, val label: String, val icon: DrawableResource) {
    data object Home : Screen("home", "Home", Res.drawable.home)
    data object Stats : Screen("stats", "Statistics", Res.drawable.graph)
    data object Settings : Screen("settings", "Settings", Res.drawable.settings)
}