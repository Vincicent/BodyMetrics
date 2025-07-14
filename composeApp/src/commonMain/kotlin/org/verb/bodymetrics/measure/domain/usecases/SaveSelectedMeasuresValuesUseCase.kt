package org.verb.bodymetrics.measure.domain.usecases

import org.verb.bodymetrics.measure.domain.model.BodyMeasure
import org.verb.bodymetrics.measure.domain.repository.MeasureRepository

class SaveSelectedMeasuresValuesUseCase(
    private val repository: MeasureRepository
) {
    fun execute(values: List<Pair<BodyMeasure, Double>>) {
        return repository.saveSelectedBodyMeasuresValues(values)
    }
}
