package org.verb.bodymetrics.core.presentation.navigation

import bodymetrics.composeapp.generated.resources.Res
import bodymetrics.composeapp.generated.resources.graph
import bodymetrics.composeapp.generated.resources.home
import bodymetrics.composeapp.generated.resources.settings
import org.jetbrains.compose.resources.DrawableResource

sealed class Screens(open val route: String) {
    sealed class NavigationBar(override val route: String, val label: String, val icon: DrawableResource) : Screens(route) {
        data object Home : NavigationBar("home", "Home", Res.drawable.home)
        data object Stats : NavigationBar("stats", "Statistics", Res.drawable.graph)
        data object Settings : NavigationBar("settings", "Settings", Res.drawable.settings)
    }
    data object Measure : Screens("measure")

    companion object {
        fun navigationBarScreens() = listOf(NavigationBar.Home, NavigationBar.Stats, NavigationBar.Settings)
    }
}