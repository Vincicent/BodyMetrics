package org.verb.bodymetrics.measure.domain.repository

import kotlinx.coroutines.flow.Flow
import org.verb.bodymetrics.core.domain.util.Resource
import org.verb.bodymetrics.measure.domain.model.BodyMeasure
import kotlin.coroutines.CoroutineContext

interface MeasureRepository {
    fun retrieveSelectedBodyMeasures(): Resource<List<BodyMeasure>, Throwable>
    fun retrieveSelectedBodyMeasuresValues(): Resource<List<Pair<BodyMeasure, Double>>, Throwable>
    fun observeSelectedBodyMeasuresValues(context: CoroutineContext): Flow<List<Pair<BodyMeasure, Double>>>
    fun replaceSelectedBodyMeasures(values: List<BodyMeasure>)
    fun saveSelectedBodyMeasuresValues(values: List<Pair<BodyMeasure, Double>>)
}