package org.verb.bodymetrics.measure.presentation.model

import org.jetbrains.compose.resources.StringResource
import org.verb.bodymetrics.measure.domain.model.BodyMeasure

interface BodyMeasureUi {
    val labelRes: StringResource
    val measure: BodyMeasure
    val type: BodyMeasureTypeUi
}