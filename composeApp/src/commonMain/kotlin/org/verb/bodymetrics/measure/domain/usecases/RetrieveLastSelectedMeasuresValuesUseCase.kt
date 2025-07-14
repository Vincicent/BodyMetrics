package org.verb.bodymetrics.measure.domain.usecases

import org.verb.bodymetrics.core.domain.util.Resource
import org.verb.bodymetrics.measure.domain.model.BodyMeasure
import org.verb.bodymetrics.measure.domain.repository.MeasureRepository

class RetrieveLastSelectedMeasuresValuesUseCase(
    private val repository: MeasureRepository
) {
    fun execute(): Resource<List<BodyMeasure>, Throwable> {
        return repository.retrieveSelectedBodyMeasures()
    }
}
