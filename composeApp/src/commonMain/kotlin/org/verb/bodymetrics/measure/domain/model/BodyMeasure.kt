package org.verb.bodymetrics.measure.domain.model

enum class BodyMeasureType {
    BODY_MEASUREMENTS,
    BODY_INDICES,
    BODY_CALCULATED_INDICES,
}

sealed class BodyMeasure(val type: BodyMeasureType) {
    data object Neck : BodyMeasure(BodyMeasureType.BODY_MEASUREMENTS)
    data object Shoulders : BodyMeasure(BodyMeasureType.BODY_MEASUREMENTS)
    data object Chest : BodyMeasure(BodyMeasureType.BODY_MEASUREMENTS)
    data object UpperBack : BodyMeasure(BodyMeasureType.BODY_MEASUREMENTS)
    data object ArmRight : BodyMeasure(BodyMeasureType.BODY_MEASUREMENTS)
    data object ArmLeft : BodyMeasure(BodyMeasureType.BODY_MEASUREMENTS)
    data object ForearmRight : BodyMeasure(BodyMeasureType.BODY_MEASUREMENTS)
    data object ForearmLeft : BodyMeasure(BodyMeasureType.BODY_MEASUREMENTS)
    data object Waist : BodyMeasure(BodyMeasureType.BODY_MEASUREMENTS)
    data object Glutes : BodyMeasure(BodyMeasureType.BODY_MEASUREMENTS)
    data object LegRight : BodyMeasure(BodyMeasureType.BODY_MEASUREMENTS)
    data object LegLeft : BodyMeasure(BodyMeasureType.BODY_MEASUREMENTS)
    data object CalveRight : BodyMeasure(BodyMeasureType.BODY_MEASUREMENTS)
    data object CalveLeft : BodyMeasure(BodyMeasureType.BODY_MEASUREMENTS)

    data object BodyWeight : BodyMeasure(BodyMeasureType.BODY_INDICES)
    data object BodyHeight : BodyMeasure(BodyMeasureType.BODY_INDICES)
    data object BodyFatPercentage : BodyMeasure(BodyMeasureType.BODY_INDICES)
    data object BodyWaterPercentage : BodyMeasure(BodyMeasureType.BODY_INDICES)
    data object BodyMusclePercentage : BodyMeasure(BodyMeasureType.BODY_INDICES)

    data object BodyMassIndex : BodyMeasure(BodyMeasureType.BODY_CALCULATED_INDICES)

    companion object {
        fun values() = listOf(Neck, Shoulders, Chest, UpperBack, ArmRight, ArmLeft, ForearmRight, ForearmLeft, Waist, Glutes, LegRight, LegLeft, CalveRight, CalveLeft, BodyWeight, BodyHeight, BodyFatPercentage, BodyWaterPercentage, BodyMusclePercentage, BodyMassIndex)
        fun nonCalculatedBodyMeasure() = values().filter { it.type != BodyMeasureType.BODY_CALCULATED_INDICES }

        fun valueOf(value: String): BodyMeasure = when (value) {
            "Neck" -> Neck
            "Shoulders" -> Shoulders
            "Chest" -> Chest
            "UpperBack" -> UpperBack
            "ArmRight" -> ArmRight
            "ArmLeft" -> ArmLeft
            "ForearmRight" -> ForearmRight
            "ForearmLeft" -> ForearmLeft
            "Waist" -> Waist
            "Glutes" -> Glutes
            "LegRight" -> LegRight
            "LegLeft" -> LegLeft
            "CalveRight" -> CalveRight
            "CalveLeft" -> CalveLeft
            "BodyWeight" -> BodyWeight
            "BodyHeight" -> BodyHeight
            "BodyFatPercentage" -> BodyFatPercentage
            "BodyWaterPercentage" -> BodyWaterPercentage
            "BodyMusclePercentage" -> BodyMusclePercentage
            "BodyMassIndex" -> BodyMassIndex
            else -> throw IllegalArgumentException()
        }
    }
}

