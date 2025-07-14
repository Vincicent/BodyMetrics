package org.verb.bodymetrics.measure.presentation

import org.verb.bodymetrics.measure.presentation.model.BodyMeasureInputUi

data class InsertMeasuresState(
    val neededMeasures:List<BodyMeasureInputUi> = emptyList(),
    val displayState: DisplayState? = null
)

enum class DisplayState {
    LOADING,
    DISPLAY,
    ERROR
}
