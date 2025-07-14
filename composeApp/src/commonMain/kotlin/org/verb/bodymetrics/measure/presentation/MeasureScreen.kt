package org.verb.bodymetrics.measure.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.verb.bodymetrics.core.presentation.ui.ObserveAsEvents

@Composable
fun MeasureScreenRoot(
    viewModel: MeasureViewModel,
    onMeasuresSaved: () -> Unit,
    onBack: () -> Unit,
) {
    ObserveAsEvents(flow = viewModel.events) { events ->
        when (events) {
            is InsertMeasuresEvent.MeasuresSaved -> {
                onMeasuresSaved()
            }
        }
    }

    MeasureScreen(
        onAction = {
            when (it) {
                is InsertMeasuresAction.OnClose -> {
                    onBack()
                }

                else -> Unit
            }

            viewModel.onAction(it)
        },
        state = viewModel.state
    )
}

@Composable
private fun MeasureScreen(
    onAction: (InsertMeasuresAction) -> Unit,
    state: InsertMeasuresState
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp)
    ) {
        Text(
            "MeasureScreen"
        )

        Spacer(modifier = Modifier.padding(vertical = 8.dp))

        when(state.displayState) {
            DisplayState.DISPLAY -> {
                state.neededMeasures.forEach {
                    InsertMeasureItem(
                        state = it.value,
                        label = it.labelRes
                    )

                    Spacer(modifier = Modifier.padding(vertical = 8.dp))
                }

                Spacer(modifier = Modifier.weight(1f))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        onClick = { onAction.invoke(InsertMeasuresAction.OnClose) },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Close")
                    }

                    Spacer(modifier = Modifier.padding(horizontal = 8.dp))

                    Button(
                        onClick = { onAction.invoke(InsertMeasuresAction.OnCompletionFinished(state.neededMeasures)) },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Continue")
                    }
                }
            }
            DisplayState.ERROR -> {

            }
            DisplayState.LOADING -> {
                CircularProgressIndicator()
            }
            else -> Unit
        }


    }
}

@Composable
private fun InsertMeasureItem(
    state: TextFieldState,
    label: StringResource,
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            stringResource(label),
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.padding(horizontal = 8.dp))
        BasicTextField(
            state = state,
            modifier = Modifier.weight(2f).background(Color.Cyan),
        )
    }
}