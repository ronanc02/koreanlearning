package com.example.koreanlearning

import android.app.Application
import com.example.koreanlearning.database.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class LoginApplication : Application() {
    val database: AppDatabase by lazy {
        AppDatabase.getDatabase(this)
    }
}