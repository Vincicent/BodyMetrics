package org.verb.bodymetrics.measure.presentation.model

import bodymetrics.composeapp.generated.resources.Res
import bodymetrics.composeapp.generated.resources.body_calculated_indices
import bodymetrics.composeapp.generated.resources.body_indices
import bodymetrics.composeapp.generated.resources.body_measurements
import org.jetbrains.compose.resources.StringResource

sealed class BodyMeasureTypeUi(val labelRes: StringResource) {
    data object Measurements : BodyMeasureTypeUi(Res.string.body_measurements)
    data object Indices : BodyMeasureTypeUi(Res.string.body_indices)
    data object CalculatedIndices : BodyMeasureTypeUi(Res.string.body_calculated_indices)
}