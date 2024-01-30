package com.ntpro.mobileandroiddevtestwork.ui.screen.deals

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ntpro.mobileandroiddevtestwork.domain.model.Deal
import com.ntpro.mobileandroiddevtestwork.domain.util.formatDate
import com.ntpro.mobileandroiddevtestwork.ui.component.MyTopAppBar
import kotlin.math.roundToInt

@Composable
fun DealsScreen(
    //in real project inject with di
    viewModel: DealsScreenViewModel
) {
    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            MyTopAppBar(sortType = state.sortType, updateSorting = viewModel::updateSorting)
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(vertical = 8.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.deals) {
                DealRow(deal = it)
                Divider()
            }
        }
    }
}

@Composable
fun DealRow(
    deal: Deal
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = deal.instrumentName)
            Text(text = formatDate(deal.timeStamp))
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = deal.price.toString(),
                color = if (deal.side == Deal.Side.SELL) Color.Red else Color.Green
            )
            Text(text = deal.amount.roundToInt().toString())
        }
    }
}