package com.example.projectpets.models

import com.example.projectpets.data.Vaccine

data class VaccineData (
    val idPet: Int,
    val name: String,
    val date: String,
    val description: String,
    val given: Boolean
)

fun VaccineData.toItem() = Vaccine(
    id = 0,
    name = name,
    date = date,
    description = description,
    given = given,
    idPet = idPet
)