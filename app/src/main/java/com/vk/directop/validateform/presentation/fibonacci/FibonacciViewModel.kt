package com.vk.directop.validateform.presentation.fibonacci

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

const val MAX_CALCULATED_NUMBER = 42

class FibonacciViewModel : ViewModel() {

    var state by mutableStateOf(FibonacciState(loading = false))
    private var job: Job? = null

    fun onEvent(event: FibonacciEvent) {
        when (event) {
            is FibonacciEvent.NumberChanged -> {
                state = state.copy(givenNumber = event.number)
            }

            is FibonacciEvent.CalculatedNumber -> {
                state = state.copy(resultNumber = event.number)
            }

            FibonacciEvent.Calculate -> {
                job?.cancel()
                job = viewModelScope.launch {
                    calculateFibonacci()
                }
            }
        }
    }

    private suspend fun calculateFibonacci() {
        try {
            val result = state.givenNumber.toInt()
            if (result < MAX_CALCULATED_NUMBER) {
                state = state.copy(loading = true)
                val calculated = withContext(Dispatchers.Default) { getFibonacci(result) }
                state = state.copy(resultNumber = calculated, loading = false)
            }
        } catch (e: Exception) {
            e.stackTrace
        }
    }

}