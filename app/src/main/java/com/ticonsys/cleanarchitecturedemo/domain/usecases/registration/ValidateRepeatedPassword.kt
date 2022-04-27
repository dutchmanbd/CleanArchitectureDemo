package com.ticonsys.cleanarchitecturedemo.domain.usecases.registration

import com.ticonsys.cleanarchitecturedemo.domain.usecases.ValidationResult


class ValidateRepeatedPassword {
    operator fun invoke(
        password: String,
        repeatedPassword: String
    ): ValidationResult {

        if (password != repeatedPassword) {
            return ValidationResult(
                successful = false,
                errorMessage = "The password don't match"
            )
        }

        return ValidationResult(
            successful = true
        )

    }
}