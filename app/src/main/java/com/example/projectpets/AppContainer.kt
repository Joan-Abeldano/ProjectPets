package com.example.projectpets

import android.content.Context
import com.example.projectpets.data.PetsDatabase
import com.example.projectpets.repositories.PetRepository
import com.example.projectpets.repositories.ReminderRepository
import com.example.projectpets.repositories.UserRepository
import com.example.projectpets.repositories.VaccineRepository

class AppContainer(private val context: Context) {
    private val database: PetsDatabase by lazy {
        PetsDatabase.getPetsDatabase(context)
    }

    val petRepository: PetRepository by lazy {
        PetRepository(database.PetDao())
    }

    val userRepository: UserRepository by lazy {
        UserRepository(database.UserDao())
    }

    val reminderRepository: ReminderRepository by lazy {
        ReminderRepository(database.ReminderDao())
    }

    val vaccineRepository: VaccineRepository by lazy {
        VaccineRepository(database.VaccineDao())
    }
}