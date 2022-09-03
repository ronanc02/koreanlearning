package com.example.koreanlearning.data

import android.content.Context
import com.example.koreanlearning.model.Jsonkorean
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.IOException
import java.nio.charset.Charset

class Json (
    private val context: Context
){

    fun loadkoreancategories(): List<String> {
        return listOf<String>(
            "beginner",
            "intermediate",
            "advanced",
            "bonus"
        )
    }

    fun loadJson(): String {
        val json: String?
        try {
            val input = this.context.assets.open("a1_routine.json")
            val size = input.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            input.read(buffer)
            input.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }
        return json
    }

    fun parseJson() : List<Jsonkorean>? {
        val moshi: Moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
        val listwords = Types.newParameterizedType(List::class.java, Jsonkorean::class.java)
        val adapter: JsonAdapter<List<Jsonkorean>> = moshi.adapter(listwords)

        val korean = adapter.fromJson(loadJson())

        return korean
    }

}