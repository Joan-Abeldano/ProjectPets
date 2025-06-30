package com.example.projectpets.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.projectpets.PetsApplication
import com.example.projectpets.data.Pet
import com.example.projectpets.models.PetData
import com.example.projectpets.repositories.PetRepository
import kotlinx.coroutines.launch

class AddPetViewModel (private val petRepository: PetRepository) : ViewModel() {
    fun insertPet(pet: PetData) = viewModelScope.launch {
        petRepository.insertPet(Pet(id = 0, name = pet.name, description = pet.description, birthdate = pet.birthDate, type = pet.type))
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as PetsApplication)
                AddPetViewModel(application.container.petRepository)
            }
        }
    }
}