package com.vk.directop.validateform.domain.use_case

class ValidateTerms {

    fun execute(acceptTerms: Boolean): ValidationResult {
        if (!acceptTerms) {
            return ValidationResult(
                successful = false,
                errorMessage = "Please accept the terms"
            )
        }
        return ValidationResult(successful = true)
    }
}