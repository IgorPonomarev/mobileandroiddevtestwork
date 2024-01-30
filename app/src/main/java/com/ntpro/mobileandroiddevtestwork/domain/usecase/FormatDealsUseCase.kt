package com.ntpro.mobileandroiddevtestwork.domain.usecase

import com.ntpro.mobileandroiddevtestwork.domain.model.Deal
import com.ntpro.mobileandroiddevtestwork.domain.util.round

// in real project formatting parameters can be taken from preferences datastore or shared prefs
class FormatDealsUseCase {
    operator fun invoke(
        deals: List<Deal>,
    ): List<Deal> {
        return deals.map { deal ->
            deal.copy(
                price = deal.price.round(2),
                //amount = deal.amount.round(0),
            )
        }
    }
}