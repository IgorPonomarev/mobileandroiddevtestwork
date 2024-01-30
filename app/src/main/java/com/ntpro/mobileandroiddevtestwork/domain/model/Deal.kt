package com.ntpro.mobileandroiddevtestwork.domain.model

import java.util.Date

data class Deal(
    val id: Long,
    val timeStamp: Date,
    val instrumentName: String,
    val price: Double,
    val amount: Double,
    val side: Side,
) {
    enum class Side {
        SELL, BUY
    }
}