package com.example.projectpets.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.projectpets.PetsApplication
import com.example.projectpets.data.Pet
import com.example.projectpets.repositories.PetRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MyPetsViewModel (private val petRepository: PetRepository) : ViewModel() {
    private val _pets = MutableLiveData<List<Pet>>()
    val pets: LiveData<List<Pet>> = _pets

    init {
        loadPets()
    }

    private fun loadPets() = viewModelScope.launch {
        petRepository.getAll().collect { petList ->
            _pets.postValue(petList)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as PetsApplication)
                MyPetsViewModel(application.container.petRepository)
            }
        }
    }
}