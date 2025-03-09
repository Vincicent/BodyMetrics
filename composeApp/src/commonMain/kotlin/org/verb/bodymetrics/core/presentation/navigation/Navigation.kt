package org.verb.bodymetrics.core.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.verb.bodymetrics.HomeScreenRoot
import org.verb.bodymetrics.settings.presentation.SettingsScreenRoot
import org.verb.bodymetrics.stats.presentation.StatisticsScreenRoot

@Composable
fun Navigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController, startDestination = Screen.Home.route, modifier = modifier.fillMaxSize()) {
        composable(Screen.Home.route) { HomeScreenRoot() }
        composable(Screen.Stats.route) { StatisticsScreenRoot() }
        composable(Screen.Settings.route) { SettingsScreenRoot() }
    }
}