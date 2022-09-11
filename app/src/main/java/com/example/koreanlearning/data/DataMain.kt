package com.example.koreanlearning.data

import android.content.Context
import com.example.koreanlearning.R
import com.example.koreanlearning.model.Section

class DataMain (
    private val context: Context?
        ){

    fun loadAffirmations() : List<Section> {
        return listOf(
            Section("About Korea", R.drawable.aboutkorea),
            Section("Learning Korean", R.drawable.learningkorean),
            Section("Quizzes", R.drawable.quizzes),
            Section("Games", R.drawable.games)

        )
    }
}