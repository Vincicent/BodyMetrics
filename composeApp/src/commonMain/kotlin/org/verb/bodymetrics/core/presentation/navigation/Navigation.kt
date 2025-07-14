package org.verb.bodymetrics.core.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.koin.compose.viewmodel.koinViewModel
import org.verb.bodymetrics.home.presentation.HomeScreenRoot
import org.verb.bodymetrics.home.presentation.HomeScreenViewModel
import org.verb.bodymetrics.measure.presentation.MeasureScreenRoot
import org.verb.bodymetrics.measure.presentation.MeasureViewModel
import org.verb.bodymetrics.measure.presentation.components.select_measures.SelectMeasuresViewModel
import org.verb.bodymetrics.settings.presentation.SettingsScreenRoot
import org.verb.bodymetrics.stats.presentation.StatisticsScreenRoot

@Composable
fun Navigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController, startDestination = Screens.NavigationBar.Home.route, modifier = modifier.fillMaxSize()) {
        composable(Screens.NavigationBar.Home.route) {
            val viewModel = koinViewModel<HomeScreenViewModel>()
            val selectMeasuresViewModel = koinViewModel<SelectMeasuresViewModel>()

            HomeScreenRoot(
                viewModel = viewModel,
                selectMeasuresViewModel = selectMeasuresViewModel,
                onSelectedMeasuresSaved = { navController.navigate(Routes.Measure.route) }
            )
        }
        composable(Screens.NavigationBar.Stats.route) { StatisticsScreenRoot() }
        composable(Screens.NavigationBar.Settings.route) { SettingsScreenRoot() }
        composable(Routes.Measure.route) {
            val measureViewModel = koinViewModel<MeasureViewModel>()

            MeasureScreenRoot(
                viewModel = measureViewModel,
                onBack = {
                    navController.popBackStack()
                },
                onMeasuresSaved = {
                    navController.popBackStack()
                }
            )
        }
    }
}