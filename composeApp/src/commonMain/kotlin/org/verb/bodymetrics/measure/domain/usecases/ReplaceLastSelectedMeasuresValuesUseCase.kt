package org.verb.bodymetrics.measure.domain.usecases

import org.verb.bodymetrics.measure.domain.model.BodyMeasure
import org.verb.bodymetrics.measure.domain.repository.MeasureRepository

class ReplaceLastSelectedMeasuresValuesUseCase(
    private val repository: MeasureRepository
) {
    fun execute(values: List<BodyMeasure>) {
        return repository.replaceSelectedBodyMeasures(values)
    }
}
