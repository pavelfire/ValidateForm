package com.vk.directop.validateform.presentation.fibonacci

data class FibonacciState(
    val givenNumber: String = "",
    val resultNumber: Long = 0,
    val loading: Boolean,
)
