package com.example.projectpets.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.projectpets.PetsApplication
import com.example.projectpets.data.Vaccine
import com.example.projectpets.repositories.VaccineRepository
import kotlinx.coroutines.flow.Flow

class VaccinesControlViewModel (private val vaccineRepository: VaccineRepository) : ViewModel() {
    fun getVaccines(id: Int): Flow<List<Vaccine>> = vaccineRepository.getPetVaccines(id)

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as PetsApplication)
                VaccinesControlViewModel(application.container.vaccineRepository)
            }
        }
    }
}