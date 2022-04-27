package com.ticonsys.cleanarchitecturedemo.data.remote.api

import com.ticonsys.cleanarchitecturedemo.data.remote.dto.UserDto

interface FakeApiService {
    suspend fun registerUser(
        email: String,
        password: String
    ) = UserDto(email = email)
}