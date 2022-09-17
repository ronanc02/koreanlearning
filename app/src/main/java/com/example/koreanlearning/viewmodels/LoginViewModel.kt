package com.example.koreanlearning.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.koreanlearning.database.login.Login
import com.example.koreanlearning.database.login.LoginDao

class LoginViewModel(private val loginDao: LoginDao) : ViewModel() {
    fun fullLogin(): List<Login> = loginDao.getAll()
    fun loginForName(name: String): List<Login> = loginDao.getByName(name)

}

class LoginViewModelFactory(
    private val loginDao: LoginDao
    ) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LoginViewModel(loginDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
