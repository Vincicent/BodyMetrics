package org.verb.bodymetrics.measure.presentation.components.select_measures

import org.verb.bodymetrics.measure.presentation.model.BodyMeasureChipUi

sealed interface SelectMeasuresAction {
    data class OnFinishSelection(val selectedMeasures: List<BodyMeasureChipUi>): SelectMeasuresAction
    data object OnClose: SelectMeasuresAction
}