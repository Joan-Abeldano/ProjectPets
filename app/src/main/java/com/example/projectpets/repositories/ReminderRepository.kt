package com.example.projectpets.repositories

import com.example.projectpets.data.Reminder
import com.example.projectpets.data.ReminderDao
import kotlinx.coroutines.flow.Flow

class ReminderRepository (private val reminderDao: ReminderDao) {
    fun getPetReminders(id: Int): Flow<List<Reminder>> = reminderDao.getAllReminders(id)

    suspend fun insertReminder(reminder: Reminder) = reminderDao.insertReminder(reminder)

    suspend fun deleteAllReminders(allReminders: List<Reminder>) = reminderDao.deleteAllReminders(allReminders)
}