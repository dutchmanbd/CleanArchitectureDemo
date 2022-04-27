package com.ticonsys.cleanarchitecturedemo.util

sealed class Route(val route: String) {
    object Registration : Route(Routes.REGISTRATION.name)
    object Home : Route(Routes.HOME.name)
}
