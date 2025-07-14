package org.verb.bodymetrics.measure.domain.usecases

import kotlinx.coroutines.flow.Flow
import org.verb.bodymetrics.measure.domain.model.BodyMeasure
import org.verb.bodymetrics.measure.domain.repository.MeasureRepository
import kotlin.coroutines.CoroutineContext

class ObserveSelectedMeasuresValuesUseCase(
    private val repository: MeasureRepository
) {
    fun execute(context: CoroutineContext): Flow<List<Pair<BodyMeasure, Double>>> {
        return repository.observeSelectedBodyMeasuresValues(context)
    }
}
