package com.example.projectpets.models

import com.example.projectpets.data.Pet

data class PetData (
    val name: String,
    val description: String,
    val birthDate: String,
    val type: String
)

fun PetData.toItem() = Pet(
    id = 0,
    name = name,
    description = description,
    birthdate = birthDate,
    type = type
)