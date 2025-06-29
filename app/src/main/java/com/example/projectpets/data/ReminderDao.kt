package com.example.projectpets.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ReminderDao {
    @Insert
    suspend fun insertReminder(reminder: Reminder)
    @Delete
    suspend fun deleteAllReminders(allReminders: List<Reminder>)
    @Query("SELECT name,date,description FROM ReminderData WHERE id_pet=:id ORDER by id ASC")
    fun getAllReminders(id: Int): Flow<List<Reminder>>
}