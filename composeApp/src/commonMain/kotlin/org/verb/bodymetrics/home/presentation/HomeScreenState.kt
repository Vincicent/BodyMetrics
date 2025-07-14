package org.verb.bodymetrics.home.presentation

import org.verb.bodymetrics.measure.presentation.model.DefaultBodyMeasureIllustratedUi

data class HomeScreenState(
    val selectedMeasuresValues: List<Pair<DefaultBodyMeasureIllustratedUi, Double>> = emptyList(),
    val displayState: DisplayState? = null
)

enum class DisplayState {
    LOADING,
    DISPLAY,
    ERROR
}
