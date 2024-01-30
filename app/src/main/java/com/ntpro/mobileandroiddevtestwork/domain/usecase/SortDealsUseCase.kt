package com.ntpro.mobileandroiddevtestwork.domain.usecase

import com.ntpro.mobileandroiddevtestwork.domain.model.Deal
import com.ntpro.mobileandroiddevtestwork.domain.model.SortType

class SortDealsUseCase {
    operator fun invoke(
        deals: List<Deal>,
        sortType: SortType
    ): List<Deal> {
        return when(sortType) {
            SortType.DATE_DESC -> deals.sortedByDescending { it.timeStamp }
            SortType.DATE_ASC -> deals.sortedBy { it.timeStamp }
            SortType.PRICE_DESC -> deals.sortedByDescending { it.price }
            SortType.PRICE_ASC -> deals.sortedBy { it.price }
            SortType.AMOUNT_DESC -> deals.sortedByDescending { it.amount }
            SortType.AMOUNT_ASC -> deals.sortedBy { it.amount }
            SortType.SIDE_DESC -> deals.sortedByDescending { it.side }
            SortType.SIDE_ASC -> deals.sortedBy { it.side }
        }
    }
}