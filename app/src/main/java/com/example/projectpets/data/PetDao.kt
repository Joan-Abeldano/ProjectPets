package com.example.projectpets.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PetDao {
    @Insert
    suspend fun insertPet(pet: Pet)
    @Delete
    suspend fun deleteAllPets(allPets: List<Pet>)
    @Query("SELECT * FROM PetData order by id ASC")
    fun getAllPets(): Flow<List<Pet>>
    @Query("SELECT * FROM PetData WHERE id=:idPet")
    fun getSinglePet(idPet: Int): Flow<List<Pet>>
}