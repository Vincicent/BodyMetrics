package org.verb.bodymetrics.measure.data.datasource

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.verb.bodymetrics.database.BodyMetricsDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.verb.bodymetrics.measure.domain.model.BodyMeasure
import kotlinx.datetime.Clock
import org.verb.bodymetrics.core.domain.util.Resource
import kotlin.coroutines.CoroutineContext

class SqlDelightSelectedMeasuresValuesDataSourceImpl(
    db: BodyMetricsDatabase
): SelectedMeasuresValuesDataSource {

    private val queries = db.measureQueries
    override fun getSelectedMeasuresValues(): Resource<List<Pair<BodyMeasure, Double>>, Throwable> {
        return Resource.Success(queries
            .getMeasure()
            .executeAsList()
            .map {
                BodyMeasure.valueOf(it.body_measure) to it.value_
            }
        )
    }

    override fun observeSelectedMeasuresValues(context: CoroutineContext): Flow<List<Pair<BodyMeasure, Double>>> {
        return queries
            .getLastUniqueMeasures()
            .asFlow()
            .mapToList(context)
            .map {
                it.map { measureEntity ->
                    BodyMeasure.valueOf(measureEntity.body_measure) to measureEntity.value_
                }
            }
    }

    override fun saveSelectedMeasuresValues(values: List<Pair<BodyMeasure, Double>>) {
        values.forEach {
            queries.insertMeasureEntity(
                body_measure = it.first.toString(),
                value_ = it.second,
                timestamp = Clock.System.now().toEpochMilliseconds()
            )
        }
    }
}