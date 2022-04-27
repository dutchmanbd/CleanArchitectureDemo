package com.ticonsys.cleanarchitecturedemo.domain.repository

import com.ticonsys.cleanarchitecturedemo.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun registerUser(
        email: String,
        password: String
    ): Flow<User>
}