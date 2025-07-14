package org.verb.bodymetrics.measure.presentation.components.select_measures

sealed interface SelectMeasuresEvent {
    data object SelectedMeasuresSaved: SelectMeasuresEvent
}