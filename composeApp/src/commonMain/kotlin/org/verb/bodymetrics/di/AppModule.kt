package org.verb.bodymetrics.di

import com.verb.bodymetrics.database.BodyMetricsDatabase
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.verb.bodymetrics.getPlatform
import org.verb.bodymetrics.home.presentation.HomeScreenViewModel
import org.verb.bodymetrics.measure.data.datasource.LastSelectedMeasuresDataSource
import org.verb.bodymetrics.measure.data.datasource.SelectedMeasuresValuesDataSource
import org.verb.bodymetrics.measure.data.datasource.SqlDelightLastSelectedMeasuresDataSourceImpl
import org.verb.bodymetrics.measure.data.datasource.SqlDelightSelectedMeasuresValuesDataSourceImpl
import org.verb.bodymetrics.measure.data.repository.MeasureRepositoryImpl
import org.verb.bodymetrics.measure.domain.repository.MeasureRepository
import org.verb.bodymetrics.measure.domain.usecases.ReplaceLastSelectedMeasuresValuesUseCase
import org.verb.bodymetrics.measure.domain.usecases.RetrieveLastSelectedMeasuresValuesUseCase
import org.verb.bodymetrics.measure.domain.usecases.ObserveSelectedMeasuresValuesUseCase
import org.verb.bodymetrics.measure.domain.usecases.RetrieveSelectedMeasuresValuesUseCase
import org.verb.bodymetrics.measure.domain.usecases.SaveSelectedMeasuresValuesUseCase
import org.verb.bodymetrics.measure.presentation.MeasureViewModel
import org.verb.bodymetrics.measure.presentation.components.select_measures.SelectMeasuresViewModel

val appModule = module {
    single<MeasureRepository> { MeasureRepositoryImpl(get(), get()) }
    single<LastSelectedMeasuresDataSource> { SqlDelightLastSelectedMeasuresDataSourceImpl(get()) }
    single<SelectedMeasuresValuesDataSource> { SqlDelightSelectedMeasuresValuesDataSourceImpl(get()) }
    single<BodyMetricsDatabase> { BodyMetricsDatabase(get()) }
    singleOf(::RetrieveLastSelectedMeasuresValuesUseCase)
    singleOf(::ReplaceLastSelectedMeasuresValuesUseCase)
    singleOf(::SaveSelectedMeasuresValuesUseCase)
    singleOf(::ObserveSelectedMeasuresValuesUseCase)
    singleOf(::RetrieveSelectedMeasuresValuesUseCase)
    single {
        SqlDelightLastSelectedMeasuresDataSourceImpl(
            db = get()
        )
    }
    single {
        SqlDelightSelectedMeasuresValuesDataSourceImpl(
            db = get()
        )
    }
    viewModelOf(::HomeScreenViewModel)
    viewModelOf(::MeasureViewModel)
    viewModelOf(::SelectMeasuresViewModel)
    factory { getPlatform() }
}