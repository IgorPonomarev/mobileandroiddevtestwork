package com.ntpro.mobileandroiddevtestwork.ui.screen.deals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ntpro.mobileandroiddevtestwork.data.remote.DealServiceImpl
import com.ntpro.mobileandroiddevtestwork.domain.model.SortType
import com.ntpro.mobileandroiddevtestwork.domain.service.DealService
import com.ntpro.mobileandroiddevtestwork.domain.usecase.FormatDealsUseCase
import com.ntpro.mobileandroiddevtestwork.domain.usecase.SortDealsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DealsScreenViewModel(
    // in real project inject it with di
    private val service: DealService = DealServiceImpl(),
    private val sortDealsUseCase: SortDealsUseCase = SortDealsUseCase(),
    private val formatDealsUseCase: FormatDealsUseCase = FormatDealsUseCase()
) : ViewModel() {

    private val _state = MutableStateFlow(DealsScreenState())
    val state = _state.asStateFlow()

    init {
        observeDeals()
    }

    private fun observeDeals() {
        viewModelScope.launch {
            service.getDeals().collect { newDeals ->
                val formattedDeals = formatDealsUseCase(newDeals)
                val sortedDeals = withContext(Dispatchers.Default) {
                    sortDealsUseCase(
                        formattedDeals,
                        state.value.sortType,
                    )
                }
                _state.update { it.copy(deals = sortedDeals) }
            }
        }
    }

    fun updateSorting(sortType: SortType) {
        _state.update {
            it.copy(sortType = sortType)
        }
    }
}