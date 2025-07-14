package org.verb.bodymetrics.measure.presentation.model

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.verb.bodymetrics.measure.domain.model.BodyMeasure

data class DefaultBodyMeasureIllustratedUi(
    override val labelRes: StringResource,
    override val measure: BodyMeasure,
    override val type: BodyMeasureTypeUi,
    override val iconRes: DrawableResource
) : BodyMeasureIllustratedUi