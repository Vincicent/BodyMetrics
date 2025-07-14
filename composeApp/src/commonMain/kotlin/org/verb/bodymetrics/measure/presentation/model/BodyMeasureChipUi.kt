package org.verb.bodymetrics.measure.presentation.model

import org.jetbrains.compose.resources.StringResource
import org.verb.bodymetrics.core.presentation.model.ChipUi
import org.verb.bodymetrics.measure.domain.model.BodyMeasure

data class BodyMeasureChipUi(
    override val labelRes: StringResource,
    override val measure: BodyMeasure,
    override val type: BodyMeasureTypeUi,
): ChipUi(), BodyMeasureUi {
    override fun title(): StringResource {
        return this.labelRes
    }
}