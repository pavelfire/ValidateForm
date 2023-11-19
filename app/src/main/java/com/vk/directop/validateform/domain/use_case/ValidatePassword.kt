package com.vk.directop.validateform.domain.use_case

class ValidatePassword {

    fun execute(password: String): ValidationResult {
        if (password.length < 8) {
            return ValidationResult(
                successful = false,
                errorMessage = "The password needs to consist of at least 8 characters"
            )
        }
        val containLettersAndDigits =
            password.any { it.isDigit() } && password.any { it.isLetter() }
        if (!containLettersAndDigits) {
            return ValidationResult(
                successful = false,
                errorMessage = "The password needs to contain at least one letter and digit"
            )
        }
        return ValidationResult(successful = true)
    }
}