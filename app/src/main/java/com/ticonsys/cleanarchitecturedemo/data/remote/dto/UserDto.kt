package com.ticonsys.cleanarchitecturedemo.data.remote.dto

import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("email")
    val email: String
)