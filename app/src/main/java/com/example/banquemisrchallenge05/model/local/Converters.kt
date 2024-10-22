package com.example.banquemisrchallenge05.model.local

import androidx.room.TypeConverter
import com.example.banquemisrchallenge05.model.remote.genre
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromGenresToString(list: List<genre>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun fromStringToGenres(st: String): List<genre> {
        val listType = object : TypeToken<List<genre>>() {}.type
        return Gson().fromJson(st, listType)
    }

}