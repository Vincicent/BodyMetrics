package org.verb.bodymetrics.core.presentation.navigation

sealed class Routes(val route: String) {
    data object Home: Routes("home")
    data object Measure : Routes("measure")
}