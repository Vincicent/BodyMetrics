package org.verb.bodymetrics.measure.presentation.model

import androidx.compose.foundation.text.input.TextFieldState
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.verb.bodymetrics.core.presentation.model.ChipUi
import org.verb.bodymetrics.measure.domain.model.BodyMeasure

data class BodyMeasureInputUi(
    override val labelRes: StringResource,
    override val measure: BodyMeasure,
    override val type: BodyMeasureTypeUi,
    override val iconRes: DrawableResource,
    val value: TextFieldState = TextFieldState(),
): BodyMeasureIllustratedUi