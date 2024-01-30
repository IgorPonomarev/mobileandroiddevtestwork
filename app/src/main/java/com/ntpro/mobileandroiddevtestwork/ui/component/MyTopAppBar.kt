package com.ntpro.mobileandroiddevtestwork.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ntpro.mobileandroiddevtestwork.R
import com.ntpro.mobileandroiddevtestwork.domain.model.SortType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    sortType: SortType,
    updateSorting: (SortType) -> Unit
) {

    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = "Deals") },
        actions = {
            Box(
                modifier = Modifier
                    .wrapContentSize(Alignment.TopStart)
            ) {
                IconButton(onClick = { expanded = true }) {
                    Icon(Icons.Default.MoreVert, contentDescription = "Localized description")
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    SortType.entries.forEach {
                        DropdownMenuItem(
                            text = { Text(getTextForSorting(it)) },
                            onClick = {
                                if (it != sortType) updateSorting(it)
                                expanded = false
                            },
                            trailingIcon = {
                                if (it == sortType) {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = null
                                    )
                                }
                            }
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun getTextForSorting(sorting: SortType): String {
    return when (sorting) {
        SortType.DATE_DESC -> stringResource(id = R.string.sort_order_date_descending)
        SortType.DATE_ASC -> stringResource(id = R.string.sort_order_date_ascending)
        SortType.PRICE_DESC -> stringResource(id = R.string.sort_order_price_descending)
        SortType.PRICE_ASC -> stringResource(id = R.string.sort_order_price_ascending)
        SortType.AMOUNT_DESC -> stringResource(id = R.string.sort_order_amount_descending)
        SortType.AMOUNT_ASC -> stringResource(id = R.string.sort_order_amount_ascending)
        SortType.SIDE_DESC -> stringResource(id = R.string.sort_order_side_descending)
        SortType.SIDE_ASC -> stringResource(id = R.string.sort_order_side_ascending)
    }
}
