package org.verb.bodymetrics.measure.presentation.mapper

import bodymetrics.composeapp.generated.resources.Res
import bodymetrics.composeapp.generated.resources.arm_left_label
import bodymetrics.composeapp.generated.resources.arm_right_label
import bodymetrics.composeapp.generated.resources.back
import bodymetrics.composeapp.generated.resources.biceps
import bodymetrics.composeapp.generated.resources.body_fat
import bodymetrics.composeapp.generated.resources.body_fat_percentage_label
import bodymetrics.composeapp.generated.resources.body_height
import bodymetrics.composeapp.generated.resources.body_height_label
import bodymetrics.composeapp.generated.resources.body_mass_index_label
import bodymetrics.composeapp.generated.resources.body_muscle_percentage
import bodymetrics.composeapp.generated.resources.body_muscle_percentage_label
import bodymetrics.composeapp.generated.resources.body_water
import bodymetrics.composeapp.generated.resources.body_water_percentage_label
import bodymetrics.composeapp.generated.resources.body_weight
import bodymetrics.composeapp.generated.resources.body_weight_label
import bodymetrics.composeapp.generated.resources.calve
import bodymetrics.composeapp.generated.resources.calve_left_label
import bodymetrics.composeapp.generated.resources.calve_right_label
import bodymetrics.composeapp.generated.resources.chest
import bodymetrics.composeapp.generated.resources.chest_label
import bodymetrics.composeapp.generated.resources.forearm
import bodymetrics.composeapp.generated.resources.forearm_left_label
import bodymetrics.composeapp.generated.resources.forearm_right_label
import bodymetrics.composeapp.generated.resources.glutes
import bodymetrics.composeapp.generated.resources.glutes_label
import bodymetrics.composeapp.generated.resources.leg
import bodymetrics.composeapp.generated.resources.leg_left_label
import bodymetrics.composeapp.generated.resources.leg_right_label
import bodymetrics.composeapp.generated.resources.neck
import bodymetrics.composeapp.generated.resources.neck_label
import bodymetrics.composeapp.generated.resources.shoulders
import bodymetrics.composeapp.generated.resources.shoulders_label
import bodymetrics.composeapp.generated.resources.upper_back_label
import bodymetrics.composeapp.generated.resources.waist
import bodymetrics.composeapp.generated.resources.waist_label
import org.jetbrains.compose.resources.DrawableResource
import org.verb.bodymetrics.measure.domain.model.BodyMeasure
import org.verb.bodymetrics.measure.domain.model.BodyMeasureType
import org.verb.bodymetrics.measure.presentation.model.BodyMeasureTypeUi
import org.verb.bodymetrics.measure.presentation.model.BodyMeasureChipUi
import org.verb.bodymetrics.measure.presentation.model.BodyMeasureInputUi
import org.verb.bodymetrics.measure.presentation.model.DefaultBodyMeasureIllustratedUi
import org.verb.bodymetrics.measure.presentation.model.DefaultBodyMeasureUi

fun BodyMeasure.toChipUi(): BodyMeasureChipUi {
    return this.toDefaultUi().let {
        BodyMeasureChipUi(
            labelRes = it.labelRes,
            measure = it.measure,
            type = it.type,
        )
    }
}

fun BodyMeasure.toInputUi(): BodyMeasureInputUi {
    return this.toDefaultIllustratedUi().let {
        BodyMeasureInputUi(
            labelRes = it.labelRes,
            measure = it.measure,
            type = it.type,
            iconRes = it.iconRes
        )
    }
}

fun BodyMeasure.toDefaultIllustratedUi(): DefaultBodyMeasureIllustratedUi {
    return this.toDefaultUi().let {
        DefaultBodyMeasureIllustratedUi(
            labelRes = it.labelRes,
            measure = it.measure,
            type = it.type,
            iconRes = this.toDrawableResource()
        )
    }
}

private fun BodyMeasure.toDrawableResource(): DrawableResource {
    return when (this) {
        BodyMeasure.Neck -> Res.drawable.neck
        BodyMeasure.Shoulders -> Res.drawable.shoulders
        BodyMeasure.Chest -> Res.drawable.chest
        BodyMeasure.UpperBack -> Res.drawable.back
        BodyMeasure.ArmRight -> Res.drawable.biceps
        BodyMeasure.ArmLeft -> Res.drawable.biceps
        BodyMeasure.ForearmRight -> Res.drawable.forearm
        BodyMeasure.ForearmLeft -> Res.drawable.forearm
        BodyMeasure.Waist -> Res.drawable.waist
        BodyMeasure.Glutes -> Res.drawable.glutes
        BodyMeasure.LegRight -> Res.drawable.leg
        BodyMeasure.LegLeft -> Res.drawable.leg
        BodyMeasure.CalveRight -> Res.drawable.calve
        BodyMeasure.CalveLeft -> Res.drawable.calve
        BodyMeasure.BodyWeight -> Res.drawable.body_weight
        BodyMeasure.BodyHeight -> Res.drawable.body_height
        BodyMeasure.BodyFatPercentage -> Res.drawable.body_fat
        BodyMeasure.BodyWaterPercentage -> Res.drawable.body_water
        BodyMeasure.BodyMusclePercentage -> Res.drawable.body_muscle_percentage
        BodyMeasure.BodyMassIndex -> Res.drawable.body_weight
    }
}

private fun BodyMeasure.toDefaultUi(): DefaultBodyMeasureUi = when (this) {
    BodyMeasure.Neck -> DefaultBodyMeasureUi(
        labelRes = Res.string.neck_label,
        measure = this,
        type = type.toUi()
    )

    BodyMeasure.Shoulders -> DefaultBodyMeasureUi(
        labelRes = Res.string.shoulders_label,
        measure = this,
        type = type.toUi(),
    )

    BodyMeasure.Chest -> DefaultBodyMeasureUi(
        labelRes = Res.string.chest_label,
        measure = this,
        type = type.toUi(),
    )

    BodyMeasure.UpperBack -> DefaultBodyMeasureUi(
        labelRes = Res.string.upper_back_label,
        measure = this,
        type = type.toUi(),
    )

    BodyMeasure.ArmRight -> DefaultBodyMeasureUi(
        labelRes = Res.string.arm_right_label,
        measure = this,
        type = type.toUi(),
    )

    BodyMeasure.ArmLeft -> DefaultBodyMeasureUi(
        labelRes = Res.string.arm_left_label,
        measure = this,
        type = type.toUi(),
    )

    BodyMeasure.ForearmRight -> DefaultBodyMeasureUi(
        labelRes = Res.string.forearm_right_label,
        measure = this,
        type = type.toUi(),
    )

    BodyMeasure.ForearmLeft -> DefaultBodyMeasureUi(
        labelRes = Res.string.forearm_left_label,
        measure = this,
        type = type.toUi(),
    )

    BodyMeasure.Waist -> DefaultBodyMeasureUi(
        labelRes = Res.string.waist_label,
        measure = this,
        type = type.toUi()
    )

    BodyMeasure.Glutes -> DefaultBodyMeasureUi(
        labelRes = Res.string.glutes_label,
        measure = this,
        type = type.toUi(),
    )

    BodyMeasure.LegRight -> DefaultBodyMeasureUi(
        labelRes = Res.string.leg_right_label,
        measure = this,
        type = type.toUi(),
    )

    BodyMeasure.LegLeft -> DefaultBodyMeasureUi(
        labelRes = Res.string.leg_left_label,
        measure = this,
        type = type.toUi(),
    )

    BodyMeasure.CalveRight -> DefaultBodyMeasureUi(
        labelRes = Res.string.calve_right_label,
        measure = this,
        type = type.toUi(),
    )

    BodyMeasure.CalveLeft -> DefaultBodyMeasureUi(
        labelRes = Res.string.calve_left_label,
        measure = this,
        type = type.toUi(),
    )

    BodyMeasure.BodyWeight -> DefaultBodyMeasureUi(
        labelRes = Res.string.body_weight_label,
        measure = this,
        type = type.toUi(),
    )

    BodyMeasure.BodyHeight -> DefaultBodyMeasureUi(
        labelRes = Res.string.body_height_label,
        measure = this,
        type = type.toUi(),
    )

    BodyMeasure.BodyFatPercentage -> DefaultBodyMeasureUi(
        labelRes = Res.string.body_fat_percentage_label,
        measure = this,
        type = type.toUi(),
    )

    BodyMeasure.BodyWaterPercentage -> DefaultBodyMeasureUi(
        labelRes = Res.string.body_water_percentage_label,
        measure = this,
        type = type.toUi(),
    )

    BodyMeasure.BodyMusclePercentage -> DefaultBodyMeasureUi(
        labelRes = Res.string.body_muscle_percentage_label,
        measure = this,
        type = type.toUi(),
    )

    BodyMeasure.BodyMassIndex -> DefaultBodyMeasureUi(
        labelRes = Res.string.body_mass_index_label,
        measure = this,
        type = type.toUi(),
    )
}

fun BodyMeasureType.toUi(): BodyMeasureTypeUi = when (this) {
    BodyMeasureType.BODY_MEASUREMENTS -> BodyMeasureTypeUi.Measurements
    BodyMeasureType.BODY_INDICES -> BodyMeasureTypeUi.Indices
    BodyMeasureType.BODY_CALCULATED_INDICES -> BodyMeasureTypeUi.CalculatedIndices
}

fun BodyMeasureChipUi.toDomain(): BodyMeasure = this.measure

fun BodyMeasureInputUi.toDomain(): BodyMeasure = this.measure

