package com.ntpro.mobileandroiddevtestwork.ui.screen.deals

import androidx.compose.runtime.Stable
import com.ntpro.mobileandroiddevtestwork.domain.model.Deal
import com.ntpro.mobileandroiddevtestwork.domain.model.SortType

@Stable
data class DealsScreenState (
    val deals: List<Deal> = emptyList(),
    val sortType: SortType = SortType.DATE_DESC
)