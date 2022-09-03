package com.example.koreanlearning.data

import android.content.Context
import com.example.koreanlearning.R
import com.example.koreanlearning.model.Jsonkorean
import com.example.koreanlearning.model.Section
import org.json.JSONObject

class Datasource (
    private val context: Context,
    private val json: List<Jsonkorean>
    ){

    fun loadAffirmations() : List<Section> {
        return listOf<Section>(
            Section(json[0].body, R.drawable.aboutkorea),
            Section(json[1].body, R.drawable.learningkorean),
            Section(json[2].body, R.drawable.quizzes),
            Section(json[3].body, R.drawable.games)

        )
    }
}