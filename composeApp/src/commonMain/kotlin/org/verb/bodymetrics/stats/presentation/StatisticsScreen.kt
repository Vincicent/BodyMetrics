package org.verb.bodymetrics.stats.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun StatisticsScreenRoot() {
    StatisticsScreen()
}

@Composable
private fun StatisticsScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text("StatisticsScreen")
    }
}