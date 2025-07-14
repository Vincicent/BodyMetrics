package org.verb.bodymetrics.home.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.verb.bodymetrics.measure.domain.usecases.ObserveSelectedMeasuresValuesUseCase
import org.verb.bodymetrics.measure.presentation.mapper.toDefaultIllustratedUi

class HomeScreenViewModel(
    private val observeSelectedMeasuresValuesUseCase: ObserveSelectedMeasuresValuesUseCase
): ViewModel() {
    var state by mutableStateOf(HomeScreenState())
        private set

    init {
        retrieveSelectedMeasuresValues()
    }

    fun onAction(action: HomeScreenAction) {
        when (action) {
            is HomeScreenAction.OnSelectedMeasuresSaved -> Unit
        }
    }

    private fun retrieveSelectedMeasuresValues() {
        state = state.copy(
            displayState = DisplayState.LOADING
        )

        viewModelScope.launch {
            observeSelectedMeasuresValuesUseCase.execute(viewModelScope.coroutineContext).collect {
                val selectedMeasuresValues = it.map { item ->
                    item.first.toDefaultIllustratedUi() to item.second
                }

                state = state.copy(
                    displayState = DisplayState.DISPLAY,
                    selectedMeasuresValues = selectedMeasuresValues
                )
            }
        }
    }
}