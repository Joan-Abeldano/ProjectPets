package com.example.projectpets.repositories

import com.example.projectpets.data.Vaccine
import com.example.projectpets.data.VaccineDao
import kotlinx.coroutines.flow.Flow

class VaccineRepository (private val vaccineDao: VaccineDao) {
    fun getPetVaccines(id: Int): Flow<List<Vaccine>> = vaccineDao.getAllVaccines(id)

    suspend fun insertVaccine(vaccine: Vaccine) = vaccineDao.insertVaccine(vaccine)

    suspend fun deleteAllVaccines(allVaccines: List<Vaccine>) = vaccineDao.deleteAllVaccines(allVaccines)
}