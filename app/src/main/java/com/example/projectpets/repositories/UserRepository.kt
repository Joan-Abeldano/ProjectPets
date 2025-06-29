package com.example.projectpets.repositories

import com.example.projectpets.data.User
import com.example.projectpets.data.UserDao
import kotlinx.coroutines.flow.Flow

class UserRepository (private val userDao: UserDao) {
    fun getuser(username: String,password: String): Flow<List<User>> = userDao.getUser(username,password)

    suspend fun insertUser(user: User) = userDao.insertUser(user)

    suspend fun deleteAllUsers(allUsers: List<User>) = userDao.deleteAllUsers(allUsers)
}