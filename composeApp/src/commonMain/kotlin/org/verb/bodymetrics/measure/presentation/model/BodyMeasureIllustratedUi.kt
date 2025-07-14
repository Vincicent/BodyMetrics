package org.verb.bodymetrics.measure.presentation.model

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.verb.bodymetrics.measure.domain.model.BodyMeasure

interface BodyMeasureIllustratedUi: BodyMeasureUi {
    val iconRes: DrawableResource
}