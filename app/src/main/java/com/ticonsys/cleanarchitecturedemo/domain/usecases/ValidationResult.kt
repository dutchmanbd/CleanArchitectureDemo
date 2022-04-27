package com.ticonsys.cleanarchitecturedemo.domain.usecases

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null
)