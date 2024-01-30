package com.ntpro.mobileandroiddevtestwork.domain.util

import java.text.SimpleDateFormat
import java.util.Date

fun formatDate(date: Date): String {
    val pattern = "dd.MM.yyyy HH:mm"
    val simpleDateFormat = SimpleDateFormat(pattern)
    return simpleDateFormat.format(date)
}