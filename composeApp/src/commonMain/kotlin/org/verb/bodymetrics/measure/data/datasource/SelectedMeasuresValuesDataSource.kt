package org.verb.bodymetrics.measure.data.datasource

import kotlinx.coroutines.flow.Flow
import org.verb.bodymetrics.core.domain.util.Resource
import org.verb.bodymetrics.measure.domain.model.BodyMeasure
import kotlin.coroutines.CoroutineContext

interface SelectedMeasuresValuesDataSource {
    fun getSelectedMeasuresValues(): Resource<List<Pair<BodyMeasure, Double>>, Throwable>
    fun observeSelectedMeasuresValues(context: CoroutineContext): Flow<List<Pair<BodyMeasure, Double>>>
    fun saveSelectedMeasuresValues(values: List<Pair<BodyMeasure, Double>>)
}