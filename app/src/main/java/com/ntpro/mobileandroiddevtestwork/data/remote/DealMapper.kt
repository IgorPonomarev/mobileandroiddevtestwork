package com.ntpro.mobileandroiddevtestwork.data.remote

import com.ntpro.mobileandroiddevtestwork.domain.model.Deal

fun Server.Deal.toDomain(): Deal {
    return Deal(
        id = id,
        timeStamp = timeStamp,
        instrumentName = instrumentName,
        price = price,
        amount = amount,
        side = Deal.Side.valueOf(side.name)
    )
}