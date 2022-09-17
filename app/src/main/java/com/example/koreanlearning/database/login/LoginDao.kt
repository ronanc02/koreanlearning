package com.example.koreanlearning.database.login

import androidx.room.Dao
import androidx.room.Query

@Dao
interface LoginDao {
    @Query("SELECT * FROM login ORDER by password")
    fun getAll() : List<Login>

    @Query("SELECT * FROM login WHERE name = :username ORDER BY id ASC")
    fun getByName(username: String): List<Login>

}