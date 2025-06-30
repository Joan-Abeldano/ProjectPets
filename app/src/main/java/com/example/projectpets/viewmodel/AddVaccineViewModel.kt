package com.example.projectpets.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.projectpets.PetsApplication
import com.example.projectpets.data.Vaccine
import com.example.projectpets.models.VaccineData
import com.example.projectpets.repositories.VaccineRepository
import kotlinx.coroutines.launch

class AddVaccineViewModel (private val vaccineRepository: VaccineRepository) : ViewModel() {
    fun insertVaccine(vaccine: VaccineData) = viewModelScope.launch {
        vaccineRepository.insertVaccine(Vaccine(id = 0, name = vaccine.name, date = vaccine.date, description = vaccine.description, given = vaccine.given, idPet = vaccine.idPet))
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as PetsApplication)
                AddVaccineViewModel(application.container.vaccineRepository)
            }
        }
    }
}