package com.example.projectpets.models

import com.example.projectpets.data.User

data class UserData (
    val username: String,
    val password: String
)

fun UserData.toItem() = User(
    id = 0,
    username = username,
    password = password
)