package org.verb.bodymetrics.measure.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.verb.bodymetrics.core.domain.util.Resource
import org.verb.bodymetrics.measure.domain.usecases.RetrieveLastSelectedMeasuresValuesUseCase
import org.verb.bodymetrics.measure.domain.usecases.SaveSelectedMeasuresValuesUseCase
import org.verb.bodymetrics.measure.presentation.components.select_measures.SelectMeasuresEvent
import org.verb.bodymetrics.measure.presentation.mapper.toDomain
import org.verb.bodymetrics.measure.presentation.mapper.toInputUi
import org.verb.bodymetrics.measure.presentation.model.BodyMeasureInputUi

class MeasureViewModel(
    private val retrieveLastSelectedMeasuresValuesUseCase: RetrieveLastSelectedMeasuresValuesUseCase,
    private val saveSelectedMeasuresValuesUseCase: SaveSelectedMeasuresValuesUseCase
): ViewModel() {
    var state by mutableStateOf(InsertMeasuresState())
        private set

    private val eventChannel = Channel<InsertMeasuresEvent>()
    val events = eventChannel.receiveAsFlow()

    init {
        retrieveLastSelectedValues()
    }

    fun onAction(action: InsertMeasuresAction) {
        when(action) {
            is InsertMeasuresAction.OnClose -> Unit
            is InsertMeasuresAction.OnCompletionFinished -> {
                saveMeasuresValues(action.selectedMeasures)
            }
        }
    }

    private fun retrieveLastSelectedValues() {
        state = state.copy(
            displayState = DisplayState.LOADING
        )

        state = when(val result = retrieveLastSelectedMeasuresValuesUseCase.execute()) {
            is Resource.Error -> {
                state.copy(
                    displayState = DisplayState.ERROR,
                )
            }

            is Resource.Success -> {
                state.copy(
                    displayState = DisplayState.DISPLAY,
                     neededMeasures = result.data.map { it.toInputUi() }
                )
            }
        }
    }

    private fun saveMeasuresValues(list: List<BodyMeasureInputUi>) {
        val itemsToSave = list.map {
            it.toDomain() to it.value.text.toString().toDouble()
        }

        saveSelectedMeasuresValuesUseCase.execute(itemsToSave)

        viewModelScope.launch {
            eventChannel.send(InsertMeasuresEvent.MeasuresSaved)
        }
    }
}