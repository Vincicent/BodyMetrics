package org.verb.bodymetrics.measure.domain.usecases

import org.verb.bodymetrics.core.domain.util.Resource
import org.verb.bodymetrics.measure.domain.model.BodyMeasure
import org.verb.bodymetrics.measure.domain.repository.MeasureRepository

class RetrieveSelectedMeasuresValuesUseCase(
    private val repository: MeasureRepository
) {
    fun execute(): Resource<List<Pair<BodyMeasure, Double>>, Throwable> {
        return repository.retrieveSelectedBodyMeasuresValues()
    }
}
