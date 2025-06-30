package com.example.projectpets.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.projectpets.PetsApplication
import com.example.projectpets.data.Reminder
import com.example.projectpets.repositories.ReminderRepository
import kotlinx.coroutines.flow.Flow

class ReminderListViewModel (private val reminderRepository: ReminderRepository) : ViewModel() {
    fun getReminders(id: Int): Flow<List<Reminder>> = reminderRepository.getPetReminders(id)

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as PetsApplication)
                ReminderListViewModel(application.container.reminderRepository)
            }
        }
    }
}