package com.ticonsys.cleanarchitecturedemo.domain.usecases.registration

import android.util.Patterns
import com.ticonsys.cleanarchitecturedemo.domain.usecases.ValidationResult

class ValidateEmail {
    operator fun invoke(
        email: String
    ): ValidationResult {

        if (email.isEmpty()) {
            return ValidationResult(
                successful = false,
                errorMessage = "The email can't be blank"
            )
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                successful = false,
                errorMessage = "That's not a valid email"
            )
        }

        return ValidationResult(
            successful = true
        )

    }
}