package com.example.projectpets.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.projectpets.PetsApplication
import com.example.projectpets.data.Pet
import com.example.projectpets.repositories.PetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MyPetsViewModel (private val petRepository: PetRepository) : ViewModel() {
    fun getAllPets(): Flow<List<Pet>> = petRepository.getAll()

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as PetsApplication)
                MyPetsViewModel(application.container.petRepository)
            }
        }
    }
}