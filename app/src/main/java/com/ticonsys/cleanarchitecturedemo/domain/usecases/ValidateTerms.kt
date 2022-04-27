package com.ticonsys.cleanarchitecturedemo.domain.usecases


class ValidateTerms {
    operator fun invoke(
        acceptedTerms: Boolean
    ): ValidationResult {

        if (!acceptedTerms) {
            return ValidationResult(
                successful = false,
                errorMessage = "Please accept the terms"
            )
        }

        return ValidationResult(
            successful = true
        )

    }
}