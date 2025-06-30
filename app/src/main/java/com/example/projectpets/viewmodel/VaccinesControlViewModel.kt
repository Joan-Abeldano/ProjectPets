package com.example.projectpets.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.projectpets.PetsApplication
import com.example.projectpets.data.Vaccine
import com.example.projectpets.repositories.VaccineRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class VaccinesControlViewModel (private val vaccineRepository: VaccineRepository) : ViewModel() {
    fun getVaccines(id: Int): Flow<List<Vaccine>> = vaccineRepository.getPetVaccines(id)

    private val _vaccines = MutableLiveData<List<Vaccine>>()
    val vaccines: LiveData<List<Vaccine>> = _vaccines

    fun loadVaccines(petId: Int) = viewModelScope.launch {
        vaccineRepository.getPetVaccines(petId).collect { vaccineList ->
            _vaccines.postValue(vaccineList)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as PetsApplication)
                VaccinesControlViewModel(application.container.vaccineRepository)
            }
        }
    }
}