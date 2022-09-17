package com.example.koreanlearning.database.login

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Login(
    @PrimaryKey val id: Int,
    @NonNull @ColumnInfo(name = "name") val username: String,
    @NonNull @ColumnInfo(name = "password") val userpw: String
)