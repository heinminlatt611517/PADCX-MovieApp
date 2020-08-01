package com.example.padcx_movieapp_assignment.presistence.typeConverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenreTypeConverter {
    @TypeConverter
    fun toString(List: ArrayList<Int>) : String {
        return Gson().toJson(List)
    }

    @TypeConverter
    fun toList(ListJsonString: String) : ArrayList<Int>{
        val usetListType = object : TypeToken<ArrayList<Int>>() {}.type
        return Gson().fromJson(ListJsonString, usetListType)
    }
}