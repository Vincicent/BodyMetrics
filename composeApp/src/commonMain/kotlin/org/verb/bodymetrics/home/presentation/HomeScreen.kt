package org.verb.bodymetrics.home.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import bodymetrics.composeapp.generated.resources.Res
import bodymetrics.composeapp.generated.resources.body
import bodymetrics.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.verb.bodymetrics.Greeting
import org.verb.bodymetrics.measure.presentation.components.select_measures.SelectMeasuresBottomSheetRoot
import org.verb.bodymetrics.measure.presentation.components.select_measures.SelectMeasuresViewModel
import org.verb.bodymetrics.measure.presentation.model.DefaultBodyMeasureIllustratedUi
import org.verb.bodymetrics.measure.presentation.model.DefaultBodyMeasureUi

@Composable
fun HomeScreenRoot(
    viewModel: HomeScreenViewModel,
    selectMeasuresViewModel: SelectMeasuresViewModel,
    onSelectedMeasuresSaved: () -> Unit,
) {
    HomeScreen(
        selectMeasuresViewModel,
        state = viewModel.state,
        onAction = {
            when (it) {
                is HomeScreenAction.OnSelectedMeasuresSaved -> {
                    onSelectedMeasuresSaved()
                }
            }

            viewModel.onAction(it)
        }
    )
}

@Composable
private fun HomeScreen(
    selectMeasuresViewModel: SelectMeasuresViewModel,
    state: HomeScreenState,
    onAction: (HomeScreenAction) -> Unit,
) {
    var showBottomSheet by remember { mutableStateOf(false) }

    SelectMeasuresBottomSheetRoot(
        selectMeasuresViewModel = selectMeasuresViewModel,
        showBottomSheet = showBottomSheet,
        onSelectedMeasuresSaved = {
            showBottomSheet = false
            onAction.invoke(HomeScreenAction.OnSelectedMeasuresSaved)
        },
        onDismiss = { showBottomSheet = false },
    )

    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.size(8.dp))

        Button(onClick = { showBottomSheet = true }) {
            Text("Measure Bottom")
        }

        MeasuresGridView(state.selectedMeasuresValues)

        Image(painterResource(Res.drawable.body), null)
    }
}

@Composable
fun MeasuresGridView(selectedMeasuresValues: List<Pair<DefaultBodyMeasureIllustratedUi, Double>>) {

    val items = selectedMeasuresValues.map {
        GridItem(
            title = stringResource(it.first.labelRes),
            value = it.second,
            imageRes = it.first.iconRes
        )
    }

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp), // Adjust minSize as needed
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { item ->
            ImageGridCell(item)
        }
    }
}

data class GridItem(val title: String, val value: Double, val imageRes: DrawableResource?)

@Composable
fun ImageGridCell(item: GridItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .background(Color.LightGray)
                .padding(8.dp)
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (item.imageRes != null) {
                Image(
                    painter = painterResource(item.imageRes),
                    contentDescription = item.title,
                    modifier = Modifier
                        .height(60.dp)
                        .weight(2f),
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = item.title,
                textAlign = TextAlign.Center,
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = item.value.toString(),
                textAlign = TextAlign.Center,
            )
        }
    }
}