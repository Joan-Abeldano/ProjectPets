package com.example.projectpets.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.projectpets.PetsApplication
import com.example.projectpets.data.Reminder
import com.example.projectpets.models.ReminderData
import com.example.projectpets.repositories.ReminderRepository
import kotlinx.coroutines.launch

class FormReminderViewModel (private val reminderRepository: ReminderRepository) : ViewModel() {
    fun insertReminder(reminder: ReminderData) = viewModelScope.launch {
        reminderRepository.insertReminder(Reminder(id = 0, name = reminder.name, date = reminder.date, description = reminder.description, idPet = 0))
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as PetsApplication)
                FormReminderViewModel(application.container.reminderRepository)
            }
        }
    }
}