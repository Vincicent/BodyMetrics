package org.verb.bodymetrics.measure.data.repository

import kotlinx.coroutines.flow.Flow
import org.verb.bodymetrics.core.domain.util.Resource
import org.verb.bodymetrics.measure.data.datasource.LastSelectedMeasuresDataSource
import org.verb.bodymetrics.measure.data.datasource.SelectedMeasuresValuesDataSource
import org.verb.bodymetrics.measure.domain.model.BodyMeasure
import org.verb.bodymetrics.measure.domain.repository.MeasureRepository
import kotlin.coroutines.CoroutineContext

class MeasureRepositoryImpl(
    private val lastSelectedMeasuresDataSource: LastSelectedMeasuresDataSource,
    private val selectedMeasuresValuesDataSource: SelectedMeasuresValuesDataSource
): MeasureRepository {
    override fun retrieveSelectedBodyMeasures(): Resource<List<BodyMeasure>, Throwable> {
        return lastSelectedMeasuresDataSource.getLastSelectedMeasures()
    }

    override fun replaceSelectedBodyMeasures(values: List<BodyMeasure>) {
        lastSelectedMeasuresDataSource.replaceLastSelectedMeasures(values)
    }

    override fun saveSelectedBodyMeasuresValues(values: List<Pair<BodyMeasure, Double>>) {
        selectedMeasuresValuesDataSource.saveSelectedMeasuresValues(values)
    }

    override fun retrieveSelectedBodyMeasuresValues(): Resource<List<Pair<BodyMeasure, Double>>, Throwable> {
        return selectedMeasuresValuesDataSource.getSelectedMeasuresValues()
    }

    override fun observeSelectedBodyMeasuresValues(context: CoroutineContext): Flow<List<Pair<BodyMeasure, Double>>> {
        return selectedMeasuresValuesDataSource.observeSelectedMeasuresValues(context)
    }
}