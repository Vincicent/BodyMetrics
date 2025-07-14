package org.verb.bodymetrics.measure.presentation.components.select_measures

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import org.verb.bodymetrics.core.presentation.components.ElevatedChipGroupMultipleSelection
import org.verb.bodymetrics.measure.domain.model.BodyMeasure
import org.verb.bodymetrics.measure.presentation.mapper.toChipUi
import org.verb.bodymetrics.core.presentation.ui.ObserveAsEvents

@Composable
fun SelectMeasuresBottomSheetRoot(
    selectMeasuresViewModel: SelectMeasuresViewModel,
    showBottomSheet: Boolean,
    onSelectedMeasuresSaved: () -> Unit,
    onDismiss: () -> Unit
) {
    selectMeasuresViewModel.retrieveLastSelectedValues()

    ObserveAsEvents(flow = selectMeasuresViewModel.events) { events ->
        when (events) {
            is SelectMeasuresEvent.SelectedMeasuresSaved -> {
                onSelectedMeasuresSaved()
            }
        }
    }

    SelectMeasuresBottomSheet(
        state = selectMeasuresViewModel.state,
        onAction = {
            when (it) {
                is SelectMeasuresAction.OnClose -> {
                    onDismiss()
                }
                is SelectMeasuresAction.OnFinishSelection -> {
                    selectMeasuresViewModel.onAction(it)
                }
            }
        },
        showBottomSheet = showBottomSheet,
        onDismiss = onDismiss
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectMeasuresBottomSheet(
    state: SelectMeasuresState,
    onAction: (SelectMeasuresAction) -> Unit,
    showBottomSheet: Boolean,
    onDismiss: () -> Unit,
) {
    if (showBottomSheet && state.displayState == DisplayState.DISPLAY) {
        ModalBottomSheet(
            onDismissRequest = onDismiss,
            sheetState = rememberModalBottomSheetState(true),
        ) {
            val items = remember { BodyMeasure.nonCalculatedBodyMeasure().map { it.toChipUi() } }

            // Get unique categories for the filters
            val uniqueCategories = remember(items) { items.map { it.type }.distinct() }

            // State for selected filters
            val selectedFilters = remember { state.lastSelectedMeasures.toMutableStateList() }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
            ) {
                Text(
                    "MeasureScreen"
                )

                Spacer(modifier = Modifier.padding(vertical = 8.dp))

                uniqueCategories.forEach { type ->
                    Text(text = stringResource(type.labelRes))

                    Spacer(modifier = Modifier.padding(vertical = 4.dp))

                    ElevatedChipGroupMultipleSelection(
                        chips = items.filter { it.type == type },
                        selectedChips = selectedFilters.toList(),
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        if (selectedFilters.contains(it)) {
                            selectedFilters.remove(it)
                        } else {
                            selectedFilters.add(it)
                        }
                    }
                }

                Spacer(modifier = Modifier.padding(vertical = 8.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        onClick = { onAction.invoke(SelectMeasuresAction.OnClose) },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Close")
                    }

                    Spacer(modifier = Modifier.padding(horizontal = 8.dp))

                    Button(
                        onClick = { onAction.invoke(SelectMeasuresAction.OnFinishSelection(selectedFilters)) },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Continue")
                    }
                }
            }
        }
    }
}