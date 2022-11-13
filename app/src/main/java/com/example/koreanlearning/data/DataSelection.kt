package com.example.koreanlearning.data

import android.content.Context
import com.example.koreanlearning.LoginApplication
import com.example.koreanlearning.R
import com.example.koreanlearning.model.Section

class DataSelection (
    private val context: Context?
        ){

 //   private val act = LoginApplication

    fun loadCategories() : List<Section> {
        return listOf(
            Section("About Korea", R.drawable.aboutkorea),
            Section("Learning Korean", R.drawable.learningkorean),
            Section("Quizzes", R.drawable.quizzes),
            Section("Games", R.drawable.games)
        )
    }

    fun loadLevelsLearning() : List<Section> {
        return listOf(
            Section("Alphabet", R.drawable.quizzes),
            Section("Beginner", R.drawable.quizzes),
            Section("Intermediate", R.drawable.quizzes),
            Section("Advanced", R.drawable.quizzes),
            Section("Bonus", R.drawable.quizzes)
        )
    }

    fun loadLevelsBonus() : List<Section> {
        return listOf(
            Section("Beginner", R.drawable.quizzes),
            Section("Intermediate", R.drawable.quizzes),
            Section("Advanced", R.drawable.quizzes),
            Section("Bonus", R.drawable.quizzes)
        )
    }


}