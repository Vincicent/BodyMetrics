package org.verb.bodymetrics.measure.data.datasource

import org.verb.bodymetrics.core.domain.util.Resource
import org.verb.bodymetrics.measure.domain.model.BodyMeasure

interface LastSelectedMeasuresDataSource {
    fun getLastSelectedMeasures(): Resource<List<BodyMeasure>, Throwable>
    fun replaceLastSelectedMeasures(values: List<BodyMeasure>)
}