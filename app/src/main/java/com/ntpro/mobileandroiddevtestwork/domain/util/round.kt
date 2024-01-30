package com.ntpro.mobileandroiddevtestwork.domain.util

import kotlin.math.pow
import kotlin.math.roundToInt

fun Double.round(n: Int): Double {
    val factor = 10.0.pow(n)
    return (this * factor).roundToInt() / factor
}