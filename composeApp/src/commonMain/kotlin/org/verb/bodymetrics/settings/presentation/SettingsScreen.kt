package org.verb.bodymetrics.settings.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SettingsScreenRoot() {
    SettingsScreen()
}

@Composable
private fun SettingsScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text("SettingsScreen")
    }
}