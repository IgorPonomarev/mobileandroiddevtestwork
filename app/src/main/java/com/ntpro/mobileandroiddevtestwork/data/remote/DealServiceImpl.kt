package com.ntpro.mobileandroiddevtestwork.data.remote

import com.ntpro.mobileandroiddevtestwork.domain.model.Deal
import com.ntpro.mobileandroiddevtestwork.domain.service.DealService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DealServiceImpl(
    private val server: Server = Server()
): DealService {
    private val _deals = MutableStateFlow<List<Deal>>(emptyList())

    init {
        observeDealsFromServer()
    }

    private fun observeDealsFromServer() {
        server.subscribeToDeals { newDeals ->
            _deals.update { newDeals.map { it.toDomain() } }
        }
    }

    override fun getDeals(): Flow<List<Deal>> {
        // Expose a read-only StateFlow to the clients
        return _deals.asStateFlow()
    }
}