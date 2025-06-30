package com.example.projectpets.repositories

import com.example.projectpets.data.Pet
import com.example.projectpets.data.PetDao
import kotlinx.coroutines.flow.Flow

class PetRepository(private val petDao: PetDao) {
    fun getAll(): Flow<List<Pet>> = petDao.getAllPets()

    suspend fun insertPet(pet: Pet) = petDao.insertPet(pet)

    suspend fun deleteAllPets(allPets: List<Pet>) = petDao.deleteAllPets(allPets)
}