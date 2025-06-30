package com.example.projectpets.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "VaccineData",
    foreignKeys = [
        ForeignKey(
            entity = Pet::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("id_pet"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Vaccine (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "given")
    val given: Boolean,
    @ColumnInfo(name = "id_pet")
    val idPet: Int
)