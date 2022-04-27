package com.ticonsys.cleanarchitecturedemo.domain.usecases.registration

import com.ticonsys.cleanarchitecturedemo.domain.usecases.ValidationResult


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