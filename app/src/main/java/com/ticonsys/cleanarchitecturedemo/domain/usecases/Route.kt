package com.ticonsys.cleanarchitecturedemo.domain.usecases

sealed class Route(val route: String) {
    object Registration : Route(Routes.REGISTRATION.name)
    object Home : Route(Routes.HOME.name)
}
