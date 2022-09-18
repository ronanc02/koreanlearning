package com.example.koreanlearning.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.koreanlearning.database.login.Login
import com.example.koreanlearning.database.login.LoginDao

@Database(entities = arrayOf(Login::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun loginDao(): LoginDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database")
                    .allowMainThreadQueries()
                    .createFromAsset("database/login.db")
                    .build()
                INSTANCE = instance

                instance
            }
        }

    }

}