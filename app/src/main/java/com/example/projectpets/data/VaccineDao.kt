package com.example.projectpets.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface VaccineDao {
    @Insert
    suspend fun insertVaccine(vaccine: Vaccine)
    @Delete
    suspend fun deleteAllVaccines(allVaccines: List<Vaccine>)
    @Query("SELECT id, name, date, description, given, id_pet FROM VaccineData WHERE id_pet=:id ORDER by id ASC")
    fun getAllVaccines(id: Int): Flow<List<Vaccine>>
}