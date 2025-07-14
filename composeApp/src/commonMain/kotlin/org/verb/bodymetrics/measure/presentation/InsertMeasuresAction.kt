package org.verb.bodymetrics.measure.presentation

import org.verb.bodymetrics.measure.presentation.model.BodyMeasureInputUi

sealed interface InsertMeasuresAction {
    data class OnCompletionFinished(val selectedMeasures: List<BodyMeasureInputUi>): InsertMeasuresAction
    data object OnClose: InsertMeasuresAction
}