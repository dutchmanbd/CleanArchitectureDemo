package com.ticonsys.cleanarchitecturedemo.data.repository

import com.ticonsys.cleanarchitecturedemo.data.mapper.toUser
import com.ticonsys.cleanarchitecturedemo.data.remote.api.FakeApiService
import com.ticonsys.cleanarchitecturedemo.domain.model.User
import com.ticonsys.cleanarchitecturedemo.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepositoryImpl(
    private val apiService: FakeApiService
) : UserRepository {
    override fun registerUser(email: String, password: String): Flow<User> = flow {
        emit(apiService.registerUser(email, password).toUser())
    }
}