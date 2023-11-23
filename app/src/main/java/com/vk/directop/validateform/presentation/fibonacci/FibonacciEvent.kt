package com.vk.directop.validateform.presentation.fibonacci

sealed class FibonacciEvent {
    data class NumberChanged(val number: String): FibonacciEvent()
    data class CalculatedNumber(val number:Long): FibonacciEvent()

    object Calculate: FibonacciEvent()
}