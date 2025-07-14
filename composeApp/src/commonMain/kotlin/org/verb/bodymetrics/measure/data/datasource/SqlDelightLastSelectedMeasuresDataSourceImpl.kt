package org.verb.bodymetrics.measure.data.datasource

import com.verb.bodymetrics.database.BodyMetricsDatabase
import org.verb.bodymetrics.core.domain.util.Resource
import org.verb.bodymetrics.measure.domain.model.BodyMeasure
import kotlinx.datetime.Clock

class SqlDelightLastSelectedMeasuresDataSourceImpl(
    db: BodyMetricsDatabase
): LastSelectedMeasuresDataSource {

    private val queries = db.last_selected_measureQueries

    override fun getLastSelectedMeasures(): Resource<List<BodyMeasure>, Throwable> {
        return Resource.Success(queries
            .getLastSelectedMeasure()
            .executeAsList()
            .map {
                BodyMeasure.valueOf(it.body_measure)
            }
        )
    }

    override fun replaceLastSelectedMeasures(values: List<BodyMeasure>) {
        val valuesToInsert = values.map {
            it.toString()
        }

        queries.deleteAllLastSelectedMeasure()

        valuesToInsert.forEach {
            queries.insertLastSelectedMeasureEntity(
                body_measure = it,
                timestamp = Clock.System.now().toEpochMilliseconds()
            )
        }
    }
}