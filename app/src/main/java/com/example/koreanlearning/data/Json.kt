package com.example.koreanlearning.data

import android.content.Context
import android.os.ParcelFileDescriptor.open
import com.example.koreanlearning.R
import com.example.koreanlearning.model.Jsonkorean
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.File
import java.io.IOException
import java.lang.reflect.Array.get
import java.nio.channels.FileChannel.open
import java.nio.charset.Charset


class Json (private val context: Context){

    fun loadJson(words : String): String {
        val json: String?
        try {
            val input = context.assets.open("a1_routine.json")

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

    fun parseJson(koreanwords: String) : List<Jsonkorean>? {
        val moshi: Moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
        val listwords = Types.newParameterizedType(List::class.java, Jsonkorean::class.java)
        val adapter: JsonAdapter<List<Jsonkorean>> = moshi.adapter(listwords)

        val korean = adapter.fromJson(loadJson("a1_routine.json"))

        return korean
    }

}