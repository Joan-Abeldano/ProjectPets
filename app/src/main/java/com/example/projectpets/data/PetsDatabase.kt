package com.example.projectpets.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Pet::class,User::class,Reminder::class,Vaccine::class], version = 1)
abstract class PetsDatabase: RoomDatabase() {
    abstract fun PetDao(): PetDao
    abstract fun UserDao(): UserDao
    abstract fun ReminderDao(): ReminderDao
    abstract fun VaccineDao(): VaccineDao

    companion object {
        @Volatile
        private var Instance: PetsDatabase? = null

        fun getPetsDatabase(context: Context): PetsDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context,
                    klass = PetsDatabase::class.java,
                    name = "sample"
                )
                    .build()
                    .also { Instance = it }
            }
        }
    }
}