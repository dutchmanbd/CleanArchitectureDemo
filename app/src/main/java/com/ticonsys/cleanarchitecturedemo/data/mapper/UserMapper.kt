package com.ticonsys.cleanarchitecturedemo.data.mapper

import com.ticonsys.cleanarchitecturedemo.data.remote.dto.UserDto
import com.ticonsys.cleanarchitecturedemo.domain.model.User

fun UserDto.toUser() = User(email = email)

fun User.toUserDto() = UserDto(email = email)