package org.verb.bodymetrics.core.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import org.verb.bodymetrics.core.presentation.model.ChipUi

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun <T: ChipUi> ElevatedChipGroupMultipleSelection(
    chips: List<T>,
    selectedChips: List<T>,
    modifier: Modifier = Modifier,
    onChipSelected: (T) -> Unit,
) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier,
    ) {
        chips.forEach { chip ->
            ElevatedFilterChip(
                item = chip,
                selected = selectedChips.contains(chip),
                onChipClick = { onChipSelected(chip) },
                modifier = Modifier,
            )
        }
    }
}

@Composable
fun <T: ChipUi> ElevatedFilterChip(
    item: T,
    selected: Boolean,
    onChipClick: (T) -> Unit,
    modifier: Modifier
) {
    androidx.compose.material3.ElevatedFilterChip(
        modifier = modifier,
        selected = selected,
        onClick = {
            onChipClick(item)
        },
        label = {
            Text(
                stringResource(item.title())
            )
        },
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        }
    )
}