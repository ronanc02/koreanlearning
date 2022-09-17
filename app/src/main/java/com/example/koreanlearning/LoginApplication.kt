package com.example.koreanlearning

import android.app.Application
import com.example.koreanlearning.database.AppDatabase

class LoginApplication : Application() {
    val database: AppDatabase by lazy {
        AppDatabase.getDatabase(this)
    }
}