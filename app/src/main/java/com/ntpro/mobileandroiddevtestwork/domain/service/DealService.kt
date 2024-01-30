package com.ntpro.mobileandroiddevtestwork.domain.service

import com.ntpro.mobileandroiddevtestwork.domain.model.Deal
import kotlinx.coroutines.flow.Flow

interface DealService {
    fun getDeals(): Flow<List<Deal>>
}