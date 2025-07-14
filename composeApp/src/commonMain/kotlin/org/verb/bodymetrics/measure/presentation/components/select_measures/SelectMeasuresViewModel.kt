package org.verb.bodymetrics.measure.presentation.components.select_measures

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.verb.bodymetrics.core.domain.util.Resource
import org.verb.bodymetrics.measure.domain.usecases.ReplaceLastSelectedMeasuresValuesUseCase
import org.verb.bodymetrics.measure.domain.usecases.RetrieveLastSelectedMeasuresValuesUseCase
import org.verb.bodymetrics.measure.presentation.mapper.toDomain
import org.verb.bodymetrics.measure.presentation.mapper.toChipUi

class SelectMeasuresViewModel(
    private val retrieveLastSelectedMeasuresValuesUseCase: RetrieveLastSelectedMeasuresValuesUseCase,
    private val replaceLastSelectedMeasuresValuesUseCase: ReplaceLastSelectedMeasuresValuesUseCase
): ViewModel() {
    var state by mutableStateOf(SelectMeasuresState())
        private set

    private val eventChannel = Channel<SelectMeasuresEvent>()
    val events = eventChannel.receiveAsFlow()

    init {
        retrieveLastSelectedValues()
    }

    fun onAction(action: SelectMeasuresAction) {
        when (action) {
            is SelectMeasuresAction.OnClose -> Unit
            is SelectMeasuresAction.OnFinishSelection -> {
                replaceLastSelectedMeasuresValuesUseCase.execute(action.selectedMeasures.map { it.toDomain() })
                viewModelScope.launch {
                    eventChannel.send(SelectMeasuresEvent.SelectedMeasuresSaved)
                }
            }
        }
    }

    fun retrieveLastSelectedValues() {
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
                    lastSelectedMeasures = result.data.map { it.toChipUi() }
                )
            }
        }
    }
}