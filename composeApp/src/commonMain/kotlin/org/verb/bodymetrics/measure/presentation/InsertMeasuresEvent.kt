package org.verb.bodymetrics.measure.presentation

sealed interface InsertMeasuresEvent {
    data object MeasuresSaved: InsertMeasuresEvent
}