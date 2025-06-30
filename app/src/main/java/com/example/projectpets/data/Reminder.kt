package com.example.projectpets.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "ReminderData",
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
data class Reminder (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "id_pet")
    val idPet: Int
)