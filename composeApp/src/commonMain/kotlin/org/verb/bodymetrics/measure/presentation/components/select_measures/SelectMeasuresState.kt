package org.verb.bodymetrics.measure.presentation.components.select_measures

import org.verb.bodymetrics.measure.presentation.model.BodyMeasureChipUi

data class SelectMeasuresState(
    val lastSelectedMeasures:List<BodyMeasureChipUi> = emptyList(),
    val displayState: DisplayState? = null
)

enum class DisplayState {
    LOADING,
    DISPLAY,
    ERROR
}
