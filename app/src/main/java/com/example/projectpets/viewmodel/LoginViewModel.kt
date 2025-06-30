package com.example.projectpets.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.projectpets.PetsApplication
import com.example.projectpets.data.User
import com.example.projectpets.models.UserData
import com.example.projectpets.repositories.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class LoginViewModel (private val userRepository: UserRepository) : ViewModel() {
    fun getUser(username: String,password:String): Flow<List<User>> = userRepository.getuser(username, password)

    fun insertUser(user: UserData) = viewModelScope.launch {
        userRepository.insertUser(User(id=0, username = user.username, password = user.password))
    }

    fun deleteAllUsers(allUsers: List<User>) = viewModelScope.launch {
        userRepository.deleteAllUsers(allUsers)
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as PetsApplication)
                LoginViewModel(application.container.userRepository)
            }
        }
    }
}