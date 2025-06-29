package com.example.projectpets.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User)
    @Delete
    suspend fun deleteAllUsers(allUsers: List<User>)
    @Query("SELECT * FROM UserData WHERE username=:username AND password=:password")
    fun getUser(username: String, password: String): Flow<List<User>>
}