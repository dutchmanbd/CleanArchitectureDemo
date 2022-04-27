package com.ticonsys.cleanarchitecturedemo.presentation.features.registration

sealed class ValidationEvent {
    object Success : ValidationEvent()
}