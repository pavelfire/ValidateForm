package com.vk.directop.validateform.presentation.fibonacci


fun getFibonacci(n: Int): Long {
    if (n == 0) {
        return 0L
    }
    return if (n == 1) {
        1L
    } else {
        getFibonacci(n - 1) + getFibonacci(n - 2)
    }
}
